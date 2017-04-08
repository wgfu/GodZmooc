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
	private static HashMap<String,Integer> powerList=new HashMap<>();
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
		List<?> list= iPowerManage.getAll();
		Power power=new Power();
		for(int i=0;i<list.size();i++)
		{
			 power=(Power) list.get(i);
			powerList.put(power.getActionName(),power.getLevel());
		}
	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("------check.start------");
		Map session=ActionContext.getContext().getSession();
		HttpServletRequest request=ServletActionContext.getRequest();
		String path=request.getRequestURI();
		System.out.println(path);
		String actionname=request.getRequestURI();
		
		if(session.get("user")!=null)
		{
			if((int)session.get("user.power")>powerList.get(actionname))
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
