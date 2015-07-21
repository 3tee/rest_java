package com.t.avd;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.json.JSONObject;

import com.t.avd.exception.RoomException;

/**	
 * 会议相关
 * @author roymond.wang
 * @date 2015.5.18
 */
public class  RoomServer {
	  private final String accessTocken;
	  
	  private final String topic;
	  private final int maxVideo;
	  private final int maxAudio;
	  private final String hostPassword;
	  private final int  roomMode = 1;
	  
	  public RoomServer(String accessTocken ,String topic, int maxVideo, int maxAudio, String hostPassword) {
		  this.accessTocken = accessTocken;
		  this.topic =  URLEncoder.encode(topic);
		  this.maxVideo = maxVideo;
		  this.maxAudio = maxAudio;
		  this.hostPassword = hostPassword;
	  }

	  public String createRoom() throws RoomException{
		     try {
		    	 String createRet = create();
		    	 if(createRet != null &&  ! "".equalsIgnoreCase(createRet)){
		    		 JSONObject jsonObject = new JSONObject(createRet);
		    		 String ret = jsonObject.getString("ret");
		    		 if("0".equalsIgnoreCase(ret)){
		    			 String roomId = jsonObject.getString("room_id");
		    			 return roomId;
		    		 }else{
		    			 String msg = jsonObject.getString("msg");
		    			 throw new RoomException(ret, msg); 
		    		 }
		    	 }else{
		    		 throw new RoomException("401", "un created"); 
		    	 }
		     } catch (Exception e) { 
		    	 throw new RoomException("401", "un created"); 
		     }
	  }
	 
	  
	  public Room getRoom(String roomId) throws RoomException{
		   String roomURL="http://" + RestSdk.webServer  + "/jroom/?roomId=" + roomId;
		   Room room = new Room();
		   room.setRoomId(roomId);
		   room.setRoomURL(roomURL);
		   return room;
	  }
		 
		 	
	  private  String create() throws Exception {
			    String urlStr = "http://" + RestSdk.restServer + "/rtc/room/create?owner_id=111111&access_tocken=" + accessTocken + "&room_mode=" + roomMode+ "&topic=" + topic+ "&max_video=" + maxVideo+ "&max_audio=" + maxAudio+ "&host_password=" + hostPassword;
			    URL localURL = new URL(urlStr);
		      	URLConnection connection = localURL.openConnection();
		        HttpURLConnection httpURLConnection = (HttpURLConnection)connection;
		        
		        httpURLConnection.setRequestProperty("Accept-Charset", "utf-8");
		        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		        
		        InputStream inputStream = null;
		        InputStreamReader inputStreamReader = null;
		        BufferedReader reader = null;
		        StringBuffer resultBuffer = new StringBuffer();
		        String tempLine = null;
		        
		        if (httpURLConnection.getResponseCode() >= 300) {
		             throw new Exception("HTTP Request is not success, Response code is " + httpURLConnection.getResponseCode());
		        }
		        
		        try {
		            inputStream = httpURLConnection.getInputStream();
		            inputStreamReader = new InputStreamReader(inputStream);
		            reader = new BufferedReader(inputStreamReader);
		            
		            while ((tempLine = reader.readLine()) != null) {
		                resultBuffer.append(tempLine);
		            }
		            
		        }finally {
		            
		            if (reader != null) {
		                reader.close();
		            }
		            
		            if (inputStreamReader != null) {
		                inputStreamReader.close();
		            }
		            
		            if (inputStream != null) {
		                inputStream.close();
		            }
		        }
		        
		        return resultBuffer.toString(); 
		 }
	  
		 public static void main(String[] args) throws Exception {
			   String restServer = "192.168.2.2"; 
			   String accessTocken = "NmYwMzQ3M2Q5N2NlNjFhZTA0MDM1MTYyMGQyZjcyZTE5ODMzNmY0OQ%3D%3D"; 
			   String topic = "top & % -  123"; 
			   int maxVideo = 5; 
			   int maxAudio = 5; 
			   String hostPassword = "20"; 
			   
			   RestSdk.init(restServer);
			   RoomServer roomServer = new  RoomServer(accessTocken,topic,maxVideo,maxAudio,hostPassword);
			   try{
			       String roomId = roomServer.createRoom();
			       System.out.println("roomId:"+ roomId);
			       
			       Room room = roomServer.getRoom(roomId);
			       System.out.println("roomURL:"+ room.getRoomURL());
			   }catch(RoomException  roomException){
				   System.out.println(roomException.getKey() + ":" + roomException.getMessage());
			   }
		 } 
     
}
