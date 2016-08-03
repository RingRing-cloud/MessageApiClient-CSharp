package be.ringring.message.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * POJO with message request data 
**/

@JsonInclude(Include.NON_NULL)
public class MessageRequest extends AbstractRequest {
	
	@JsonProperty("To")
	private String to;
	
	@JsonProperty("Message")
	private String message;
	
	@JsonProperty("From")
	private String from;
	
	@JsonProperty("SenderId")
	private String senderID;
	
	@JsonProperty("TimeValidity")
	private String timeValidity;
	
	@JsonProperty("TimeScheduled")
	private String timeScheduled;
	
	@JsonProperty("Reference")
	private String reference;
	
	@JsonProperty("ReplaceIfPresent")
	private String replaceIfPresent;
	
	@JsonProperty("StatusUrl")
	private String statusURL;
	
	@JsonProperty("StatusMethod")
	private String statusMethod;
	
	@JsonProperty("StatusFormat")
	private String statusFormat;

	private MessageRequest(String apiKey) {
		super(apiKey);
	}
	
	
	/**
	 * Getter for the <code>to</code> attribute
	 * @return the <code>to</code> value
	**/
	
	public String getTo() {
		return to;
	}
	
	/**
	 * Getter for the <code>message</code> attribute
	 * @return the <code>message</code> value
	**/

	public String getMessage() {
		return message;
	}
	
	/**
	 * Getter for the <code>from</code> attribute
	 * @return the <code>from</code> value
	**/

	public String getFrom() {
		return from;
	}
	
	/**
	 * Getter for the <code>senderID</code> attribute
	 * @return the <code>senderID</code> value
	**/
	
	public String getSenderID() {
		return senderID;
	}

	/**
	 * Getter for the <code>timeValidity</code> attribute
	 * @return the <code>timeValidity</code> value
	**/
	
	public String getTimeValidity() {
		return timeValidity;
	}
	
	/**
	 * Getter for the <code>timeScheduled</code> attribute
	 * @return the <code>timeScheduled</code> value
	**/
	
	public String getTimeScheduled() {
		return timeScheduled;
	}
	
	/**
	 * Getter for the <code>reference</code> attribute
	 * @return the <code>reference</code> value
	**/
	
	public String getReference() {
		return reference;
	}
	
	/**
	 * Getter for the <code>replaceIfPresent</code> attribute
	 * @return the <code>replaceIfPresent</code> value
	**/

	public String getReplaceIfPresent() {
		return replaceIfPresent;
	}

	/**
	 * Getter for the <code>statusURL</code> attribute
	 * @return the <code>statusURL</code> value
	**/
	
	public String getStatusURL() {
		return statusURL;
	}

	/**
	 * Getter for the <code>statusMethod</code> attribute
	 * @return the <code>statusMethod</code> value
	**/
	
	public String getStatusMethod() {
		return statusMethod;
	}

	/**
	 * Getter for the <code>statusFormat</code> attribute
	 * @return the <code>statusFormat</code> value
	**/
	
	public String getStatusFormat() {
		return statusFormat;
	}
	
	/**
	 * Request builder.
	**/
	
	public static class Builder extends AbstractRequest.AbstractBuilder<Builder, MessageRequest> {
		
		private String to;
		private String message;
		private String from;
		private String senderID;
		private String timeValidity;
		private String timeScheduled;
		private String reference;
		private String replaceIfPresent;
		private String statusURL;
		private String statusMethod;
		private String statusFormat;

		/**
		 * Add the <code>to</code> value in the builder object.
		 * @param to The <code>to</code> value to set.
		 * @return Return the Builder itself for chaining call.
		**/
		
		public Builder withTo(String to) {
			this.to = to;
			return this;
		}
		
		/**
		 * Add the <code>message</code> value in the builder object.
		 * @param message The <code>message</code> value to set.
		 * @return Return the Builder itself for chaining call.
		**/
		
		public Builder withMessage(String message) {
			this.message = message;
			return this;
		}
		
		/**
		 * Add the <code>from</code> value in the builder object.
		 * @param from The <code>from</code> value to set.
		 * @return Return the Builder itself for chaining call.
		**/
		
		public Builder withFrom(String from) {
			this.from = from;
			return this;
		}
		
		/**
		 * Add the <code>senderID</code> value in the builder object.
		 * @param senderID The <code>senderID</code> value to set.
		 * @return Return the Builder itself for chaining call.
		**/
		
		public Builder withSenderID(String senderID) {
			this.senderID = senderID;
			return this;
		}
		
		/**
		 * Add the <code>timeValidity</code> value in the builder object.
		 * @param timeValidity The <code>timeValidity</code> value to set.
		 * @return Return the Builder itself for chaining call.
		**/
		
		public Builder withTimeValidity(String timeValidity) {
			this.timeValidity = timeValidity;
			return this;
		}
		
		/**
		 * Add the <code>timeScheduled</code> value in the builder object.
		 * @param timeScheduled The <code>timeScheduled</code> value to set.
		 * @return Return the Builder itself for chaining call.
		**/
		
		public Builder withTimeScheduled(String timeScheduled) {
			this.timeScheduled = timeScheduled;
			return this;
		}
		
		/**
		 * Add the <code>reference</code> value in the builder object.
		 * @param reference The <code>reference</code> value to set.
		 * @return Return the Builder itself for chaining call.
		**/
		
		public Builder withReference(String reference) {
			this.reference = reference;
			return this;
		}
		
		/**
		 * Add the <code>replaceIfPresent</code> value in the builder object.
		 * @param replaceIfPresent The <code>replaceIfPresent</code> value to set.
		 * @return Return the Builder itself for chaining call.
		**/
		
		public Builder withReplaceIfPresent(String replaceIfPresent) {
			this.replaceIfPresent = replaceIfPresent;
			return this;
		}
		
		/**
		 * Add the <code>statusURL</code> value in the builder object.
		 * @param statusURL The <code>statusURL</code> value to set.
		 * @return Return the Builder itself for chaining call.
		**/
		
		public Builder withStatusURL(String statusURL) {
			this.statusURL = statusURL;
			return this;
		}
		
		/**
		 * Add the <code>statusMethod</code> value in the builder object.
		 * @param statusMethod The <code>statusMethod</code> value to set.
		 * @return Return the Builder itself for chaining call.
		**/
		
		public Builder withStatusMethod(String statusMethod) {
			this.statusMethod = statusMethod;
			return this;
		}
		
		/**
		 * Add the <code>statusFormat</code> value in the builder object.
		 * @param statusFormat The <code>statusFormat</code> value to set.
		 * @return Return the Builder itself for chaining call.
		**/
		
		public Builder withStatusFormat(String statusFormat) {
			this.statusFormat = statusFormat;
			return this;
		}
	
		/**
		 * @inheritDoc
		**/
		
		@Override
		public MessageRequest build() {
			MessageRequest request = new MessageRequest(apiKey);
			request.to = this.to;
			request.message = this.message;
			request.from = this.from;
			request.senderID = this.senderID;
			request.timeValidity = this.timeValidity;
			request.timeScheduled = this.timeScheduled;
			request.reference = this.reference;
			request.replaceIfPresent = this.replaceIfPresent;
			request.statusURL = this.statusURL;
			request.statusMethod = this.statusMethod;
			request.statusFormat = this.statusFormat;
			return request;
		}
	
	}
	
	
}
