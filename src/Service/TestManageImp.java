package Service;

import javax.annotation.Resource;

import Dao.ITestAndHomeworkDao;

public class TestManageImp implements ITestAndHomeworkManage{
@Resource
private ITestAndHomeworkDao iTestDao;
	public ITestAndHomeworkDao getITestDao() {
	return iTestDao;
}

public void setITestDao(ITestAndHomeworkDao iTestDao) {
	this.iTestDao = iTestDao;
}

	@Override
	public <T> T getRuslt(Class<T> t) {
		// TODO Auto-generated method stub
		return iTestDao.getRuslt(t);
	}

	@Override
	public <T> void updateT(Class<T> t) {
		// TODO Auto-generated method stub
		iTestDao.updateT(t);
	}

	@Override
	public <T> void deleteT(Class<T> t) {
		// TODO Auto-generated method stub
		iTestDao.deleteT(t);
	}

	@Override
	public <T> void addT(Class<T> t) {
		// TODO Auto-generated method stub
		iTestDao.addT(t);
	}

}
