package Service;

import java.util.List;

public class DiscussionManageImp implements ICommentPartManage{

	private ICommentPartManage iDiscussionDao;

	public ICommentPartManage getIDiscussionDao() {
		return iDiscussionDao;
	}

	public void setIDiscussionDao(ICommentPartManage iDiscussionDao) {
		this.iDiscussionDao = iDiscussionDao;
	}

	@Override
	public <T> List<?> getRuslt(T t) {
		// TODO Auto-generated method stub
		return iDiscussionDao.getRuslt(t);
	}

	@Override
	public <T> void updateT(T t) {
		// TODO Auto-generated method stub
		iDiscussionDao.updateT(t);
	}

	@Override
	public <T> void deleteT(T t) {
		// TODO Auto-generated method stub
		iDiscussionDao.deleteT(t);
	}

	@Override
	public <T> void addT(T t) {
		// TODO Auto-generated method stub
		iDiscussionDao.addT(t);
	}
	
}
