package Action;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Entity.User;
import Entity.UserInfo;
import Service.IUserInfoManage;

public class UserInfoAction extends ActionSupport{
	private UserInfo userInfo;
	private User user;
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
		user=(User) ActionContext.getContext().getSession().get("user");
		 userInfo.setUserid(user.getUserid());
     if(ActionContext.getContext().getSession().get("userInfo")!=null)
     {
    	 userInfo.setId(iUserInfoManage.getUserInfo(user.getUserid()).getId());
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
