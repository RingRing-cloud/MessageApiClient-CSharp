package be.ringring.message.model.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * POJO with message response data
**/
public class MessageResponse extends AbstractResponse {

	
	//--- PROPERTIES -------------------------------------//
	
	@JsonProperty("MessageCount")
	private Integer messageCount;
	
	@JsonProperty("Reference")
	private String reference;
	
	@JsonProperty("Messages")
	private List<Message> messages;

	
	//--- GETTERS AND SETTERS ----------------------------//
	
	public Integer getMessageCount() {
		return messageCount;
	}

	public void setMessageCount(Integer messageCount) {
		this.messageCount = messageCount;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	
	
}
