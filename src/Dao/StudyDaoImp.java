package Dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;


import Entity.Study;

public class StudyDaoImp implements IStudyDao{
	  HibernateTemplate hibernateTemplate;
	    
		public HibernateTemplate getHibernateTemplate() {
			return hibernateTemplate;
		}

		public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
			this.hibernateTemplate = hibernateTemplate;
		}

	@Override
	public List<?> getStudy(String userid) {
		// TODO Auto-generated method stub
		
		String sql="from Study s where s.userid=?";
		 List<?> list=hibernateTemplate.find(sql, userid);
		if(!list.isEmpty()){return list;}
		return null;
	}

	@Override
	public void addStudy(Study study) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(study);
	}

	@Override
	public void deleteStudy(Study study) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(study);
	}

	@Override
	public void updateStudy(Study study) {
		// TODO Auto-generated method stub
		hibernateTemplate.merge(study);
	}

}
