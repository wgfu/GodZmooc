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
 * �����������
 * @author shiyanlou
 *
 */
@ServerEndpoint("/websocket")

public class ChatServer extends HttpServlet{
 private static List<Session> sessionlist=new ArrayList<Session>(); 
 private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");  // ���ڸ�ʽ��
 @OnOpen
 public void open(Session session) {
  // ��ӳ�ʼ������
	 System.out.print("���ӳɹ�");
	 sessionlist.add(session);
	 System.out.println("��ǰ���ӵ�SESSION��"+session.getId());
 }
 /**
  * ���ܿͻ��˵���Ϣ��������Ϣ���͸��������ӵĻỰ
  * @param message �ͻ��˷�������Ϣ
  * @param session �ͻ��˵ĻỰ
  */
 @OnMessage
 public void getMessage(String message, Session session) {
  // �ѿͻ��˵���Ϣ����ΪJSON����
	
  for (Session openSession:sessionlist) {
   // ��ӱ�����Ϣ�Ƿ�Ϊ��ǰ�Ự�����ı�־
	
   openSession.getAsyncRemote().sendText(message);
  
  }

 }
 @OnClose
 public void close(Session session) {
	 
  // ��ӹرջỰʱ�Ĳ���
	 sessionlist.remove(session);
	 System.out.println(session.getId());
	 System.out.println(session.getRequestURI());
	 System.out.println("�ر�");
 }
 @OnError
 public void error(Throwable t) {
  // ��Ӵ������Ĳ���
 }
}