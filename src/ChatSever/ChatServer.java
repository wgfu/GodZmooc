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
 * 聊天服务器类
 * @author shiyanlou
 *
 */
@ServerEndpoint("/websocket")

public class ChatServer extends HttpServlet {
 private static HashMap<String,Session> sessionlist=new HashMap<String,Session>(); 
 @Resource
private static IMongoManage iMongoManage;
private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  // 日期格式化
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
  // 添加初始化操作
	 System.out.print("连接成功");
	addUser(session);

 }
 /**
  * 接受客户端的消息，并把消息发送给所有连接的会话
  * @param message 客户端发来的消息
  * @param session 客户端的会话
  */
 @OnMessage
 public void getMessage(String message, Session session) {
  // 把客户端的消息解析为JSON对象
	 JSONObject jsonObject = JSONObject.fromObject(message);
     // 在消息中添加发送日期
     jsonObject.put("date", DATE_FORMAT.format(new Date()));
     jsonObject.put("isSelf", "1");
 
   session.getAsyncRemote().sendText(jsonObject.toString());
  

 }
 @OnClose
 public void close(Session session) {
	 
  // 添加关闭会话时的操作
	 sessionlist.remove(session);
	 System.out.println(session.getId());
	
	 System.out.println("关闭");
 }
 @OnError
 public void error(Throwable t) {
  // 添加处理错误的操作
 }
 
 public void sendFriendsInfo(String Friendsname,String username,Session session)
 {
	 JSONObject jsonObject = new JSONObject();
	 jsonObject.put("action","getFriendsList");
     jsonObject.put("Friendsname", Friendsname);
     Document document=new Document("status","在线");
     document.append("Friendsname",Friendsname);
     document.append("isself","0");
     jsonObject.put("count",iMongoManage.count(username+"chatInfo", document));
     jsonObject.put("status","离线");
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
		 sendFriendsInfo(Friendsname,username,session);//发送好友信息，构成好友列表
		 if(sessionlist.get(Friendsname)!=null)
		 {
			 changeFriendsStatus(Friendsname,"在线",username,session);//改变好友在线状态
			 JSONObject jsonObject = new JSONObject();
			 jsonObject.put("action","notify");
		     jsonObject.put("Friendsname", Friendsname);
		     jsonObject.put("status", "在线");
		   session.getAsyncRemote().sendText(jsonObject.toString());
		 }
	 }
 }
 public void saveMessage()
 {
	 
 }
}