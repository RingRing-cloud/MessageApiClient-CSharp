package be.ringring.message.model.request;

import org.junit.Assert;
import org.junit.Test;

public class MessageStatusRequestTest {
	
	private static final String APIKEY = "1928376450-4682-915370-0561873492";
	private static final String MESSAGEID = "0561539682-346730-4742-1928578910";
	
	@Test
	public void testBuilder() {
		
		MessageStatusRequest request = new MessageStatusRequest.Builder()
				.withApiKey(APIKEY)
				.withMessageID(MESSAGEID)
				.build();
			
			Assert.assertNotNull(request);
			Assert.assertEquals(APIKEY, request.getApiKey());
			Assert.assertEquals(MESSAGEID, request.getMessageID());
		
		
	}
	
}
