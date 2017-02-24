package Service;

import javax.annotation.Resource;

import Dao.ITestAndHomeworkDao;

public class CommentManageImp implements ITestAndHomeworkManage{
@Resource
private ITestAndHomeworkDao iCommentDao;

	public ITestAndHomeworkDao getICommentDao() {
	return iCommentDao;
}

public void setICommentDao(ITestAndHomeworkDao iCommentDao) {
	this.iCommentDao = iCommentDao;
}

	@Override
	public <T> T getRuslt(Class<T> t) {
		// TODO Auto-generated method stub
		return iCommentDao.getRuslt(t);
	}

	@Override
	public <T> void updateT(Class<T> t) {
		// TODO Auto-generated method stub
		iCommentDao.updateT(t);
	}

	@Override
	public <T> void deleteT(Class<T> t) {
		// TODO Auto-generated method stub
		iCommentDao.deleteT(t);
	}

	@Override
	public <T> void addT(Class<T> t) {
		// TODO Auto-generated method stub
		iCommentDao.addT(t);
	}

}
