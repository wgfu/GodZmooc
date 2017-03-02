package Action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Entity.ClassInfo;
import Entity.Study;
import Entity.User;
import Service.IClassInfoManage;
import Service.IStudyManage;

public class StudyManageAction extends ActionSupport{

	/**
	 * 
	 */
	@Resource
	private IClassInfoManage iClassInfoManage;
		public IClassInfoManage getIClassInfoManage() {
			return iClassInfoManage;
		}

		public void setIClassInfoManage(IClassInfoManage iClassInfoManage) {
			this.iClassInfoManage = iClassInfoManage;
		}
	@Resource
	private IStudyManage iStudyManage;
	public void setIStudyManage(IStudyManage iStudyManage)
	{
		this.iStudyManage=iStudyManage;
	}
	public IStudyManage getIStudyManage()
	{
		return this.iStudyManage;
	}
	private static final long serialVersionUID = 1L;
	public String execute() throws Exception
	{
		User user=(User) ActionContext.getContext().getSession().get("user");
		List<?> list=iStudyManage.getStudy(user.getUserid());
		if(list!=null&&list.size()>0&&!list.isEmpty())
		{
			List<Object> list1=new ArrayList<>();
			for(int i=0;i<list.size();i++)
			{
				ClassInfo classInfo=new ClassInfo();
				Study study=(Study)list.get(i);
				classInfo.setClassInfoid(study.getClassInfoid());
				List<?> list2=iClassInfoManage.getClassInfoDefault(classInfo);
				if(list2!=null&&list2.size()>0&&!list2.isEmpty())
			{
					classInfo=(ClassInfo) list2.get(0);
					classInfo.setTime(study.getStarttime());
				list1.add(classInfo);;
			}
			}
			ActionContext.getContext().getSession().put("studyInfoList", list1);
			return SUCCESS;
		}
		ActionContext.getContext().getSession().put("none","ÔÝÎÞÊÕ²Ø¿Î³Ì£¡£¡£¡");
		return SUCCESS;
	}

}
