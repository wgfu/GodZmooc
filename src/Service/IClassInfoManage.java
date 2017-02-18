package Service;

import java.util.List;

import Entity.ClassInfo;

public interface IClassInfoManage {
	public List<?> getClassInfo(int classid);
	public void addClassInfo(ClassInfo classInfo);
	public void deleteClassInfo(ClassInfo classInfo);
	public void updateClassInfo(ClassInfo classInfo);
	public List<?> getClassInfoByClassLevel(String classLevel);
	 public List<?>getClassInfoByUserid(String userid);
}
