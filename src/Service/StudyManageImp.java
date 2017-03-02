package Service;

import java.util.List;

import javax.annotation.Resource;

import Dao.IStudyDao;
import Entity.Study;

public class StudyManageImp implements IStudyManage{
   @Resource
   private IStudyDao iStudyDao;
	public IStudyDao getIStudyDao() {
	return iStudyDao;
}

public void setIStudyDao(IStudyDao iStudyDao) {
	this.iStudyDao = iStudyDao;
}

	@Override
	public List<?> getStudy(String userid) {
		// TODO Auto-generated method stub
		return iStudyDao.getStudy(userid);
	}

	@Override
	public void addStudy(Study study) {
		// TODO Auto-generated method stub
		iStudyDao.addStudy(study);
	}

	@Override
	public void deleteStudy(Study study) {
		// TODO Auto-generated method stub
		iStudyDao.deleteStudy(study);
	}

	@Override
	public void updateStudy(Study study) {
		// TODO Auto-generated method stub
		iStudyDao.updateStudy(study);
	}

}
