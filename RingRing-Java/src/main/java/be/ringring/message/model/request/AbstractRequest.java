package be.ringring.message.model.request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import be.ringring.message.common.Convertable;

/**
 * Abstract POJO for common request data.
 * Contains the field "ApiKey" mandatory for each request.
**/

public abstract class AbstractRequest implements Convertable {

	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractRequest.class);
	
	@JsonProperty("ApiKey")
	private String apiKey;
	
	protected AbstractRequest(String apiKey) {
		this.apiKey = apiKey;
	}
	
	/**
	 * Getter for the <code>apiKey</code> attribute
	 * @return the <code>apiKey</code> value
	**/
	
	public String getApiKey() {
		return apiKey;
	}
	
	/**
	 * Setter for the <code>apiKey</code> attribute 
	 * @param apiKey The <code>apiKey</code> value to set
	**/
	
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	/**
	 * @inheritDoc 
	**/
	
	@Override
	public String toJSON() {
		//return Converter.getJSON(this);
		
		String json = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			json = mapper.writeValueAsString(this);
		} catch(JsonProcessingException e) {
			LOGGER.error("Unable to parse object", e);
		}
		return json;
	}
	
	/**
	 * Generic builder with common properties.
	 * @param <T> The Builder implementation class
	 * @param <R> The Request object to build
	**/
	
	public abstract static class AbstractBuilder<T, R extends AbstractRequest> {
	
		protected String apiKey;

		/**
		 * Add the <code>apiKey</code> value in the builder object.
		 * @param apiKey The <code>apiKey</code> value to set.
		 * @return Return the Builder itself for chaining call.
		**/
		
		@SuppressWarnings("unchecked")
		public T withApiKey(String apiKey) {
			this.apiKey = apiKey;
			return (T) this;
		}
		
		/**
		 * This method build the request object by mapping properties.
		 * @return Return the request object with mapped properties.
		**/
		
		public abstract R build();
		
	}
}
