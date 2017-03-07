package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "homework")
public class Homework {
	private int id;
	private Integer homeworkid;
	private Integer classid;
	private String url;
	private String answerurl;
	private String homeworkname;
	private String homeworklevel;
	private String type;
	private String introduction;
	@Column(name="homeworkid", length=15)
	public Integer getHomeworkid() {
		return homeworkid;
	}
	public void setHomeworkid(Integer homeworkid) {
		this.homeworkid = homeworkid;
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
	@Column(name="answerurl", length=200)
	public String getAnswerurl() {
		return answerurl;
	}
	public void setAnswerurl(String answerurl) {
		this.answerurl = answerurl;
	}
	@Column(name="homeworkname", length=30)
	public String getHomeworkname() {
		return homeworkname;
	}
	public void setHomeworkname(String homeworkname) {
		this.homeworkname = homeworkname;
	}
	@Column(name="homeworklevel", length=15)
	public String getHomeworklevel() {
		return homeworklevel;
	}
	public void setHomeworklevel(String homeworklevel) {
		this.homeworklevel = homeworklevel;
	}
	@Column(name="type", length=15)
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Column(name="introduction", length=16777215)
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
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
