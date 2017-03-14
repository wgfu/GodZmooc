package Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "discussion")
public class Discussion {
	private Integer partid;
	private Integer replyid;
	private Integer discussionid;
	private String userid;
	private Date time;
	private String text;
	private String title;
	private String username;
	@Column(name="partid", length=15)
	public Integer getPartid() {
		return partid;
	}
	public void setPartid(Integer partid) {
		this.partid = partid;
	}
	@Column(name="replyid", length=15)
	public Integer getReplyid() {
		return replyid;
	}
	public void setReplyid(Integer replyid) {
		this.replyid = replyid;
	}
	@Column(name="discussionid", length=15)
	public Integer getDiscussionid() {
		return discussionid;
	}
	public void setDiscussionid(Integer discussionid) {
		this.discussionid = discussionid;
	}
	@Column(name="userid", length=30)
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	@Column(name="time")
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Column(name="text", length=16777215)
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Column(name="title",length=100)
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Column(name="username",length=20)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	private int id;
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
