package be.ringring.message.model.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * POJO with status response 
**/
public class OutgoingMessageStatusResponse extends AbstractResponse {

	
	//--- PROPERTIES -------------------------------------//
	
	@JsonProperty("NumberOfRecords")
    private Integer numberOfRecords;
	
	@JsonProperty("RemainingRecords")
	private Integer remainingRecords;
	
	@JsonProperty("StatusMessages")
    private List<MessageStatus> statusMessages;


	//--- GETTERS AND SETTERS ----------------------------//
	
	public Integer getNumberOfRecords() {
		return numberOfRecords;
	}

	public void setNumberOfRecords(Integer numberOfRecords) {
		this.numberOfRecords = numberOfRecords;
	}

	public Integer getRemainingRecords() {
		return remainingRecords;
	}

	public void setRemainingRecords(Integer remainingRecords) {
		this.remainingRecords = remainingRecords;
	}

	public List<MessageStatus> getStatusMessages() {
		return statusMessages;
	}

	public void setStatusMessages(List<MessageStatus> statusMessages) {
		this.statusMessages = statusMessages;
	}
	
	
}
