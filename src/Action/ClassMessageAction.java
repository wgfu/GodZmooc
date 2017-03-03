package Action;

import javax.annotation.Resource;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Entity.ClassInfo;
import Entity.UserInfo;
import Service.IClassInfoManage;
import Service.IUserInfoManage;

public class ClassMessageAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private Integer classInfoid;
	public Integer getClassInfoid() {
	return classInfoid;
}
	@Resource
	private IClassInfoManage iClassInfoManage;
	
public IClassInfoManage getIClassInfoManage() {
		return iClassInfoManage;
	}
	public void setIClassInfoManage(IClassInfoManage iClassInfoManage) {
		this.iClassInfoManage = iClassInfoManage;
	}
public void setClassInfoid(Integer classInfoid) {
	this.classInfoid = classInfoid;
}
@Resource
private IUserInfoManage iUserInfoManage;

	public IUserInfoManage getIUserInfoManage() {
	return iUserInfoManage;
}
public void setIUserInfoManage(IUserInfoManage iUserInfoManage) {
	this.iUserInfoManage = iUserInfoManage;
}
	public String execute()throws Exception
	{
		ClassInfo classInfo=new ClassInfo();
		classInfo.setClassInfoid(classInfoid);
      classInfo=(ClassInfo) iClassInfoManage.getClassInfoDefault(classInfo).get(0);
      UserInfo userInfo=iUserInfoManage.getUserInfo(classInfo.getUserid());
      ActionContext.getContext().getSession().put("classMessage",classInfo);
      ActionContext.getContext().getSession().put("author",userInfo);
		return SUCCESS;
		
	}

}
