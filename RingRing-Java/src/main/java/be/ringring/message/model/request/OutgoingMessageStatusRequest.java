package be.ringring.message.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *	POJO with status request data 
**/
@JsonInclude(Include.NON_NULL)
public class OutgoingMessageStatusRequest extends AbstractRequest {

	@JsonProperty("MaxRecords")
	private String maxRecords;

	private OutgoingMessageStatusRequest(String apiKey) {
		super(apiKey);
	}
	
	/**
	 * Getter for the <code>maxRecords</code> attribute
	 * @return the <code>maxRecords</code> value
	**/
	
	public String getMaxRecords() {
		return maxRecords;
	}
	
	/**
	 * Request Object Builder.
	**/
	
	public static class Builder extends AbstractRequest.AbstractBuilder<Builder, OutgoingMessageStatusRequest> {
		
		private String maxRecords;

		/**
		 * Add the <code>maxRecords</code> value in the builder object.
		 * @param maxRecords The <code>maxRecords</code> value to set.
		 * @return Return the Builder itself for chaining call.
		**/
		
		public Builder withMaxRecords(String maxRecords) {
			this.maxRecords = maxRecords;
			return this;
		}

		/**
		 * @inheritDoc 
		**/
		
		@Override
		public OutgoingMessageStatusRequest build() {
			OutgoingMessageStatusRequest request = new OutgoingMessageStatusRequest(apiKey);
			request.maxRecords = this.maxRecords;
			return request;
		}
		
	}
}
