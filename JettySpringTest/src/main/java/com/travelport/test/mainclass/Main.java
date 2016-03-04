package com.travelport.test.mainclass;

import com.travelport.test.server.JettyInMemoryServer;

public class Main {
	public static void main(String[] args) throws Exception {
		int port = 8282;
		JettyInMemoryServer jettyMain = null;
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
}