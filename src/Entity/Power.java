package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "power")
public class Power {
private int id;
private String actionName;
private int level;
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
@Column(name="actionName", length=30, nullable=false, unique=true)
public String getActionName() {
	return actionName;
}
public void setActionName(String actionName) {
	this.actionName = actionName;
}
@Column(name="level", length=5, nullable=false, unique=true)
public int getLevel() {
	return level;
}
public void setLevel(int level) {
	this.level = level;
}

}
