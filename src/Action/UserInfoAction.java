package Action;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Entity.UserInfo;
import Service.IUserInfoManage;

public class UserInfoAction extends ActionSupport{
	private UserInfo userInfo;
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public IUserInfoManage getIUserInfoManage() {
		return iUserInfoManage;
	}
	public void setIUserInfoManage(IUserInfoManage iUserInfoManage) {
		this.iUserInfoManage = iUserInfoManage;
	}
	@Resource
	private IUserInfoManage iUserInfoManage;
	public String execute()throws Exception
	{
    
     if(ActionContext.getContext().getSession().get("userInfo")!=null)
     {
    	iUserInfoManage.updateUserInfo(userInfo);
     }
     else
     {
    	 iUserInfoManage.addUserInfo(userInfo);
     }
    ActionContext.getContext().getSession().put("userInfo",userInfo);
				return "success";
		
	}
	
}
