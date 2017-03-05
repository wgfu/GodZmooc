package Service;

import javax.annotation.Resource;

import Dao.ITestAndHomeworkDao;

public class HomeworkManageImp implements ITestAndHomeworkManage{

	@Resource ITestAndHomeworkDao iHomeworkDao;
	
	public ITestAndHomeworkDao getIHomeworkDao() {
		return iHomeworkDao;
	}

	public void setIHomeworkDao(ITestAndHomeworkDao iHomeworkDao) {
		this.iHomeworkDao = iHomeworkDao;
	}

	@Override
	public <T> T getRuslt(T t) {
		// TODO Auto-generated method stub
		
		return iHomeworkDao.getRuslt(t);
	}

	@Override
	public <T> void updateT(T t) {
		// TODO Auto-generated method stub
		iHomeworkDao.updateT(t);
	}

	@Override
	public <T> void deleteT(T t) {
		// TODO Auto-generated method stub
		iHomeworkDao.deleteT(t);
	}

	@Override
	public <T> void addT(T t) {
		// TODO Auto-generated method stub
		iHomeworkDao.addT(t);
	}

}
