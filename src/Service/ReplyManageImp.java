package Service;

import javax.annotation.Resource;

import Dao.ITestAndHomeworkDao;

public class ReplyManageImp implements ITestAndHomeworkManage{
   @Resource
   private ITestAndHomeworkDao iReplyDao;
	public ITestAndHomeworkDao getIReplyDao() {
	return iReplyDao;
}

public void setIReplyDao(ITestAndHomeworkDao iReplyDao) {
	this.iReplyDao = iReplyDao;
}

	@Override
	public <T> T getRuslt(Class<T> t) {
		// TODO Auto-generated method stub
		return iReplyDao.getRuslt(t);
	}

	@Override
	public <T> void updateT(Class<T> t) {
		// TODO Auto-generated method stub
		iReplyDao.updateT(t);
	}

	@Override
	public <T> void deleteT(Class<T> t) {
		// TODO Auto-generated method stub
		iReplyDao.deleteT(t);
	}

	@Override
	public <T> void addT(Class<T> t) {
		// TODO Auto-generated method stub
		iReplyDao.addT(t);
	}

}
