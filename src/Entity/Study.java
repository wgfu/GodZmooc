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
    private Date starttime;
    private int testid;
    private int homeworkid;
    private Integer classInfoid;
	@Column(name="classInfoid", length=15)
	public Integer getClassInfoid() {
		return classInfoid;
	}
	public void setClassInfoid(Integer classInfoid) {
		this.classInfoid = classInfoid;
	}
    @Id
	//�������ݿ�������ʽ��������
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
	@Column(name="homeworkid", length=15)
	public int getHomeworkid() {
		return homeworkid;
	}
	public void setHomeworkid(int homeworkid) {
		this.homeworkid = homeworkid;
	}
	
    
	

}
