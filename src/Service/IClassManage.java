package Service;

import Entity.Class;

public interface IClassManage {
	public Class getClassByUserid(String userid);
	public Class getClassByClassid(int classid);
	public void addClass(Class class1);
	public void deleteClass(Class class1);
	public void updateClass(Class class1);
}
