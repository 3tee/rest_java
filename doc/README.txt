avd jar 调用说明：

1. jar 包引入
   avd-x.x.x.jar    －－3tee公司提供相关认证及创建会议等功能的核心jar
   json.jar         －－核心jar需要的第三方jar,可以直接引用，也可以通过maven加入:
						<dependency>
						    <groupId>org.json</groupId>
						    <artifactId>json</artifactId>
						    <version>20141113</version>
						</dependency>
						
2. improt jar
   
   import  com.t.avd.AuthServer;
   import com.t.avd.RoomServer;
   import  com.t.avd.exception.AuthException;
   import com.t.avd.exception.RoomException; 
   
 3. 认证相关调用demo:
    String restServer= "192.168.2.2";
    String accessKey= "demo_access";
    String secretKey= "demo_secret";
    AuthServer authServer = new  AuthServer(restServer,accessKey,secretKey);
    try{
         String accessTocken = authServer.getAccessTocken();
         System.out.println("ACCESS_TOKEN:"+ accessTocken);
         
    }catch(AuthException  authException){
	     System.out.println("authException:"+ authException.getKey() + ";" + authException.getMessage());
    }
    
    AuthServer 构造函数参数说明：
        restServer：必填项
              类型：String
              说明：rest server，如"192.168.2.2" 
                           
        accessKey：必填项
              类型：String
              说明：网络注册,获取的ACCESS_KEY 
              
        secretKey：必填项
              类型：String
              说明：网络注册,获取的SECRET_KEY 
    
    返回值：
         类型：String
         说明：ACCESS_TOKEN，创建会议用到
         
  
  4. 创建会议相关调用demo:
	   String restServer = "192.168.2.2"; 
	   String webServer= "192.168.2.2"; 
	   String accessTocken = "58cc702dbf0ad485eaf659750619d631e9cf29f2"; 
	   String topic = "top123"; 
	   int maxVideo = 5; 
	   int maxAudio = 5; 
	   String hostPassword = "20"; 
	   RoomServer roomServer = new  RoomServer(restServer,webServer,accessTocken,topic,maxVideo,maxAudio,hostPassword);
	   try{
	       String roomId = roomServer.createRoom();
	       System.out.println("roomId:"+ roomId);
	       
	       String roomURL = roomServer.getRoomURL();
	       System.out.println("roomURL:"+ roomURL);
	       
	   }catch(RoomException  roomException){
		   System.out.println(roomException.getKey() + ":" + roomException.getMessage());
	   }     
    
    RoomServer 构造函数参数说明：
       restServer：必填项
              类型：String
              说明：rest server，如"192.168.2.2" 
                           
       webServer：必填项
              类型：String
              说明：web server，如"192.168.2.2" 
              
       accessTocken：必填项
              类型：String
              说明：ACCESS_TOKEN
              
        topic：必填项
              类型：String
              说明：会议主题
        
        maxVideo：必填项
              类型：int
              说明：允许最大视频路数
              
        maxAudio：必填项
              类型：int
              说明：允许最大音频路数
              
        hostPassword：必填项
              类型：String
              说明：主持人密码，以该密码加会的，视为主持人
    
   
