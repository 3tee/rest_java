package com.t.avd;

public class RestSdk {
	
	public static  String  restServer;
	
	public static  String  webServer;
	
	
	public static  void   init(String serverStr){
		restServer  = serverStr;
		webServer = getWebServer();
	}
	
	private static  String getWebServer() {
		  //TDODO  �������˷���WebServer
		  //����ʱ���� restServer
		  return RestSdk.restServer;
	  }
	
	public static void main(String[] args) throws Exception {
		 RestSdk.init("192.168.2.2");
		 System.out.println("restServer:"+ RestSdk.restServer);
		 System.out.println("webServer:"+ RestSdk.webServer);
	}
}


