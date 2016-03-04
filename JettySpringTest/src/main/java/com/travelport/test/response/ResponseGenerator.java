package com.travelport.test.response;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
 
@Component
public class ResponseGenerator {
 
	@Autowired
	private ObjectMapper mapper;
 
	public ObjectMapper getMapper() {
		return mapper;
	}
 
	public void setMapper(ObjectMapper mapper) {
		this.mapper = mapper;
	}
 
	public HttpServletResponse generateResponse(byte[] requestBody,
			HttpServletResponse servletResponse) {
		servletResponse.setContentType("application/json");
		servletResponse.setStatus(HttpServletResponse.SC_OK);
		String s = new String(requestBody);
		Schedule schedule = null;
		try {
			schedule = mapper.readValue(s, Schedule.class);
			mapper.writeValue(servletResponse.getOutputStream(), schedule);
		} catch (JsonParseException e) {
			servletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		} catch (JsonMappingException e) {
			servletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		} catch (IOException e) {
			servletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
		return servletResponse;
	}
 
	public HttpServletResponse generateGetResponse(Long scheduleId,
			HttpServletResponse servletResponse)
			throws JsonGenerationException, JsonMappingException, IOException {
		servletResponse.setContentType("application/json");
		servletResponse.setStatus(HttpServletResponse.SC_OK);
		Schedule schedule = new Schedule();
		schedule.setScheduleId(scheduleId);
		schedule.setScheduleStartDate(new Date());
		schedule.setDuration(1000l);
		mapper.writeValue(servletResponse.getOutputStream(), schedule);
		return servletResponse;
	}
 
}
