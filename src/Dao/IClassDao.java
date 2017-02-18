package Dao;
import Entity.Class;
public interface IClassDao {

public void addClass(Class class1);
public void deleteClass(Class class1);
public void updateClass(Class class1);
public Class getClassByType(String type);

}
