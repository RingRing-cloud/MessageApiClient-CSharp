package be.ringring.message.model.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * POJO with incoming message response data
**/
public class IncomingMessageResponse extends AbstractResponse {

	
	//--- PROPERTIES -------------------------------------//
	
	@JsonProperty("NumberOfRecords")
    private String numberOfRecords;

	@JsonProperty("RemainingRecords")
    private String remainingRecords;
	
	@JsonProperty("IncomingMessages")
	private List<IncomingMessage> incomingMessages;

	
	//--- GETTERS AND SETTERS ----------------------------//
	
	public String getNumberOfRecords() {
		return numberOfRecords;
	}

	public void setNumberOfRecords(String numberOfRecords) {
		this.numberOfRecords = numberOfRecords;
	}

	public String getRemainingRecords() {
		return remainingRecords;
	}

	public void setRemainingRecords(String remainingRecords) {
		this.remainingRecords = remainingRecords;
	}

	public List<IncomingMessage> getIncomingMessages() {
		return incomingMessages;
	}

	public void setIncomingMessages(List<IncomingMessage> incomingMessages) {
		this.incomingMessages = incomingMessages;
	}

	
}
