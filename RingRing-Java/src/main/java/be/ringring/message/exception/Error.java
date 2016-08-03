package be.ringring.message.exception;


/**
 * {@link Error} contains the list of all possible error or success code.
**/
public enum Error {
	
	TECHNICAL_ERROR					(900, "Technical Error"),

	HTTP_SUCCESS					(200, "Success"),
	HTTP_BAD_REQUEST				(400, "Bad request / Maintenance"),
	HTTP_FORBIDDEN_OR_THROTTLING	(403, "Forbidden / Throttling limit exceeded"),
	HTTP_INTERNAL_SERVER			(500, "Internal server"),
	
	API_SUCCESS						(0, "Success"),
	INTERNAL						(1, "Internal"), 
	GATEWAY_NOT_ACTIVE				(2, "Gateway not active"),
	TIME_SCHEDULED_INVALID			(3, "TimeScheduled invalid"),
	REFERENCE_TOO_LONG				(4, "Reference too long"),
	NUMBER_FROM_INVALID				(5, "Number From invalid"),
	NUMBER_FROM_INVALID_BIS			(6, "Number From invalid"),
	MESSAGE_EMPTY					(7, "Message empty"),
	MESSAGE_TOO_LONG				(8, "Message too long"),
	NUMBER_TO_INVALID				(9, "Number To invalid"),
	NUMBER_TO_INVALID_BIS			(10, "Number To invalid"),
	INTERNAL_NOT_RIGHT_APP_ID		(11, "Internal : Application not associated with a right AppId"),
	API_KEY_INVALID					(12, "ApiKey invalid"),
	XML_JSON_INVALID				(13, "XML or JSON invalid"),
	API_KEY_INVALID_BIS				(14, "ApiKey Invalid"),
	IP_ADDR_DENIED					(15, "IP Address denied"),
	RIP_INVALID						(16, "RIP invalid"),
	STATUS_URL_INVALID				(17, "StatusUrl invalid"),
	STATUS_METHOD_INVALID			(18, "StatusMethod invalid"),
	TIME_VALIDITY_INVALID			(19, "TimeValidity invalid"),
	NUMBER_TO_LIMIT_REACHED			(20, "Number To limit reached"),
	OUT_OF_TIME_WINDOWS				(21, "Out of Time Window"),
	TIME_VALIDITY_INVALID_BIS		(22, "TimeValidity invalid"),
	TIME_SCHEDULED_INVALID_BIS		(23, "TimeSchedule invalid"),
	MAX_RECORDS_INVALID				(24, "MaxRecords invalid"),
	MAX_RECORDS_INVALID_BIS			(25, "MaxRecords invalid"),
	MESSAGE_ID_INVALID				(26, "MessageId invalid"),
	MESSAGE_ALREADY_CANCELLED		(27, "Message already cancelled"),
	MESSAGE_ID_NOT_FOUND			(29, "MessageId not found"),
	X_RATE_LIMIT_REACHED			(30, "X-RateLimit reached"),
	SENDER_ID_INVALID				(31, "SenderId invalid"),
	NUMBER_TO_BLACKLISTED			(32, "Number To Blacklisted"),
	STATUS_FORMAT_INVALID			(33, "StatusFormat invalid"),
	MAINTENANCE						(34, "Maintenance, please retry later"),
	TRIAL_PERIOD_EXPIRED			(35, "Trial Period Expired"),
	MOBILE_NOT_AUTHORIZED			(36, "Mobile Not Authorized"),
	TRIAL_QUOTA_LIMIT_REACHED		(37, "Trial Quota Limit Reached");
	
	private Integer code;
	private String description;
	
	private Error(Integer code, String description) {
		this.code = code;
		this.description = description;
	}
	
	/**
	 * Getter of the <code>code</code> attribute
	 * @return Return the <code>code</code> value
	**/
	
	public Integer getCode() {
		return this.code;
	}
	
	/**
	 * Getter of the <code>description</code> attribute
	 * @return Return the <code>description</code> value
	**/
	
	public String getDescription() {
		return this.description;
	}
	
	/**
	 * This method look for an error identified by a given code and return it.  
	 * @param code The error code you are looking for.
	 * @return The error corresponding to the code you have used.
	**/
	
	public static Error findByCode(Integer code) {
		for (Error error : Error.values()) {
			if (error.code == code) {
				return error;
			}
		}
		return null;
	}
	
}
