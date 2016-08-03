package be.ringring.message.service;

import org.springframework.stereotype.Service;

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

/**
 * MessageService interface provide contract to<br />
 * <ul>
 * <li>Send a message : simply send a SMS to somebody.</li>
 * <li>Cancel a message : Allow you to cancel a SMS if it is not yet processed.</li>
 * <li>Get a message status : You can retrieve the status of one specified message.</li>
 * <li>Get the outgoing messages statuses : Retrieve the statuses of a range of outgoing messages.</li>
 * <li>Get the incoming messages statuses : Retrieve the statuses of a range of incoming messages.</li>
 * </ul>
**/

@Service("messageService")
public interface MessageService {
	
	/**
	 * Send a message to somebody using all possible values in {@link MessageRequest}.
	 * @param request The {@link MessageRequest} with data for the request.
	 * @return Return a {@link MessageResponse} with response details. 
	 * @throws MessageException Throws and exception with a detailed {@link Error} if a problem occurs.
	**/
	
	MessageResponse sendMessage(MessageRequest request) throws MessageException;
	
	/**
	 * Cancel a message if it isn't yet sended using all possible values in {@link CancelRequest}.
	 * @param messageID The message ID to identifiy the message to cancel.
	 * @return Return a {@link CancelResponse} with response details.
	 * @throws MessageException Throws and exception with a detailed {@link Error} if a problem occurs.
	**/
	
	CancelResponse cancelMessage(CancelRequest request) throws MessageException;
	
	/**
	 * Retrieve statuses of multiple outgoing messages using all possible values in {@link OutgoingMessageStatusRequest}.<br />
	 * Outgoing messages statuses can be returned only one time.<br />
	 * It means that all messages returned in the response will never be returned in the future.
	 * @param request The {@link OutgoingMessageStatusRequest} with data for the request.
	 * @return Return a {@link OutgoingMessageStatusResponse} with response details.
	 * @throws MessageException Throws and exception with a detailed {@link Error} if a problem occurs.
	**/
	
	OutgoingMessageStatusResponse getOutgoingMessagesStatuses(OutgoingMessageStatusRequest request) throws MessageException;
	
	/**
	 * Retrieve the status of a specified message using all possible values in {@link MessageStatusRequest}.
	 * @param request The {@link MessageStatusRequest} with data for the request.
	 * @return Return a {@link MessageStatusResponse} with response details.
	 * @throws MessageException Throws and exception with a detailed {@link Error} if a problem occurs.
	**/
	
	MessageStatusResponse getMessageStatus(MessageStatusRequest request) throws MessageException;
	
	/**
	 * Retrieve multiple incoming messages using all possible values in {@link IncomingMessageRequest}.<br />
	 * Incoming messages can be returned only one time.<br />
	 * It means that all messages returned in the response will never be returned in the future.
	 * @param request The {@link IncomingMessageRequest} with data for the request.
	 * @return Return a {@link IncomingMessageResponse} with response details.
	 * @throws MessageException Throws and exception with a detailed {@link Error} if a problem occurs.
	**/
	
	IncomingMessageResponse getIncomingMessages(IncomingMessageRequest request) throws MessageException;
	
}
