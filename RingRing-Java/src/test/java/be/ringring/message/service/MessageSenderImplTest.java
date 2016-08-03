package be.ringring.message.service;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import be.ringring.message.exception.MessageException;
import be.ringring.message.model.request.MessageRequest;
import be.ringring.message.model.response.MessageResponse;
import be.ringring.message.service.MessageService;

public class MessageSenderImplTest {

	
	private static String REFERENCE = "1234-5678-90";
	
	
	@Mock
	private MessageService service;
	
	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule(); 
	
	@Test
	public void sendMessage() throws MessageException {
		
		
		MessageRequest request = new MessageRequest.Builder()
			.withTo("123654789")
			.withMessage("Hello World")
			.build();
		
		MessageResponse response = new MessageResponse();
		response.setReference(REFERENCE);
		response.setResultCode(0);
		response.setResultDescription("Success");
		
		when(service.sendMessage(null)).thenReturn(null);
		when(service.sendMessage(request)).thenReturn(response);
		
		MessageResponse resp;
		
		resp = service.sendMessage(null);
		Assert.assertNull(resp);
		
		resp = service.sendMessage(request);
		Assert.assertNotNull(resp);
		Assert.assertEquals(resp.getReference(), REFERENCE);
		Assert.assertEquals(resp.getReference(), response.getReference());
	}
	
}
