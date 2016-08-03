package be.ringring.message.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Abstract POJO for common response data.
 * Contains the field "ResultCode" and "ResultDescripption", present on all kind of response.
**/
public abstract class AbstractResponse { // maybe implements Convertable

	
	//--- PROPERTIES -------------------------------------//
	
	@JsonProperty("ResultCode")
	protected Integer resultCode;
	
	@JsonProperty("ResultDescription")
	protected String resultDescription;

	
	//--- GETTERS AND SETTERS ----------------------------//
	
	public Integer getResultCode() {
		return resultCode;
	}

	public void setResultCode(Integer resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultDescription() {
		return resultDescription;
	}

	public void setResultDescription(String resultDescription) {
		this.resultDescription = resultDescription;
	}
	
	
}
