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
	private String resourceType;
	public String getResourceType()
	{
		return this.resourceType;
	}
 public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}
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
		ActionContext.getContext().getSession().remove("resourceType");
		ActionContext.getContext().getSession().remove("NoResource");
		int classid=0;
		ClassInfo classInfo=new ClassInfo();
		
		if(!type.isEmpty()&&type!=""&&type!=null)
		{
			if(iClassManage.getClassByType(type)!=null){
				 classid=iClassManage.getClassByType(type).getClassid();
				 classInfo.setClassid(classid);
				
				}
				else{
					ActionContext.getContext().getSession().put("NoResource","无相关课程资源");
					return SUCCESS;
		}
		}
			if(classLevel!=""&&classLevel!=null&&!classLevel.isEmpty())
			{
				classInfo.setClassLevel(classLevel);
				}		
			if(resourceType!=null&&!resourceType.isEmpty()&&resourceType!="")
			{
				classInfo.setType(resourceType);
			}
			
			List<?> list =iClassInfoManage.getClassInfoDefault(classInfo);
		    
			if(list!=null&&!list.isEmpty()&&list.size()>0)
			{
				ActionContext.getContext().getSession().put("classInfoList",list);
			
			return SUCCESS;
			}
			else{
				ActionContext.getContext().getSession().put("NoResource","无相关课程资源");
				return SUCCESS;
			}
		
	}

}
