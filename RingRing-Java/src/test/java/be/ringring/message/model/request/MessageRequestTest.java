package be.ringring.message.model.request;

import org.junit.Assert;
import org.junit.Test;

public class MessageRequestTest {
	
	private static final String APIKEY = "1928376450-4682-915370-0561873492";
	private static final String TO = "3298765410";
	private static final String MESSAGE = "You've got mail";
	private static final String FROM = "3298765410";
	private static final String REFERENCE = "0561539682-346730-4742-1928578910";
	private static final String SENDERID = "RingRing";
	private static final String REPLACE = "true";
	private static final String SCHEDULED = "31/12/2016";
	private static final String VALIDITY = "15/01/2017";
	private static final String STATUSFORMAT = "text/json";
	private static final String STATUSMETHOD = "getMethod";
	private static final String STATUSURL = "https://www.ringring.be/status";
	
	@Test
	public void testBuilder() {
		
		MessageRequest request = new MessageRequest.Builder()
			.withApiKey(APIKEY)
			.withTo(TO)
			.withMessage(MESSAGE)
			.withFrom(FROM)
			.withReference(REFERENCE)
			.withSenderID(SENDERID)
			.withReplaceIfPresent(REPLACE)
			.withTimeScheduled(SCHEDULED)
			.withTimeValidity(VALIDITY)
			.withStatusFormat(STATUSFORMAT)
			.withStatusMethod(STATUSMETHOD)
			.withStatusURL(STATUSURL)
			.build();
		
		Assert.assertNotNull(request);
		Assert.assertEquals(APIKEY, request.getApiKey());
		Assert.assertEquals(TO, request.getTo());
		Assert.assertEquals(MESSAGE, request.getMessage());
		Assert.assertEquals(FROM, request.getFrom());
		Assert.assertEquals(REFERENCE, request.getReference());
		Assert.assertEquals(SENDERID, request.getSenderID());
		Assert.assertEquals(REPLACE, request.getReplaceIfPresent());
		Assert.assertEquals(SCHEDULED, request.getTimeScheduled());
		Assert.assertEquals(VALIDITY, request.getTimeValidity());
		Assert.assertEquals(STATUSFORMAT, request.getStatusFormat());
		Assert.assertEquals(STATUSMETHOD, request.getStatusMethod());
		Assert.assertEquals(STATUSURL, request.getStatusURL());
		
	}
	
}
