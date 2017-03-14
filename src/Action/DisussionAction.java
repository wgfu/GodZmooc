package Action;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;

import Service.ICommentPartManage;

public class DisussionAction extends ActionSupport{
	@Resource
	private ICommentPartManage iPartManage;
public ICommentPartManage getIPartManage() {
		return iPartManage;
	}
	public void setIPartManage(ICommentPartManage iPartManage) {
		this.iPartManage = iPartManage;
	}
public String execute()throws Exception
{
	
	return SUCCESS;
	}
}
