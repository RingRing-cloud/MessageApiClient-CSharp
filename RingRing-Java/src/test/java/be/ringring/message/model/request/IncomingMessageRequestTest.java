package be.ringring.message.model.request;

import org.junit.Assert;
import org.junit.Test;

public class IncomingMessageRequestTest {
	
	private static final String APIKEY = "1928376450-4682-915370-0561873492";
	private static final String MAXRECORDS = "50";
	
	@Test
	public void testBuilder() {
		
		IncomingMessageRequest request = new IncomingMessageRequest.Builder()
				.withApiKey(APIKEY)
				.withMaxRecords(MAXRECORDS)
				.build();
			
			Assert.assertNotNull(request);
			Assert.assertEquals(APIKEY, request.getApiKey());
			Assert.assertEquals(MAXRECORDS, request.getMaxRecords());
		
		
	}
	
}
