package be.ringring.message.common;

/**
 * {@link Endpoint} contains data to generate endpoint URL's<br />
 * There are 2 possible values to create an {@link Endpoint} :
 * <ul>
 * <li>SANDBOX : This is the option to use the service without sending real messages to terminals.</li>
 * <li>V1 : This is the option to use the for real condition and sending real messages to terminals.</li>
 * </ul>
**/

public enum Endpoint {
	
	SANDBOX("sandbox"),
	V1("v1");
	
	private String url;
	
	private Endpoint(String version) {
		this.url = String.format(Property.getInstance().get("ws-url"), version);
	}
	
	/**
	 * Get the full endpoint URL for an action.
	 * @return Return the endpoint url generated for the specified action
	**/
	
	public String forAction(String action) {
		return this.url + action;
	}

}
