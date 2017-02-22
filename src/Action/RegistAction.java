package Action;

import java.security.MessageDigest;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;

import Entity.User;
import Service.IUserManage;
import oracle.net.aso.MD5;

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
	String password=user.getPassword();
	MessageDigest md5 = MessageDigest.getInstance("MD5");
	 byte[] inputByteArray = password.getBytes();
	 md5.update(inputByteArray);
	user.setPassword(md5.digest().toString());
	int rand=(int) (Math.random()*10000000);
	String randstr=String.valueOf(rand);
	 byte[] inputByteArray1 = randstr.getBytes();
	 md5.update(inputByteArray1);
	user.setUserid(md5.digest().toString());
	iUserManage.addUser(user);
	return "success";
	}
}
