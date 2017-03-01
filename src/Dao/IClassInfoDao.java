package Dao;

import java.util.List;

import Entity.ClassInfo;

public interface IClassInfoDao {
	public List<?> getClassInfo(int classid);
	public void addClassInfo(ClassInfo classInfo);
	public void deleteClassInfo(ClassInfo classInfo);
	public void updateClassInfo(ClassInfo classInfo);
	public List<?> getClassInfoByClassLevel(String classLevel);
	 public List<?> getClassInfoByUserid(String userid);
	 public List<?> getClassInfoDefault(ClassInfo classInfo);
}
