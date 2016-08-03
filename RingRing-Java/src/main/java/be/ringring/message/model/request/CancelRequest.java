package be.ringring.message.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * POJO with cancel request data.<br />
 * Mandatory fields : apiKey, messageID
**/

@JsonInclude(Include.NON_NULL)
public class CancelRequest extends AbstractRequest {

	@JsonProperty("MessageId")
	private String messageID;

	private CancelRequest(String apiKey) {
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
	 * CancelRequest builder.
	**/
	
	public static class Builder extends AbstractRequest.AbstractBuilder<Builder, CancelRequest> {
		
		private String messageID;

		/**
		 * Add a <code>messageID</code> value in the builder object.
		 * @param messageID The <code>messageID</code> value to set.
		 * @return Return the Builder itself for chaining call.
		**/
		
		public Builder withMessageID(String messageID) {
			this.messageID = messageID;
			return this;
		}

		/**
		 * @inheritDoc 
		**/
		
		@Override
		public CancelRequest build() {
			CancelRequest request = new CancelRequest(apiKey);
			request.messageID = this.messageID;
			return request;
		}
		
	}
	
}
