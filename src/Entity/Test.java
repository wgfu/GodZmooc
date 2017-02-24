package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "test")
public class Test {
	private int id;
	private int testid;
	private int classid;
	private String url;
	private String answerurl;
	private String testname;
	private String testlevel;
	private String type;
	private String introduction;
	@Column(name="introduction", length=16777215)
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	@Column(name="testid", length=15)
	public int getTestid() {
		return testid;
	}
	public void setTestid(int testid) {
		this.testid = testid;
	}
	@Column(name="classid", length=15)
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}
	@Column(name="url", length=30)
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Column(name="answerurl", length=30)
	public String getAnswerurl() {
		return answerurl;
	}
	public void setAnswerurl(String answerurl) {
		this.answerurl = answerurl;
	}
	@Column(name="testname", length=30)
	public String getTestname() {
		return testname;
	}
	public void setTestname(String testname) {
		this.testname = testname;
	}
	@Column(name="testlevel", length=20)
	public String getTestlevel() {
		return testlevel;
	}
	public void setTestlevel(String testlevel) {
		this.testlevel = testlevel;
	}
	@Column(name="type", length=15)
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
