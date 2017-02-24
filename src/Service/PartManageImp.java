package Service;

import javax.annotation.Resource;

import Dao.ITestAndHomeworkDao;

public class PartManageImp implements ITestAndHomeworkManage{
   @Resource
   private ITestAndHomeworkDao iPartDao;
	public ITestAndHomeworkDao getIPartDao() {
	return iPartDao;
}

public void setIPartDao(ITestAndHomeworkDao iPartDao) {
	this.iPartDao = iPartDao;
}

	@Override
	public <T> T getRuslt(Class<T> t) {
		// TODO Auto-generated method stub
		return iPartDao.getRuslt(t);
	}

	@Override
	public <T> void updateT(Class<T> t) {
		// TODO Auto-generated method stub
		iPartDao.updateT(t);
	}

	@Override
	public <T> void deleteT(Class<T> t) {
		// TODO Auto-generated method stub
		iPartDao.deleteT(t);
	}

	@Override
	public <T> void addT(Class<T> t) {
		// TODO Auto-generated method stub
		iPartDao.addT(t);
	}

}
