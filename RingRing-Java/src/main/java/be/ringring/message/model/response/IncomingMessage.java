package be.ringring.message.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * IncomingMessage is the entity who contains data for the message sended by the source to the target.<br />
 * <br />
 * Example :<br />
 * Suppose source is 'A' and target is 'Z'<br />
 * If 'A' send a message to 'Z', the message represent a Message for 'A'.<br />
 * If 'A' receive a response from 'Z', the response message represent an IncomingMessage for 'A'.
**/
public class IncomingMessage {
	
	
	//--- PROPERTIES -------------------------------------//
	
	@JsonProperty("MessageId")
	private String messageId;
	
	@JsonProperty("Reference")
	private String reference;
	
	@JsonProperty("From")
	private String from;
	
	@JsonProperty("To")
	private String to;
	
	@JsonProperty("Message")
	private String message;
	
	@JsonProperty("Country")
	private String country;
	
	@JsonProperty("TimeReceived")
	private String timeReceived;

	
	//--- GETTERS AND SETTERS ----------------------------//
	
	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getTimeReceived() {
		return timeReceived;
	}

	public void setTimeReceived(String timeReceived) {
		this.timeReceived = timeReceived;
	}

	
}
