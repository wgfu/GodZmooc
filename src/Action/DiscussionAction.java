package Action;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Entity.Discussion;
import Entity.Part;
import Entity.Reply;
import Entity.User;
import Service.ICommentPartManage;


public class DiscussionAction extends ActionSupport{
	private String type;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Resource
	private ICommentPartManage iPartManage;
	@Resource
	private ICommentPartManage iDiscussionManage;
	private Integer discussionid;
	private Reply reply;
	private Discussion discussion;
	public Discussion getDiscussion() {
		return discussion;
	}
	public void setDiscussion(Discussion discussion) {
		this.discussion = discussion;
	}
	public Reply getReply() {
		return reply;
	}
	public void setReply(Reply reply) {
		this.reply = reply;
	}
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
    	ActionContext.getContext().getSession().remove("ReplyList");
    	if(list!=null&&list.size()>0)
    	{
    
    		ActionContext.getContext().getSession().put("ReplyList",list);
    	}
    	ActionContext.getContext().getSession().remove("DiscussionMessage");
		ActionContext.getContext().getSession().put("DiscussionMessage",discussion);
	
	return SUCCESS;	
}
      public String addReplyAction()throws Exception
      {
    	  User user=(User) ActionContext.getContext().getSession().get("user");
    	  getReply().setUserid(user.getUserid());
    	  getReply().setUsername(user.getUsername());
    	  Date date=new Date();
    	  SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	  String date1=format.format(date);
    	  getReply().setTime(format.parse(date1));
    	  iReplyManage.addT(getReply());
    	 
    	  return SUCCESS;
      }
      public String addDiscussionAction()throws Exception
      {
    	  Part part=(Part) iPartManage.getRuslt(getType()).get(0);
    	  getDiscussion().setPartid(part.getPartid());
    	  Date date=new Date();
    	  SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	  String date1=format.format(date);
    	  getDiscussion().setTime(format.parse(date1));
    	  User user=(User) ActionContext.getContext().getSession().get("user");
    	  getDiscussion().setUserid(user.getUserid());
    	  getDiscussion().setUsername(user.getUsername());
    		getDiscussion().setDiscussionid((int) ((int) System.currentTimeMillis()*System.currentTimeMillis()/10000));
    		getDiscussion().setReplyid((int) ((int) System.currentTimeMillis()*System.currentTimeMillis()/11111));
    		iDiscussionManage.addT(getDiscussion());
    		setDiscussionid(discussion.getDiscussionid());
    	  return SUCCESS;
      }
      public String deleteDiscussionAction()throws Exception
      {
    	  Discussion discussion=new Discussion();
    	  discussion.setDiscussionid(getDiscussionid());
    	  discussion=(Discussion) iDiscussionManage.getRuslt(discussion).get(0);
    	  iDiscussionManage.deleteT(discussion);
    	  return SUCCESS;
      }
}
