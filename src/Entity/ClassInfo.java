package Entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "classInfo")
public class ClassInfo {
	private String classname;
	private Integer classid;
	private String url;
	private Integer testid;
	private Integer homeworkid;
	private String type;//视频或者文章
	private String classLevel;
	private String userid;
	private Date time;
	private Integer commentid;
	private Integer classInfoid;
	@Column(name="classInfoid", length=15)
	public Integer getClassInfoid() {
		return classInfoid;
	}
	public void setClassInfoid(Integer classInfoid) {
		this.classInfoid = classInfoid;
	}
	@Column(name="commentid", length=15)
	public Integer getCommentid() {
		return commentid;
	}
	public void setCommentid(Integer commentid) {
		this.commentid = commentid;
	}
	@Column(name="time")
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Column(name="userid", length=10)
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	@Column(name="classLevel", length=10)
	public String getClassLevel() {
		return classLevel;
	}
	public void setClassLevel(String classLevel) {
		this.classLevel = classLevel;
	}
	private String introduction;
	@Column(name="introduction", length=1000)
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	private int id;
	@Column(name="classname", length=20)
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	@Column(name="classid", length=15)
	public Integer getClassid() {
		return classid;
	}
	public void setClassid(Integer classid) {
		this.classid = classid;
	}
	@Column(name="url", length=200)
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Column(name="testid", length=15)
	public Integer getTestid() {
		return testid;
	}
	public void setTestid(Integer testid) {
		this.testid = testid;
	}
	@Column(name="homeworkid", length=15)
	public Integer getHomeworkid() {
		return homeworkid;
	}
	public void setHomeworkid(Integer homeworkid) {
		this.homeworkid = homeworkid;
	}
	@Column(name="type", length=10)
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
