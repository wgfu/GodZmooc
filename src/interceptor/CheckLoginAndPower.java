package interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import Entity.Power;

import java.util.*;
import Service.IPowerManage;


public class CheckLoginAndPower implements Interceptor{
	
	@Resource
	private IPowerManage iPowerManage;

	public IPowerManage getIPowerManage() {
		return iPowerManage;
	}

	public void setIPowerManage(IPowerManage iPowerManage) {
		this.iPowerManage = iPowerManage;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		System.out.println("------check.init------");
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("------check.start------");
		Map session=ActionContext.getContext().getSession();
		HttpServletRequest request=ServletActionContext.getRequest();
		String path=request.getRequestURI();
		String url[]=path.split("/");
		String actionname=url[url.length-1];
		if(session.get("user")!=null)
		{
			Power power=iPowerManage.getPower(actionname);
			if((int)session.get("user.power")>power.getLevel())
			{
				return arg0.invoke();
			}
			else{
				return "PermissionDenied";
			}
		}
		else{
			return "PleaseLogin";
			}
		
	}

}
