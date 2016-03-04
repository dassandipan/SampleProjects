package com.travelport.test;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.travelport.test.server.JettyInMemoryServer;
import com.travelport.test.util.TestUtils;

public class LocalInvocationSpringTest {

	private int port = 8987;
	private JettyInMemoryServer jettyMain = null;
	private HttpClient remoteClient = HttpClientBuilder.create().disableAutomaticRetries().build();

	@Before
	public void hostApplicationInJetty() {
		try {
			jettyMain = new JettyInMemoryServer();
			jettyMain.setPort(port);
			jettyMain.init();
			System.out.println("Server is Running on " + port + " Port...............");
		} catch (Exception e) {
			System.out.println("Exception Happened");
			e.printStackTrace();
		}
	}

	@Test
	public void runInMemoryJettyInvocation() throws ClientProtocolException, IOException {
		String url  = "http://localhost:"+port+"/springboot/schedule/get/19850907";
		System.out.println("Invoking following url: GET: "+url);
		HttpUriRequest request = new HttpGet(url);
		HttpResponse response = remoteClient.execute(request);
		System.out.println(TestUtils.extractRawResponse(response));	
	}
	
	@After
	public void shutDownJetty() throws Exception{
		jettyMain.close();
	}
}
