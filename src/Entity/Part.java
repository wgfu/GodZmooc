package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "part")
public class Part {
	private int id;
	private int partid;
	private String partname;
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
	@Column(name="partid", length=15)
	public int getPartid() {
		return partid;
	}
	public void setPartid(int partid) {
		this.partid = partid;
	}
	@Column(name="partname", length=20)
	public String getPartname() {
		return partname;
	}
	public void setPartname(String partname) {
		this.partname = partname;
	}
	

}
