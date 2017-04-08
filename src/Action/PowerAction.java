package Action;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Service.IPowerManage;
import Service.IUserManage;

import java.util.*;


public class PowerAction extends ActionSupport{
	@Resource
	private IPowerManage iPowerManage;
	@Resource
	private IUserManage iUserManage;
   public IUserManage getiUserManage() {
		return iUserManage;
	}
	public void setiUserManage(IUserManage iUserManage) {
		this.iUserManage = iUserManage;
	}
public IPowerManage getIPowerManage() {
		return iPowerManage;
	}
	public void setIPowerManage(IPowerManage iPowerManage) {
		this.iPowerManage = iPowerManage;
	}
public String getMyPowerAction() throws Exception
   {
	 ActionContext.getContext().getSession().remove("PowerList");
	   List<?> list= iPowerManage.getAll();
	   if(list!=null&&list.size()>0)
	   {
		  
		   ActionContext.getContext().getSession().put("PowerList", list);
		   }
	   return SUCCESS;
   }
   public String getAllUserPowerInfoAction() throws Exception
   {
	   ActionContext.getContext().getSession().remove("UserPowerList");
	  List<?> list=iUserManage.getAll();
	  if(list!=null&&list.size()>0)
	  {
	  ActionContext.getContext().getSession().put("UserPowerList", list);}
	   return SUCCESS;
   }
    
   public String getAllPowerInfoAction() throws Exception
   {
	  
	   return SUCCESS;
   }
}
