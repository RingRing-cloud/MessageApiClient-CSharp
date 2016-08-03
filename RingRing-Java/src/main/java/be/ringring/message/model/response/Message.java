package be.ringring.message.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Message is the entity who contains data for the message sended by the source to the target.<br />
 * <br />
 * Example :<br />
 * Suppose source is 'A' and target is 'Z'
 * If 'A' send a message to 'Z', the message represent a Message for 'A'.<br />
 * If 'A' receive a response from 'Z', the response message represent an IncomingMessage for 'A'.
**/
public class Message {
	
	
	//--- PROPERTIES -------------------------------------//
	
	@JsonProperty("MessageId")
	private String messageID;
	
	@JsonProperty("To")
	private String to;
	
	@JsonProperty("ResultCode")
	private Integer resultCode;
	
	@JsonProperty("ResultDescription")
	private String resultDescription;

	
	//--- GETTERS AND SETTERS ----------------------------//
	
	public String getMessageID() {
		return messageID;
	}

	public void setMessageID(String messageID) {
		this.messageID = messageID;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Integer getResultCode() {
		return resultCode;
	}

	public void setResultCode(Integer resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultDescription() {
		return resultDescription;
	}

	public void setResultDescription(String resultDescription) {
		this.resultDescription = resultDescription;
	}
	
	
}
