package be.ringring.message.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * POJO with status message request
**/

@JsonInclude(Include.NON_NULL)
public class MessageStatusRequest extends AbstractRequest {

	@JsonProperty("MessageId")
	private String messageID;

	private MessageStatusRequest(String apiKey) {
		super(apiKey);
	}

	/**
	 * Getter for the <code>messageID</code> attribute
	 * @return the <code>messageID</code> value
	**/

	public String getMessageID() {
		return messageID;
	}
	
	/**
	 * Request builder.
	**/
	
	public static class Builder extends AbstractRequest.AbstractBuilder<Builder, MessageStatusRequest> {
		
		private String messageID;

		/**
		 * Add the <code>messageID</code> value in the builder object.
		 * @param messageID The <code>messageID</code> value to set.
		 * @return Return the Builder itself for chaining call.
		**/
		
		public Builder withMessageID(String messageID) {
			this.messageID = messageID;
			return this;
		}
		
		/**
		 * Request builder.
		**/

		@Override
		public MessageStatusRequest build() {
			MessageStatusRequest request = new MessageStatusRequest(apiKey);
			request.messageID = this.messageID;
			return request;
		}

	}
}
