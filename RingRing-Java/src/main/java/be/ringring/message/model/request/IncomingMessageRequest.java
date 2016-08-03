package be.ringring.message.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * POJO with incoming message request data 
**/

@JsonInclude(Include.NON_NULL)
public class IncomingMessageRequest extends AbstractRequest {

	@JsonProperty("MaxRecords")
    private String maxRecords;

	private IncomingMessageRequest(String apiKey) {
		super(apiKey);
	}
	
	/**
	 * Getter for the <code>maxRecords</code> attribute
	 * @return the <code>maxRecords </code> value
	**/
	
	public String getMaxRecords() {
		return maxRecords;
	}
	
	/**
	 * IncomingMessageRequest builder.
	**/

	public static class Builder extends AbstractRequest.AbstractBuilder<Builder, IncomingMessageRequest> {
		
		private String maxRecords;

		/**
		 * Add the <code>maxRecords</code> value in the builder object.
		 * @param maxRecords The <code>maxRecords</code> value to set.
		 * @return Return the Builder it-self for chaining call.
		**/
		
		public Builder withMaxRecords(String maxRecords) {
			this.maxRecords = maxRecords;
			return this;
		}

		/**
		 * @inheritDoc 
		**/
		
		@Override
		public IncomingMessageRequest build() {
			IncomingMessageRequest request = new IncomingMessageRequest(apiKey);
			request.maxRecords = this.maxRecords;
			return request;
		}
		
	}
	
}
