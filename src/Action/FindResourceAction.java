package Action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Entity.ClassInfo;
import Service.IClassInfoManage;
import Service.IClassManage;

public class FindResourceAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String classLevel;
	private String type;
	@Resource
	private IClassInfoManage iClassInfoManage;
@Resource
private IClassManage iClassManage;
	public IClassManage getIClassManage() {
	return iClassManage;
}

public void setIClassManage(IClassManage iClassManage) {
	this.iClassManage = iClassManage;
}

	public IClassInfoManage getIClassInfoManage() {
		return iClassInfoManage;
	}

	public void setIClassInfoManage(IClassInfoManage iClassInfoManage) {
		this.iClassInfoManage = iClassInfoManage;
	}

	public String getClassLevel() {
		return classLevel;
	}

	public void setClassLevel(String classLevel) {
		this.classLevel = classLevel;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String execute() throws Exception
	{
		ActionContext.getContext().getSession().remove("classInfoList");
		ActionContext.getContext().getSession().remove("classLevel");
		ActionContext.getContext().getSession().remove("type");
		int classid=0;
		if(!type.isEmpty()&&type!=""&&type!=null)
		{
			if(iClassManage.getClassByType(type)!=null){
			 classid=iClassManage.getClassByType(type).getClassid();
			}
			else{
				ActionContext.getContext().getSession().put("NoResource","无相关课程资源");
				return SUCCESS;
			}
			
			List<?> list=iClassInfoManage.getClassInfo(classid);
			if(!classLevel.isEmpty()&&classLevel!=""&&classLevel!=null)
			{
				ArrayList<Object> list1=new ArrayList<>();
				for(int i=0;i<list.size();i++)
				{
					ClassInfo classInfo=(ClassInfo) list.get(i);
					if(classInfo.getClassLevel().equals(classLevel))
					{
						list1.add(classInfo);
					}
				}
				if(list1.size()>0)
				{
				ActionContext.getContext().getSession().put("classInfoList",list1);
				return SUCCESS;
				}
				
				else{
					ActionContext.getContext().getSession().put("NoResource","无相关课程资源");
					return SUCCESS;
				}
			}
			else
			{
				if(list.size()>0){
				ActionContext.getContext().getSession().put("classInfoList",list);
				ActionContext.getContext().getSession().put("type",getType());
				return SUCCESS;
				}
				else{
					ActionContext.getContext().getSession().put("NoResource","无相关课程资源");
					return SUCCESS;
				}
			}
		}
		else if(!classLevel.isEmpty()&&classLevel!=""&&classLevel!=null)
		{
			List<?> list=iClassInfoManage.getClassInfoByClassLevel(classLevel);
			if(list.size()>0)
			{
				ActionContext.getContext().getSession().put("classInfoList",list);
				ActionContext.getContext().getSession().put("classLevel",getClassLevel());
			return SUCCESS;
			}
			else{
				ActionContext.getContext().getSession().put("NoResource","无相关课程资源");
				return SUCCESS;
			}
			
		}
			
		else {
			return SUCCESS;
		}
		
		
		
	}

}
