package ChatSever;

import java.io.IOException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


import javax.annotation.Resource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;


import org.bson.Document;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


import com.mongodb.client.MongoCursor;

import Service.IMongoManage;
import net.sf.json.JSONObject;

/**
 * �����������
 * @author fuwenguo
 *
 */
@ServerEndpoint("/websocket")

public class ChatServer extends HttpServlet {
 private static HashMap<String,Session> sessionlist=new HashMap<String,Session>(); 
 @Resource
private static IMongoManage iMongoManage;
private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  // ���ڸ�ʽ��
private static HashMap<String,String> window_status=new HashMap<String,String>(); 

public void init() throws ServletException {  
	        super.init(); 
	        if(iMongoManage==null)
	        {WebApplicationContext wac = WebApplicationContextUtils 
	                .getRequiredWebApplicationContext(getServletContext()); 
	     iMongoManage = (IMongoManage) wac.getBean("iMongoManage"); 
	        }
}  

 @OnOpen
 public void open(Session session) throws Exception {
  // ��ӳ�ʼ������
	 System.out.print("���ӳɹ�");
	 
	addUser(session);

 }
 /**
  * ���ܿͻ��˵���Ϣ��������Ϣ���͸��������ӵĻỰ
  * @param message �ͻ��˷�������Ϣ
  * @param session �ͻ��˵ĻỰ
  */
 @OnMessage
 public void getMessage(String message, Session session) {
  // �ѿͻ��˵���Ϣ����ΪJSON����
	 JSONObject jsonObject = JSONObject.fromObject(message);
     // ����Ϣ����ӷ�������
	 String action=jsonObject.getString("action");
	
	 switch(action)
	 {
	 case "changewindowstatus":
		 if(jsonObject.getString("status").equals("open")){
			 window_status.remove(jsonObject.getString("username"));
			 window_status.put(jsonObject.getString("username"),jsonObject.getString("Friendsname"));
			 Document document=new Document("windowStatus","close");
		     document.append("Friendsname",jsonObject.getString("Friendsname"));
		     document.append("isself","0");
		     if(iMongoManage.count(jsonObject.getString("username")+"chatInfo", document)>0){
		    	 getOffLineMessage(session,document,jsonObject.getString("username"));
		     }
	 }else{
		 window_status.remove(jsonObject.getString("username"));
	 };
	 break;
	 case "sendMessage":
		 String username=jsonObject.getString("username");
		 String Friendsname=jsonObject.getString("Friendsname");
		 jsonObject.put("time",DATE_FORMAT.format(new Date()).toString());
		 sendMessage(jsonObject, session, "1");;//�ȷ��͸��Լ�
		 saveMessage(jsonObject, Friendsname, "1", "", username);;//�����Լ����ĵ��ﱣ����Ϣ��¼
		 if(window_status.get(Friendsname)!=null&&window_status.get(Friendsname).equals(username))//��������˴����Ѵ�
		 {
			saveMessage(jsonObject, username, "0", "open", Friendsname);
			 sendMessage(jsonObject, sessionlist.get(Friendsname), "0");
		 }
		 else{
			 saveMessage(jsonObject, username,"0","close", Friendsname);
			 if(sessionlist.get(Friendsname)!=null)//�������������
			 {
				 
				changeCount(Friendsname, sessionlist.get(Friendsname), username);;//�޸�������Ϣ����
				
			 }
		 }
		 break;
	 }
 }
 @OnClose
 public void close(Session session) {
	 
  // ��ӹرջỰʱ�Ĳ���
	 String key1="";
	 for(String key:sessionlist.keySet())
		 if(sessionlist.get(key).equals(session))
		 {
			 key1=key;
			 
		 }
	 sessionlist.remove(key1);
	 window_status.remove(key1);
 }
 @OnError
 public void error(Throwable t) {
  // ��Ӵ������Ĳ���
	 System.out.println(t);
 }
 
 public void sendFriendsInfo(String Friendsname,String username,Session session)
 {
	 JSONObject jsonObject = new JSONObject();
	 jsonObject.put("action","getFriendsList");
     jsonObject.put("Friendsname", Friendsname);
     Document document=new Document();
     document.append("Friendsname",Friendsname);
     document.append("isself","0");
     document.append("windowStatus","close");
     jsonObject.put("count",iMongoManage.count(username+"chatInfo", document));
     jsonObject.put("status","����");
     synchronized(session) {
    	 if (session.isOpen()) {
    		 try{
    			 session.getAsyncRemote().flushBatch();}
    			 catch (Exception e){
    				 System.out.println(e);
    			 }
    			session.getAsyncRemote().sendText(jsonObject.toString());
    			}
 		}   
  
	 
 }
 
 public void getOffLineMessage(Session session,Document document,String username) 
 {
	MongoCursor<Document> mongoCursor=iMongoManage.findIterable(username+"chatInfo", document);
	while(mongoCursor.hasNext())
	{
		
		Document document2=mongoCursor.next();
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("Friendsname", document2.get("Friendsname"));
		jsonObject.put("content", document2.get("content"));
		jsonObject.put("time", document2.get("time"));
		jsonObject.put("isself", document2.get("isself"));
		jsonObject.put("action", "sendMessage");
		jsonObject.put("username", username);
		synchronized(session) {
		 if (session.isOpen()) {
			 try{
			 session.getAsyncRemote().flushBatch();}
			 catch (Exception e){
				 System.out.println(e);
			 }
		session.getAsyncRemote().sendText(jsonObject.toString());
		}
		}
	}
	iMongoManage.updateMany(username+"chatInfo", document, new Document("windowStatus","open"));
 }
 
 public void initFriendsWindowStatus(String username)
 {
	 window_status.remove(username);
 }
 
 public void openWindow(String username,String windowname)
 {
	 window_status.put(username,windowname);
 }
 
 public void addUser(Session session) throws Exception
 {
	 String username=session.getRequestURI().toString().substring(session.getRequestURI().toString().indexOf("?")+1);
	
		if(sessionlist.get(username)==null)
		{
			sessionlist.put(username,session);
			initFriendsWindowStatus(username);
			notifyAllFriends(username,session);
		}
		else{
			Session session2=sessionlist.get(username);
				session2.close();
			sessionlist.remove(username);
			sessionlist.put(username,session);
			initFriendsWindowStatus(username);
			notifyAllFriends(username,session);
		}
		
 }
 public void changeFriendsStatus(String Friendsname,String status,String username,Session session)
 {
	 JSONObject jsonObject = new JSONObject();
	 jsonObject.put("action","notify");
     jsonObject.put("Friendsname",Friendsname);
     jsonObject.put("status", status);
     synchronized(session) {
    	 if (session.isOpen()) {
    		 try{
    			 session.getAsyncRemote().flushBatch();}
    			 catch (Exception e){
    				 System.out.println(e);
    			 }
    			session.getAsyncRemote().sendText(jsonObject.toString());
    			}
   
 		}   
   System.out.println("5");
 }
 
 public void notifyAllFriends(String username,Session session)
 {
	 MongoCursor<Document> mongoCursor=iMongoManage.findIterable(username,new Document());
	 while(mongoCursor.hasNext())
	 {
		 Document document=mongoCursor.next();
		 String Friendsname=document.getString("username");
		 sendFriendsInfo(Friendsname,username,session);//���ͺ�����Ϣ�����ɺ����б�
		 if(sessionlist.get(Friendsname)!=null)
		 {
			 changeFriendsStatus(Friendsname,"����",username,session);//�ı��������״̬
			 JSONObject jsonObject = new JSONObject();
			 jsonObject.put("action","notify");
		     jsonObject.put("Friendsname", username);
		     jsonObject.put("status", "����");
		     sessionlist.get(Friendsname).getAsyncRemote().sendText(jsonObject.toString());//�޸Ĵ��û�Ϊ����״̬
		 }
	 }
 }

 public void saveMessage(JSONObject jsonObject,String Friendsname,String isself,String windowStatus,String collectionname)
 {
	 Document document=new Document();
	 document.append("Friendsname", Friendsname);
	 document.append("content",jsonObject.getString("content"));
	 document.append("time",jsonObject.getString("time"));
	 if(isself.equals("0"))
	 { 
		 document.append("windowStatus",windowStatus);
	 }
	 document.append("isself",isself);
	 List<Document> documents=new ArrayList<>();
	 documents.add(document);
	 iMongoManage.insertMany(collectionname+"chatInfo", documents);
 }
 public void sendMessage(JSONObject jsonObject,Session session,String isself)
 {
	 jsonObject.put("isself",isself);
	 synchronized(session) {
		 if (session.isOpen()) {
			 try{
				 session.getAsyncRemote().flushBatch();}
				 catch (Exception e){
					 System.out.println(e);
				 }
				session.getAsyncRemote().sendText(jsonObject.toString());
				}
 		}   
 }
 
 public void changeCount(String Friendsname,Session session,String username)
 {
	 JSONObject jsonObject=new JSONObject();
	 Document document=new Document();
	 document.append("Friendsname", username);
	 document.append("windowStatus", "close");
	 document.append("isself","0");
	 jsonObject.put("count", iMongoManage.count(Friendsname+"chatInfo",document));
	 jsonObject.put("action", "changecount");
	 jsonObject.put("Friendsname", username);
	
	 synchronized(session) {
		
		 if (session.isOpen()) {
			 try{
				 session.getAsyncRemote().flushBatch();}
				 catch (Exception e){
					 System.out.println(e);
				 }
				session.getAsyncRemote().sendText(jsonObject.toString());
				}
 		}   
	 
 }
}