avd jar ����˵����

1. jar ������
   avd-x.x.x.jar    ����3tee��˾�ṩ�����֤����������ȹ��ܵĺ���jar
   json.jar         ��������jar��Ҫ�ĵ�����jar,����ֱ�����ã�Ҳ����ͨ��maven����:
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
   
 3. ��֤��ص���demo:
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
    
    AuthServer ���캯������˵����
        restServer��������
              ���ͣ�String
              ˵����rest server����"192.168.2.2" 
                           
        accessKey��������
              ���ͣ�String
              ˵��������ע��,��ȡ��ACCESS_KEY 
              
        secretKey��������
              ���ͣ�String
              ˵��������ע��,��ȡ��SECRET_KEY 
    
    ����ֵ��
         ���ͣ�String
         ˵����ACCESS_TOKEN�����������õ�
         
  
  4. ����������ص���demo:
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
    
    RoomServer ���캯������˵����
       restServer��������
              ���ͣ�String
              ˵����rest server����"192.168.2.2" 
                           
       webServer��������
              ���ͣ�String
              ˵����web server����"192.168.2.2" 
              
       accessTocken��������
              ���ͣ�String
              ˵����ACCESS_TOKEN
              
        topic��������
              ���ͣ�String
              ˵������������
        
        maxVideo��������
              ���ͣ�int
              ˵�������������Ƶ·��
              
        maxAudio��������
              ���ͣ�int
              ˵�������������Ƶ·��
              
        hostPassword��������
              ���ͣ�String
              ˵�������������룬�Ը�����ӻ�ģ���Ϊ������
    
   
