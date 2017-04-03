package ChatSever;

import java.text.SimpleDateFormat;

import java.util.ArrayList;

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
 * 聊天服务器类
 * @author fuwenguo
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
	 String action=jsonObject.getString("action");
	 System.out.println(action);
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
	 case "sendMessage":
		 String username=jsonObject.getString("username");
		 String Friendsname=jsonObject.getString("Friendsname");
		 jsonObject.put("time",DATE_FORMAT);
		 sendMessage(jsonObject, session, "1");;//先发送给自己
		 saveMessage(jsonObject, Friendsname, "1", "", username);;//先在自己的文档里保存消息记录
		 if(window_status.get(Friendsname)!=null&&window_status.get(Friendsname).equals(username))//如果接收人窗口已打开
		 {
			saveMessage(jsonObject, username, "0", "open", Friendsname);
			 sendMessage(jsonObject, sessionlist.get(Friendsname), "0");
		 }
		 else{
			 saveMessage(jsonObject, username,"0","close", Friendsname);
			 if(sessionlist.get(Friendsname)!=null)//如果接收人在线
			 {
				 
				changeCount(Friendsname, sessionlist.get(Friendsname), username);;//修改离线消息条数
				
			 }
		 }
	 }
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
     Document document=new Document();
     document.append("Friendsname",Friendsname);
     document.append("isself","0");
     jsonObject.put("count",iMongoManage.count(username+"chatInfo", document));
     jsonObject.put("status","离线");
   session.getAsyncRemote().sendText(jsonObject.toString());
	 
 }
 
 public void getOffLineMessage(Session session,Document document,String username)
 {
	MongoCursor<Document> mongoCursor=iMongoManage.findIterable(username+"chatInfo", document);
	while(mongoCursor.hasNext())
	{
		Document document2=mongoCursor.next();
		document2.append("action","sendMessage");
		document2.append("username",username);
		session.getAsyncRemote().sendText(document2.toString());
	}
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
	 jsonObject.put("action","notify");
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
		   session.getAsyncRemote().sendText(jsonObject.toString());//修改此用户为在线状态
		 }
	 }
 }

 public void saveMessage(JSONObject jsonObject,String Friendsname,String isself,String windowStatus,String collectionname)
 {
	 Document document=new Document();
	 document.append("Friendsname", jsonObject.getString("Friendsname"));
	 document.append("content",jsonObject.getString("content"));
	 document.append("time",jsonObject.getString("time"));
	 if(isself.equals("0"))
	 { 
		 document.append("windowStatus",windowStatus);
	 }
	 document.append("isself",isself);
	 List<Document> documents=new ArrayList<>();
	 documents.add(document);
	 iMongoManage.insertMany(collectionname, documents);
 }
 public void sendMessage(JSONObject jsonObject,Session session,String isself)
 {
	 jsonObject.put("isself",isself);
 session.getAsyncRemote().sendText(jsonObject.toString());
 }
 
 public void changeCount(String Friendsname,Session session,String username)
 {
	 JSONObject jsonObject=new JSONObject();
	 Document document=new Document();
	 document.append("Friendsname", username);
	 document.append("windowstatus", "close");
	 document.append("isself","0");
	 jsonObject.put("count", iMongoManage.count(Friendsname+"chatInfo",document));
	 jsonObject.put("action", "changecount");
	 jsonObject.put("Friendsname", username);
	 session.getAsyncRemote().sendText(jsonObject.toString());
	 
 }
}