package Service;

import javax.annotation.Resource;

import Dao.ITestAndHomeworkDao;

public class ScoreManageImp implements ITestAndHomeworkManage{
@Resource
private ITestAndHomeworkDao iScoreDao;
	public ITestAndHomeworkDao getIScoreDao() {
	return iScoreDao;
}

public void setIScoreDao(ITestAndHomeworkDao iScoreDao) {
	this.iScoreDao = iScoreDao;
}

	@Override
	public <T> T getRuslt(Class<T> t) {
		// TODO Auto-generated method stub
		return iScoreDao.getRuslt(t);
	}

	@Override
	public <T> void updateT(Class<T> t) {
		// TODO Auto-generated method stub
		iScoreDao.updateT(t);
	}

	@Override
	public <T> void deleteT(Class<T> t) {
		// TODO Auto-generated method stub
		iScoreDao.deleteT(t);
	}

	@Override
	public <T> void addT(Class<T> t) {
		// TODO Auto-generated method stub
		iScoreDao.addT(t);
	}
	

}
