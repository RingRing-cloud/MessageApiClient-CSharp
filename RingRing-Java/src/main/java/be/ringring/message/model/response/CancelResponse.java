package be.ringring.message.model.response;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * POJO with cancel response. 
**/
public class CancelResponse extends AbstractResponse {

	
	//--- PROPERTIES -------------------------------------//
	
	@JsonProperty("MessageId")
	private UUID messageId;

	
	//--- GETTERS AND SETTERS ----------------------------//
	
	public UUID getMessageId() {
		return messageId;
	}

	public void setMessageId(UUID messageId) {
		this.messageId = messageId;
	}

}
