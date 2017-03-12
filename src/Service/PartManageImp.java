package Service;

import java.util.List;

import javax.annotation.Resource;

import Dao.ICommentPartDao;




public class PartManageImp implements ICommentPartManage{
   @Resource
   private ICommentPartDao iPartDao;
	public ICommentPartDao getIPartDao() {
	return iPartDao;
}

public void setIPartDao(ICommentPartDao iPartDao) {
	this.iPartDao = iPartDao;
}

	@Override
	public <T> List<?> getRuslt(T t) {
		// TODO Auto-generated method stub
		return iPartDao.getRuslt(t);
	}

	@Override
	public <T> void updateT(T t) {
		// TODO Auto-generated method stub
		iPartDao.updateT(t);
	}

	@Override
	public <T> void deleteT(T t) {
		// TODO Auto-generated method stub
		iPartDao.deleteT(t);
	}

	@Override
	public <T> void addT(T t) {
		// TODO Auto-generated method stub
		iPartDao.addT(t);
	}

}
