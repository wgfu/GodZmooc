package Entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "study")
public class Study {
	private int id;
    private String userid;
    private int classid;
    private Date starttime;
    private int testid;
    private int homeworkid;
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
	@Column(name="userid", length=20)
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	@Column(name="classid", length=15)
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}
	@Column(name="starttime")
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	@Column(name="testid", length=15)
	public int getTestid() {
		return testid;
	}
	public void setTestid(int testid) {
		this.testid = testid;
	}
	@Column(name="homework", length=15)
	public int getHomeworkid() {
		return homeworkid;
	}
	public void setHomeworkid(int homeworkid) {
		this.homeworkid = homeworkid;
	}
	
    
	

}
