package ChatSever;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import net.sf.json.JSONObject;
/**
 * 聊天服务器类
 * @author shiyanlou
 *
 */
@ServerEndpoint("/websocket")

public class ChatServer extends HttpServlet{
 private static List<Session> sessionlist=new ArrayList<Session>(); 
 private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");  // 日期格式化
 @OnOpen
 public void open(Session session) {
  // 添加初始化操作
	 System.out.print("连接成功");
	 sessionlist.add(session);
	 System.out.println("当前连接的SESSION："+session.getId());
 }
 /**
  * 接受客户端的消息，并把消息发送给所有连接的会话
  * @param message 客户端发来的消息
  * @param session 客户端的会话
  */
 @OnMessage
 public void getMessage(String message, Session session) {
  // 把客户端的消息解析为JSON对象
	
  for (Session openSession:sessionlist) {
   // 添加本条消息是否为当前会话本身发的标志
	
   openSession.getAsyncRemote().sendText(message);
  
  }

 }
 @OnClose
 public void close(Session session) {
	 
  // 添加关闭会话时的操作
	 sessionlist.remove(session);
	 System.out.println(session.getId());
	 System.out.println(session.getRequestURI());
	 System.out.println("关闭");
 }
 @OnError
 public void error(Throwable t) {
  // 添加处理错误的操作
 }
}