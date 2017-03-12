package Service;

import java.util.List;

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
	public <T> List<?> getRuslt(T t) {
		// TODO Auto-generated method stub
		return iReplyDao.getRuslt(t);
	}

	@Override
	public <T> void updateT(T t) {
		// TODO Auto-generated method stub
		iReplyDao.updateT(t);
	}

	@Override
	public <T> void deleteT(T t) {
		// TODO Auto-generated method stub
		iReplyDao.deleteT(t);
	}

	@Override
	public <T> void addT(T t) {
		// TODO Auto-generated method stub
		iReplyDao.addT(t);
	}

}
