package Service;

import java.util.List;

import Dao.IClassInfoDao;
import Entity.ClassInfo;

public class ClassInfoManageImp implements IClassInfoManage{
   private IClassInfoDao iClassInfoDao;
	public IClassInfoDao getIClassInfoDao() {
	return iClassInfoDao;
}

public void setIClassInfoDao(IClassInfoDao iClassInfoDao) {
	this.iClassInfoDao = iClassInfoDao;
}

	@Override
	public List<?> getClassInfo(int classid) {
		// TODO Auto-generated method stub
		return iClassInfoDao.getClassInfo(classid);
	}

	@Override
	public void addClassInfo(ClassInfo classInfo) {
		// TODO Auto-generated method stub
		iClassInfoDao.addClassInfo(classInfo);
	}

	@Override
	public void deleteClassInfo(ClassInfo classInfo) {
		// TODO Auto-generated method stub
		iClassInfoDao.deleteClassInfo(classInfo);
	}

	@Override
	public void updateClassInfo(ClassInfo classInfo) {
		// TODO Auto-generated method stub
		iClassInfoDao.updateClassInfo(classInfo);
	}
	 public List<?> getClassInfoByClassLevel(String classLevel)
	   {
		return iClassInfoDao.getClassInfoByClassLevel(classLevel);
	   }
	   @Override
	   public List<?>getClassInfoByUserid(String userid)
	   {
		   return iClassInfoDao.getClassInfoByUserid(userid);
	   }
	   public List<?> getClassInfoDefault(ClassInfo classInfo)
	   {
		   return iClassInfoDao.getClassInfoDefault(classInfo);
	   }
}
