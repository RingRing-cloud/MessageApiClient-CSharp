package be.ringring.message.common;

import org.junit.Assert;
import org.junit.Test;

public class AuthenticationTest {

	private static final String APIKEY = "1928376450-4682-915370-0561873492";
	
	@Test
	public void testConstruct() {
		
		Authentication authentication;

		try {
			
			authentication = new Authentication(APIKEY);

			Assert.assertNotNull(authentication);
			Assert.assertEquals(APIKEY, authentication.getToken());
			
			authentication = new Authentication(null);
			
			Assert.fail("Should throw an IllegalArgumentException !");
			
		} catch (IllegalArgumentException e) {
			
			Assert.assertNotNull(e);
			
		}
		
	}
	
}
