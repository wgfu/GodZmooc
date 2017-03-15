package Action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.ss.formula.functions.Irr;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Entity.Discussion;
import Entity.Part;
import Entity.Reply;
import Service.ICommentPartManage;

public class DiscussionAction extends ActionSupport{
	@Resource
	private ICommentPartManage iPartManage;
	@Resource
	private ICommentPartManage iDiscussionManage;
	private Integer discussionid;
	@Resource
	private ICommentPartManage iReplyManage;
public ICommentPartManage getIReplyManage() {
		return iReplyManage;
	}
	public void setIReplyManage(ICommentPartManage iReplyManage) {
		this.iReplyManage = iReplyManage;
	}
public Integer getDiscussionid() {
		return discussionid;
	}
	public void setDiscussionid(Integer discussionid) {
		this.discussionid = discussionid;
	}
public ICommentPartManage getIDiscussionManage() {
		return iDiscussionManage;
	}
	public void setIDiscussionManage(ICommentPartManage iDiscussionManage) {
		this.iDiscussionManage = iDiscussionManage;
	}
public ICommentPartManage getIPartManage() {
		return iPartManage;
	}
	public void setIPartManage(ICommentPartManage iPartManage) {
		this.iPartManage = iPartManage;
	}
public String execute()throws Exception
{
	List<?> list=iPartManage.getRuslt("");
List<HashMap<String,Object>> PartList=new ArrayList<>();

	if(list!=null&&list.size()>0)
	{
		int i=0;
	for(Object list2:list)
	{
	    Part part=(Part) list2;
	    Discussion discussion=new Discussion();
	    discussion.setPartid(part.getPartid());
	   
	    List <?>list3=iDiscussionManage.getRuslt(discussion);
	    HashMap<String,Object> hashMap=new HashMap<>();
	    hashMap.put("id",part.getPartid());
	   if(i==0)
	   { hashMap.put("mark","active");i++;}
	   else{
		   hashMap.put("mark","none");
	   }
	   
	    hashMap.put("Partname",part.getPartname());
	    if(list3!=null&&list3.size()>0)
	    {
	    	hashMap.put("DiscussionList",list3);
	    }
	    PartList.add(hashMap);
	}
		ActionContext.getContext().getSession().put("PartList",PartList);
	}
	return SUCCESS;
	}

    public String discussionMessageAction()throws Exception
{
    Discussion discussion=new Discussion();
    discussion.setDiscussionid(getDiscussionid());
   
  
    discussion=(Discussion) iDiscussionManage.getRuslt(discussion).get(0);
    	List <?> list=iReplyManage.getRuslt(discussion.getReplyid());
    	if(list!=null&&list.size()>0)
    	{
    		ActionContext.getContext().getSession().remove("ReplyList");
    		ActionContext.getContext().getSession().put("ReplyList",list);
    	}
    	ActionContext.getContext().getSession().remove("DiscussionMessage");
		ActionContext.getContext().getSession().put("DiscussionMessage",discussion);
	
	return SUCCESS;	
}
}
