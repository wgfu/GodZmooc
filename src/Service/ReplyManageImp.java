package Service;

import javax.annotation.Resource;

import Dao.ICommentPartDao;




public class ReplyManageImp implements ICommentPartManage{
   @Resource
   private ICommentPartDao iReplyDao;
	public ICommentPartDao getIReplyDao() {
	return iReplyDao;
}

public void setIReplyDao(ICommentPartDao iReplyDao) {
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
