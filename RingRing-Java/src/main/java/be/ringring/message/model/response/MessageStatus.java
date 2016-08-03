package be.ringring.message.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * StatusMessage is the entity who contains data for the status of one message.
**/

public class MessageStatus {
	
	@JsonProperty("MessageId")
	private String messageId;
	
	@JsonProperty("Reference")
	private String reference;
	
	@JsonProperty("StatusCode")
	private String statusCode;
	
	@JsonProperty("StatusDescription")
	private String statusDescription;
	
	@JsonProperty("TimeSubmitted")
	private String timeSubmitted;
	
	@JsonProperty("DeliveryTime")
	private String deliveryTime;
	
	@JsonProperty("Country")
	private String country;
	
	@JsonProperty("To")
	private String to;
	
	@JsonProperty("Message")
	private String message;
	
	@JsonProperty("ResultCode")
	private int resultCode;
	
	@JsonProperty("ResultDescription")
	private String resultDescription;

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

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusDescription() {
		return statusDescription;
	}

	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}

	public String getTimeSubmitted() {
		return timeSubmitted;
	}

	public void setTimeSubmitted(String timeSubmitted) {
		this.timeSubmitted = timeSubmitted;
	}

	public String getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultDescription() {
		return resultDescription;
	}

	public void setResultDescription(String resultDescription) {
		this.resultDescription = resultDescription;
	}
	
	
}
