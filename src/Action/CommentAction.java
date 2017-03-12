package Action;

import java.util.Date;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Entity.Comment;
import Entity.User;
import Service.ICommentPartManage;

public class CommentAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Comment comment;
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

	public String addComent()throws Exception
    {
    	Date date=new Date();
    	getComment().setTime(date);
        User user=(User) ActionContext.getContext().getSession().get("user");
    	getComment().setUserid(user.getUserid());
    	
    	return SUCCESS;
    }
}
