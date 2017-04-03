package Action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.bson.Document;

import com.mongodb.client.MongoCursor;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Entity.User;
import Service.IMongoManage;
import Service.IUserManage;

public class CommunicationAction extends ActionSupport{
	@Resource
    private IUserManage iUserManage;
	@Resource
	private IMongoManage iMongoManage;
	
	public IMongoManage getiMongoManage() {
		return iMongoManage;
	}
	public void setiMongoManage(IMongoManage iMongoManage) {
		this.iMongoManage = iMongoManage;
	}
	public IUserManage getiUserManage() {
		return iUserManage;
	}
	public void setiUserManage(IUserManage iUserManage) {
		this.iUserManage = iUserManage;
	}
	private String userid;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String addFriendsAction()throws Exception
	{
		System.out.println(getUserid());
		
		User user=iUserManage.getUserByUserid(getUserid());
		String username=user.getUsername();
		 user=(User) ActionContext.getContext().getSession().get("user");
		 String collectionname=user.getUsername();
		 HttpServletResponse response=ServletActionContext.getResponse();  
		    response.setContentType("text/html;charset=GBK");
		    PrintWriter out = response.getWriter(); 
		 if(username.equals(collectionname))
		 {
			    out.println(-1);  
			    out.flush();  
			    out.close();  
			    return NONE;
		 }
		 
		 else{
			  MongoCursor<Document> mongoCursor=iMongoManage.findIterable(collectionname,new Document("username",username));
		if(mongoCursor.hasNext())
			{
				 out.println(0);  
				    out.flush();  
				    out.close(); 
				return NONE;
			}
			else{
				 out.println(1);  
				    out.flush();  
				    out.close(); 
		 Document document=new Document("username",username);
		 List <Document> documents=new ArrayList<Document>();
		 documents.add(document);
		 iMongoManage.insertMany(collectionname,documents);
		 return NONE;
		 }

		 }

		
	}

}
