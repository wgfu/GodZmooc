package Action;

import java.io.PrintWriter;
import java.security.MessageDigest;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


import Entity.User;
import Entity.UserInfo;
import Service.IUserInfoManage;
import Service.IUserManage;

public class LoginAction extends ActionSupport{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	private String username;
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	private UserInfo userInfo;
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public IUserManage getIUserManage() {
		return iUserManage;
	}

	public void setIUserManage(IUserManage iUserManage) {
		this.iUserManage = iUserManage;
	}

	@Resource
	private IUserManage iUserManage;
	@Resource
	private IUserInfoManage iUserInfoManage;
public IUserInfoManage getIUserInfoManage() {
		return iUserInfoManage;
	}

	public void setIUserInfoManage(IUserInfoManage iUserInfoManage) {
		this.iUserInfoManage = iUserInfoManage;
	}

public String execute()throws Exception
{
	MessageDigest md5 = MessageDigest.getInstance("MD5");
	 byte[] inputByteArray = user.getPassword().getBytes();
	 md5.update(inputByteArray);
	 String username=getUser().getUsername();
	 User user1 =new User();
	 user1=iUserManage.getUser(username);
	 if(user1!=null)
	 {if(user1.getPassword().equals(new String(md5.digest())))
	 {
		 ActionContext.getContext().getSession().put("user",user1);
		 UserInfo userInfo=iUserInfoManage.getUserInfo(user1.getUserid());
		 if(userInfo!=null)
		 { 
			 
		 ActionContext.getContext().getSession().put("userInfo", userInfo);
		 }
		
			return "success";
	 }
	 else {
		 ActionContext.getContext().getSession().put("error", "ÕËºÅ»òÃÜÂë´íÎó!!!ÇëÖØÐÂµÇÂ¼!!!");
			 return "fail";
		 
	}
	 }
	 else{
		 ActionContext.getContext().getSession().put("error", "ÕËºÅ²»´æÔÚ!!!ÇëÖØÐÂµÇÂ¼!!!");
		 return "fail";
	 }
	}
public String outLoginAction()throws Exception
{
	ActionContext.getContext().getSession().remove("user");
	ActionContext.getContext().getSession().remove("userInfo");
	return SUCCESS;
	}
public String checkUsernameAction() throws Exception
{
	
	User user=iUserManage.getUser(getUsername());
	if(user==null)
	{
	    HttpServletResponse response=ServletActionContext.getResponse();  
	    response.setContentType("text/html;charset=GBK");
	    PrintWriter out = response.getWriter(); 
	    out.println("1");  
	    out.flush();  
	    out.close();  
	}
	else{
		  HttpServletResponse response=ServletActionContext.getResponse();  
		    response.setContentType("text/html;charset=GBK");
		    PrintWriter out = response.getWriter(); 
		    out.println("0");  
		    out.flush();  
		    out.close();  
	}
	return NONE;
	}
}

