package be.ringring.message;

import be.ringring.message.common.Authentication;
import be.ringring.message.common.Endpoint;
import be.ringring.message.exception.Error;
import be.ringring.message.exception.MessageException;
import be.ringring.message.model.request.CancelRequest;
import be.ringring.message.model.request.IncomingMessageRequest;
import be.ringring.message.model.request.MessageRequest;
import be.ringring.message.model.request.MessageStatusRequest;
import be.ringring.message.model.request.OutgoingMessageStatusRequest;
import be.ringring.message.model.response.CancelResponse;
import be.ringring.message.model.response.IncomingMessageResponse;
import be.ringring.message.model.response.MessageResponse;
import be.ringring.message.model.response.MessageStatusResponse;
import be.ringring.message.model.response.OutgoingMessageStatusResponse;
import be.ringring.message.service.MessageService;
import be.ringring.message.service.MessageServiceImpl;

/**
 * MessageClient is the entry point of the library.<br /> 
 * <br />
 * Usage :<br />
 * <code>
 * <pre>
 * Authentication token = new Authentication(APIKEY);
 * MessageClient client = new MessageClient(token);
 * 		
 * // Example using simple parameters (usually mandatory parameters)
 * try {
 * 	client.createMessage(PHONE_NUMBER, YOUR_MESSAGE);
 * } catch (MessageException e) {
 * 	// ... 
 * }
 * 
 * // Example using request object (for detailed query) 
 * try {
 * 	client.createMessage(new MessageRequest.Builder()
 * 		.withTo(PHONE)
 * 		.withMessage(YOUR_MESSAGE)
 * 		//.withFrom(FROM_WHO)
 * 		//.withReference(YOUR_REFERENCE)
 * 		//.withTimeScheduled(DD/MM/YYYY)
 * 		//...
 * 		.build()
 * 		);
 * } catch (MessageException e) {
 * 	// ...
 * }
 * </pre>
 * </code>
**/

public class MessageClient {
	
	private MessageService service;
	
	/**
	 * Construct the MessageClient with authentication using default endpoint.<br />
	 * Default endpoint is Endpoint.V1 (official).
	 * @param authentication The authentication to have access to the api.
	**/
	
	public MessageClient(Authentication authentication) {
		this(authentication, Endpoint.V1);
	}
	
	/**
	 * Construct the MessageClient with an authentication using a specified endpoint.
	 * @param authentication The authentication to have access to the api.
	 * @param endpoint The endpoint where you want to make call.
	 * @see See {@link Endpoint} for possible values.
	**/
	
	public MessageClient(Authentication authentication, Endpoint endpoint) {
		if (authentication == null) {
			throw new IllegalArgumentException("Authentication cannot be null");
		}
		if (endpoint == null) {
			throw new IllegalArgumentException("Endpoint cannot be null");
		}
		this.service = new MessageServiceImpl(authentication, endpoint);
	}
	
	/**
	 * Create and send a message to somebody using mandatory data.
	 * @param to The target where the message have to be send.
	 * @param message The message to send.
	 * @return Return a {@link MessageResponse} with response details.
	 * @throws MessageException Throws and exception with a detailed {@link Error} if a problem occurs.
	**/
	
	public MessageResponse createMessage(String to, String message) throws MessageException {
		return this.createMessage(new MessageRequest.Builder()
			.withTo(to)
			.withMessage(message)
			.build()
		);
	}
	
	/**
	 * Create and send a message to somebody using all possible values in {@link MessageRequest}.
	 * @param request The {@link MessageRequest} with data for the request.
	 * @return Return a {@link MessageResponse} with response details. 
	 * @throws MessageException Throws and exception with a detailed {@link Error} if a problem occurs.
	**/
	
	public MessageResponse createMessage(MessageRequest request) throws MessageException {
		return this.service.sendMessage(request);
	}
	
	/**
	 * Cancel a message if it isn't yet sended using mandatory data.
	 * @param messageID The message ID to identifiy the message to cancel.
	 * @return Return a {@link CancelResponse} with response details.
	 * @throws MessageException Throws and exception with a detailed {@link Error} if a problem occurs.
	**/
	
	public CancelResponse cancelMessage(String messageID) throws MessageException {
		return this.cancelMessage(new CancelRequest.Builder()
			.withMessageID(messageID)
			.build()
		);
	}
	
	/**
	 * Cancel a message if it isn't yet sended using all possible values in {@link CancelRequest}.
	 * @param messageID The message ID to identifiy the message to cancel.
	 * @return Return a {@link CancelResponse} with response details.
	 * @throws MessageException Throws and exception with a detailed {@link Error} if a problem occurs.
	**/
	
	public CancelResponse cancelMessage(CancelRequest request) throws MessageException {
		return this.service.cancelMessage(request);
	}
	
	/**
	 * Retrieve the status of a specified message using mandatory data.
	 * Outgoing messages statuses can be returned only one time.<br />
	 * It means that all messages returned in the response will never be returned in the future.
	 * @return Return a {@link MessageStatusResponse} with response details.
	 * @throws MessageException Throws and exception with a detailed {@link Error} if a problem occurs.
	**/
	
	public MessageStatusResponse getMessageStatus(String messageID) throws MessageException {
		return this.getMessageStatus(new MessageStatusRequest.Builder()
			.withMessageID(messageID)
			.build()
		);
	}
	
	/**
	 * Retrieve the status of a specified message using all possible values in {@link MessageStatusRequest}.
	 * @param request The {@link MessageStatusRequest} with data for the request.
	 * @return Return a {@link MessageStatusResponse} with response details.
	 * @throws MessageException Throws and exception with a detailed {@link Error} if a problem occurs.
	**/
	
	public MessageStatusResponse getMessageStatus(MessageStatusRequest request) throws MessageException {
		return this.service.getMessageStatus(request);
	}
	
	/**
	 * Retrieve status of multiple outgoing messages.
	 * @return Return a {@link OutgoingMessageStatusResponse} with response details.
	 * @throws MessageException Throws and exception with a detailed {@link Error} if a problem occurs.
	**/
	
	public OutgoingMessageStatusResponse getOutgoingMessageStatuses() throws MessageException {
		return this.getOutgoingMessagesStatus(new OutgoingMessageStatusRequest.Builder()
			.build()
		);
	}
	
	/**
	 * Retrieve status of multiple outgoing messages using all possible values in {@link OutgoingMessageStatusRequest}.<br />
	 * Outgoing messages statuses can be returned only one time.<br />
	 * It means that all messages returned in the response will never be returned in the future.
	 * @param request The {@link OutgoingMessageStatusRequest} with data for the request.
	 * @return Return a {@link OutgoingMessageStatusResponse} with response details.
	 * @throws MessageException Throws and exception with a detailed {@link Error} if a problem occurs.
	**/
	
	public OutgoingMessageStatusResponse getOutgoingMessagesStatus(OutgoingMessageStatusRequest request) throws MessageException {
		return this.service.getOutgoingMessagesStatuses(request);
	}
	
	/**
	 * Retrieve multiple incoming messages.<br />
	 * Incoming messages can be returned only one time.<br />
	 * It means that all messages returned in the response will never be returned in the future.
	 * @return Return a {@link IncomingMessageResponse} with response details.
	 * @throws MessageException Throws and exception with a detailed {@link Error} if a problem occurs.
	**/
	
	public IncomingMessageResponse getIncomingMessages() throws MessageException {
		return this.getIncomingMessages(new IncomingMessageRequest.Builder()
				.build()
				);
	}
	
	/**
	 * Retrieve multiple incoming messages using all possible values in {@link IncomingMessageRequest}.<br />
	 * Incoming messages can be returned only one time.<br />
	 * It means that all messages returned in the response will never be returned in the future.
	 * @param request The {@link IncomingMessageRequest} with data for the request.
	 * @return Return a {@link IncomingMessageResponse} with response details.
	 * @throws MessageException Throws and exception with a detailed {@link Error} if a problem occurs.
	**/
	
	public IncomingMessageResponse getIncomingMessages(IncomingMessageRequest request) throws MessageException {
		return this.service.getIncomingMessages(request);
	}
	
}
