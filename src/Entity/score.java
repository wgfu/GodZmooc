package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "score")
public class score {
	private int id;
	private int testid;
	private String userid;
	
	private int classid;
	private double score;
	private String time;
	@Column(name="testid", length=15)
	public int getTestid() {
		return testid;
	}
	public void setTestid(int testid) {
		this.testid = testid;
	}
	@Column(name="userid", length=30)
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
	@Column(name="score", length=4)
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	@Column(name="time", length=30)
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
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
