package be.ringring.message.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import be.ringring.message.common.Authentication;
import be.ringring.message.common.Endpoint;
import be.ringring.message.exception.Error;
import be.ringring.message.exception.MessageException;
import be.ringring.message.model.request.AbstractRequest;
import be.ringring.message.model.request.CancelRequest;
import be.ringring.message.model.request.IncomingMessageRequest;
import be.ringring.message.model.request.MessageRequest;
import be.ringring.message.model.request.MessageStatusRequest;
import be.ringring.message.model.request.OutgoingMessageStatusRequest;
import be.ringring.message.model.response.AbstractResponse;
import be.ringring.message.model.response.CancelResponse;
import be.ringring.message.model.response.IncomingMessageResponse;
import be.ringring.message.model.response.MessageResponse;
import be.ringring.message.model.response.MessageStatusResponse;
import be.ringring.message.model.response.OutgoingMessageStatusResponse;

/**
 * Implementation of {@link MessageService} interface
**/
@Service("messageService")
public class MessageServiceImpl implements MessageService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MessageServiceImpl.class);
	
	private Authentication authentication;
	private Endpoint endpoint;

	/**
	 * Constructor.
	 * @param apiKey The api key to grant access to the web service.
	 * @param endpoint The endpoint to use for the url. Choose SANDBOX if you don't want to send the sms or V1 if you want to send it.
	**/
	
	public MessageServiceImpl(Authentication authentication, Endpoint endpoint) {
		if (authentication == null) {
			throw new IllegalArgumentException("Authentication cannot be null");
		}
		if (endpoint == null) {
			throw new IllegalArgumentException("Endpoint cannot be null");
		}
		this.authentication = authentication;
		this.endpoint = endpoint;
	}
	
	/**
	 * @inheritDoc 
	**/
	
	@Override
	public MessageResponse sendMessage(MessageRequest request) throws MessageException {
		addKey(request);
		return post("/Message",  request,  MessageResponse.class);
	}

	/**
	 * @inheritDoc 
	**/
	
	@Override
	public CancelResponse cancelMessage(CancelRequest request) throws MessageException {
		addKey(request);
		return post("/Cancel", request, CancelResponse.class);
	}
	
	/**
	 * @inheritDoc 
	**/
	
	@Override
	public OutgoingMessageStatusResponse getOutgoingMessagesStatuses(OutgoingMessageStatusRequest request) throws MessageException {
		addKey(request);
		return post("/Status", request, OutgoingMessageStatusResponse.class);
	}

	/**
	 * @inheritDoc 
	**/
	
	@Override
	public MessageStatusResponse getMessageStatus(MessageStatusRequest request) throws MessageException {
		addKey(request);
		return post("/StatusMessage", request, MessageStatusResponse.class);
	}

	/**
	 * @inheritDoc 
	**/
	
	@Override
	public IncomingMessageResponse getIncomingMessages(IncomingMessageRequest request) throws MessageException {
		addKey(request);
		return post("/Incoming", request, IncomingMessageResponse.class);
	}
	
	private void addKey(AbstractRequest request) {
		if (StringUtils.isEmpty(request.getApiKey())) {
			request.setApiKey(authentication.getToken());
		}
	}
	
	private <T extends AbstractResponse> T post(String action, AbstractRequest data, Class<T> type) throws MessageException {
		
		HttpURLConnection connection = null;
		InputStream inputStream = null;
		
		try {
			
			connection = (HttpURLConnection) new URL(this.endpoint.forAction(action)).openConnection();
			LOGGER.info("HTTP connection : open {}", this.endpoint.forAction(action));
			connection.setDoInput(true);
			connection.setRequestProperty("Accept", "application/json");
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			connection.getOutputStream().write(data.toJSON().getBytes("UTF-8"));
			
			int responseCode = connection.getResponseCode();
			
			if (responseCode == HttpURLConnection.HTTP_OK || responseCode == HttpURLConnection.HTTP_CREATED) {
				
				inputStream = connection.getInputStream();
				ObjectMapper mapper = new ObjectMapper();
				mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				T result = mapper.readValue(inputStream, type);
				LOGGER.info("Response : {}", result);
				return result;
				
			} else {
				
				Error error = Error.findByCode(responseCode);
				throw new MessageException(error != null ? error : Error.TECHNICAL_ERROR);
				
			}
			
		} catch (IOException e) {
			
			throw new MessageException(Error.TECHNICAL_ERROR, e);
			
		} finally {
			
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					throw new MessageException(Error.TECHNICAL_ERROR, e);
				}
			}
			
			if (connection != null) {
				connection.disconnect();
				LOGGER.info("HTTP connection : close");
			}
			
		}
	}
	
}