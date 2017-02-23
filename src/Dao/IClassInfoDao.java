package Dao;

import Entity.ClassInfo;

public interface IClassInfoDao {
	public ClassInfo getClassInfo(int classid);
	public void addClassInfo(ClassInfo classInfo);
	public void deleteClassInfo(ClassInfo classInfo);
	public void updateClassInfo(ClassInfo classInfo);

}
