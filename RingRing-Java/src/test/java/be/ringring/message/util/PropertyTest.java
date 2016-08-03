package be.ringring.message.util;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.util.StringUtils;

import be.ringring.message.common.Property;


public class PropertyTest {

	@Test
	public void testGetProperty() {
		
		String url = Property.getInstance().get("ws-url");
		
		Assert.assertNotNull(url);
		Assert.assertTrue( ! StringUtils.isEmpty(url));
		
	}
	
}
