package Action;

import java.security.MessageDigest;


import javax.annotation.Resource;


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
	 if(iUserManage.getUser(user.getUsername()).getPassword().equals(new String(md5.digest())))
	 {
		 ActionContext.getContext().getSession().put("user",iUserManage.getUser(user.getUsername()));
		 if(iUserInfoManage.getUserInfo(iUserManage.getUser(user.getUsername()).getUserid())!=null)
		 { 
			 userInfo=iUserInfoManage.getUserInfo(iUserManage.getUser(user.getUsername()).getUserid());
		 ActionContext.getContext().getSession().put("userInfo", userInfo);
		 }
		
			return "success";
	 }
	 else {
		 
			 return "fail";
		 
	}
	}
}

