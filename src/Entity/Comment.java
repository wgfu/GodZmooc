package Entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "comment")
public class Comment {
	private int id;
	private int commentid;
	private String userid;
	private String text;
	private String time;
	private int replyid;
	@Column(name="comment", length=15)
	public int getCommentid() {
		return commentid;
	}
	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}
	@Column(name="userid", length=20)
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	@Column(name="text", length=16777215)
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Column(name="time", length=30)
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Column(name="replyid", length=20)
	public int getReplyid() {
		return replyid;
	}
	
	public void setReplyid(int replyid) {
		this.replyid = replyid;
	}
	@Id
	//采用数据库自增方式生成主键
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
