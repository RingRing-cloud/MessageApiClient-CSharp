package be.ringring.message.common;

/**
 * Authentication store the access key to use the api
**/

public class Authentication {
	
	private String token;
	
	/**
	 * Construct a {@link Authentication} object with the token for grant access.
	 * @param token The key used to be authenticated.
	**/
	
	public Authentication(String token) {
		if (token == null) {
			throw new IllegalArgumentException("Token cannot be null");
		}
		this.token = token;
	}
	
	/**
	 * Get the token used for the {@link Authentication}.
	 * Return the token used for {@link Authentication}.
	**/
	
	public String getToken() {
		return this.token;
	}
	
}
