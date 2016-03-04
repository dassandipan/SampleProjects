package com.travelport.test.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.travelport.test.response.ResponseGenerator;
 
@Controller
public class ScheduleController {
 
	@Autowired
	private ResponseGenerator responseGenerator;
 
	public ResponseGenerator getResponseGenerator() {
		return responseGenerator;
	}
 
	public void setResponseGenerator(ResponseGenerator responseGenerator) {
		this.responseGenerator = responseGenerator;
	}
 
	@RequestMapping(value = "/insert", method = RequestMethod.POST, 
			consumes="application/json", produces="application/json")
	@ResponseBody
	public HttpServletResponse addRequest(@RequestBody byte[] requestBody,
			HttpServletResponse response) throws IOException {
		return responseGenerator.generateResponse(requestBody, response);
	}
 
	@RequestMapping(value = "/get/{scheduleId}", method = RequestMethod.GET)
	@ResponseBody
	public void getRequest(HttpServletResponse response, @PathVariable("scheduleId") Long scheduleId) throws IOException {
		responseGenerator.generateGetResponse(scheduleId, response);
	}
}