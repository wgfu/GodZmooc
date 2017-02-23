package Action;

import java.security.MessageDigest;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Entity.User;
import Service.IUserManage;

public class LoginAction extends ActionSupport{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
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
public String execute()throws Exception
{
	MessageDigest md5 = MessageDigest.getInstance("MD5");
	 byte[] inputByteArray = user.getPassword().getBytes();
	 md5.update(inputByteArray);
	 if(iUserManage.getUser(user.getUsername()).getPassword().equals(new String(md5.digest())))
	 {
		 ActionContext.getContext().getSession().put("user",user);
			return "success";
	 }
	 else {
		 
			 return "fail";
		 
	}
	}
}

