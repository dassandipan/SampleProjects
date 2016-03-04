package com.travelport.test.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class JettyInMemoryServer {
		 
		private Server server;
		private int port = 8090;
	 
		public int getPort() {
			return port;
		}
	 
		public void setPort(int port) {
			this.port = port;
		}
	 
		public void init() throws Exception {
			server = new Server(port);
			if(server.isRunning()){
				server.stop();
			}
			WebAppContext webAppContext = new WebAppContext();
			webAppContext.setContextPath("/springboot");
			webAppContext.setResourceBase("src/main/webapp");
			webAppContext.setServer(server);
			webAppContext.setClassLoader(ClassLoader.getSystemClassLoader());
			webAppContext.getSessionHandler().getSessionManager()
					.setMaxInactiveInterval(10);
			server.setHandler(webAppContext);
			server.start();
		}
		
		public void close() throws Exception{
			server.stop();
		}
	 
}
