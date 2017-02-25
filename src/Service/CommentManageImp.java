package Service;

import javax.annotation.Resource;

import Dao.ICommentPartDao;


public class CommentManageImp implements ICommentPartManage{
@Resource
private ICommentPartDao iCommentDao;

	public ICommentPartDao getICommentDao() {
	return iCommentDao;
}

public void setICommentDao(ICommentPartDao iCommentDao) {
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
