package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;	

@Entity
@Table(name = "user")
public class User {

	private String userid;
	private int id;
	private String password;
	private String username;
	
	private int power;
	private String type;
	
	@Column(name="userid", length=20, nullable=false, unique=true)
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
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
	@Column(name="password", length=30, nullable=false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name="username", length=20, nullable=false, unique=true)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	@Column(name="power", length=5, nullable=false)
	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}
	@Column(name="type", length=10, nullable=false)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
