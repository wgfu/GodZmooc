package Action;

import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Entity.ClassInfo;
import Entity.User;
import Service.IClassInfoManage;

public class ClassManageAction extends ActionSupport{
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Resource
private IClassInfoManage iClassInfoManage;
public IClassInfoManage getIClassInfoManage()
{
	return this.iClassInfoManage;
	}
public void setIClassInfoManage(IClassInfoManage iClassInfoManage)
{
	this.iClassInfoManage=iClassInfoManage;
	}
	public String execute() throws Exception {
		ActionContext.getContext().getSession().remove("classInfo");
	      User user=(User) ActionContext.getContext().getSession().get("user");
	      ClassInfo classInfo=new ClassInfo();
	      classInfo.setUserid(user.getUserid());
	     
	      List<?> list=iClassInfoManage.getClassInfoDefault(classInfo);
	      if(list!=null&&!list.isEmpty()&&list.size()>0)
			{
				ActionContext.getContext().getSession().put("classInfo",list);
				return SUCCESS;
					
					}
					else{
						ActionContext.getContext().getSession().put("NoclassInfo","无已发布课程");
						return SUCCESS;
			}
	}
}
