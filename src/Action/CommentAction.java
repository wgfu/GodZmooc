package Action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Entity.ClassInfo;
import Entity.Comment;
import Entity.User;
import Entity.UserInfo;
import Service.ICommentPartManage;
import Service.IUserInfoManage;

public class CommentAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Comment comment;
	@Resource 
	private IUserInfoManage iUserInfoManage;
	
	public IUserInfoManage getIUserInfoManage() {
		return iUserInfoManage;
	}

	public void setIUserInfoManage(IUserInfoManage iUserInfoManage) {
		this.iUserInfoManage = iUserInfoManage;
	}
	@Resource
	private ICommentPartManage iCommentManage;
	
    public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public ICommentPartManage getICommentManage() {
		return iCommentManage;
	}

	public void setICommentManage(ICommentPartManage iCommentManage) {
		this.iCommentManage = iCommentManage;
	}

	public String addCommentAction()throws Exception
    {
    	Date date=new Date();
    	getComment().setTime(date);
        User user=(User) ActionContext.getContext().getSession().get("user");
    	getComment().setUserid(user.getUserid());
         getComment().setUsername(user.getUsername());
       iCommentManage.addT(comment); 
    	return SUCCESS;
    }
	public String findCommentAction()throws Exception
	{
		ClassInfo classInfo=(ClassInfo) ActionContext.getContext().getSession().get("classMessage");
		if(classInfo.getCommentid()!=null)
		{
			List<?> list=iCommentManage.getRuslt(classInfo.getCommentid());
	
			if(list!=null&&!list.isEmpty()&&list.size()>0)
			{
				ActionContext.getContext().getSession().remove("commentCount");
				ActionContext.getContext().getSession().put("commentCount", list.size());
				ActionContext.getContext().getSession().remove("commentList");
				ActionContext.getContext().getSession().put("commentList", list);
			}
		
		}
		
		return SUCCESS;
	}
}
