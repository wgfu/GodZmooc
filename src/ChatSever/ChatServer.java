package ChatSever;
import java.io.IOException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.apache.struts2.ServletActionContext;
import org.bson.Document;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;

import Service.IMongoManage;
import net.sf.json.JSONObject;
/**
 * �����������
 * @author shiyanlou
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
     jsonObject.put("date", DATE_FORMAT.format(new Date()));
     jsonObject.put("isSelf", "1");
 
   session.getAsyncRemote().sendText(jsonObject.toString());
  

 }
 @OnClose
 public void close(Session session) {
	 
  // ��ӹرջỰʱ�Ĳ���
	 sessionlist.remove(session);
	 System.out.println(session.getId());
	
	 System.out.println("�ر�");
 }
 @OnError
 public void error(Throwable t) {
  // ��Ӵ������Ĳ���
 }
 
 public void sendFriendsInfo(String Friendsname,String username,Session session)
 {
	 JSONObject jsonObject = new JSONObject();
	 jsonObject.put("action","getFriendsList");
     jsonObject.put("Friendsname", Friendsname);
     Document document=new Document("status","����");
     document.append("Friendsname",Friendsname);
     document.append("isself","0");
     jsonObject.put("count",iMongoManage.count(username+"chatInfo", document));
     jsonObject.put("status","����");
   session.getAsyncRemote().sendText(jsonObject.toString());
	 
 }
 public JSONObject getOfflineMessage(String username)
 {
	 return null;
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
	 System.out.println("3");
	 jsonObject.put("action","changeFriendsStatus");
     jsonObject.put("Friendsname",Friendsname);
     jsonObject.put("status", status);
     System.out.println("4");
   session.getAsyncRemote().sendText(jsonObject.toString());
   System.out.println("5");
 }
 
 public void notifyAllFriends(String username,Session session)
 {
	 MongoCursor<Document> mongoCursor=iMongoManage.findIterable(username,new Document());
	 while(mongoCursor.hasNext())
	 {
		 Document document=mongoCursor.next();
		 String Friendsname=document.getString("username");
		 System.out.println("qwewqeqwe1111");
		 sendFriendsInfo(Friendsname,username,session);//���ͺ�����Ϣ�����ɺ����б�
		 if(sessionlist.get(Friendsname)!=null)
		 {
			 changeFriendsStatus(Friendsname,"����",username,session);//�ı��������״̬
			 JSONObject jsonObject = new JSONObject();
			 jsonObject.put("action","notify");
		     jsonObject.put("Friendsname", Friendsname);
		     jsonObject.put("status", "����");
		   session.getAsyncRemote().sendText(jsonObject.toString());
		 }
	 }
 }
 public void saveMessage()
 {
	 
 }
}