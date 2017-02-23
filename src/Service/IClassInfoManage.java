package Service;

import Entity.ClassInfo;

public interface IClassInfoManage {
	public ClassInfo getClassInfo(int classid);
	public void addClassInfo(ClassInfo classInfo);
	public void deleteClassInfo(ClassInfo classInfo);
	public void updateClassInfo(ClassInfo classInfo);
}
