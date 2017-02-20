package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userInfo")
public class UserInfo {
	private int id;
	
	private String userid;
	private String email;
	private String school;
	private String degree;
	private String education;
	private String tel;
	private String name;
	private String birth;
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
	@Column(name="userid", length=10, nullable=false, unique=true)
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	@Column(name="email", length=30, nullable=false, unique=true)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="school", length=30, nullable=false, unique=true)
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	@Column(name="degree", length=10, nullable=false, unique=true)
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	@Column(name="eduction", length=10, nullable=false, unique=true)
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	@Column(name="tel", length=20, nullable=false, unique=true)
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Column(name="name", length=10, nullable=false, unique=true)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="birth", length=20, nullable=false, unique=true)
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}

}
