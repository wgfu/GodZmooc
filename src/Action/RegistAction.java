package Action;

import java.net.URLEncoder;
import java.security.MessageDigest;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Entity.User;
import Service.IUserManage;


public class RegistAction extends ActionSupport{
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

public String execute() throws Exception
{
	
	String password=URLEncoder.encode(user.getPassword(),"utf-8");
	MessageDigest md5 = MessageDigest.getInstance("MD5");
	 byte[] inputByteArray = password.getBytes();
	 md5.update(inputByteArray);
	user.setPassword(new String(md5.digest()));
	int rand=(int) (Math.random()*10000000);
	String randstr=String.valueOf(rand);
	 byte[] inputByteArray1 = randstr.getBytes();
	 md5.update(inputByteArray1);
	user.setUserid(new String(md5.digest()));
	if(user.getType().equalsIgnoreCase("teacher"))
	{
		user.setPower(50);
	}
	else{
		user.setPower(20);
	}
	iUserManage.addUser(user);
	 ActionContext.getContext().getSession().put("user",iUserManage.getUser(user.getUsername()));
	return "success";
	}
}
