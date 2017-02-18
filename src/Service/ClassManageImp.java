package Service;

import javax.annotation.Resource;

import Dao.IClassDao;
import Entity.Class;

public class ClassManageImp implements IClassManage{
    @Resource
    private IClassDao iClassDao;
    
	public IClassDao getIClassDao() {
		return iClassDao;
	}

	public void setIClassDao(IClassDao iClassDao) {
		this.iClassDao = iClassDao;
	}
@Override
public Class getClassByType(String type)
{
	return iClassDao.getClassByType(type);}


	@Override
	public void addClass(Class class1) {
		// TODO Auto-generated method stub
		iClassDao.addClass(class1);
	}

	@Override
	public void deleteClass(Class class1) {
		// TODO Auto-generated method stub
		iClassDao.deleteClass(class1);
	}

	@Override
	public void updateClass(Class class1) {
		// TODO Auto-generated method stub
		iClassDao.updateClass(class1);
	}

}
