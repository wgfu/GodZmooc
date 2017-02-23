package Dao;
import Entity.Class;
public interface IClassDao {
public Class getClassByUserid(String userid);
public Class getClassByClassid(int classid);
public void addClass(Class class1);
public void deleteClass(Class class1);
public void updateClass(Class class1);

}
