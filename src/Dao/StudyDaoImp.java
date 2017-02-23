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
	public Study getStudy(String userid) {
		// TODO Auto-generated method stub
		Study study=null;
		String sql="from Study s where s.userid=?";
		 List<?> list=hibernateTemplate.find(sql, userid);
		if(!list.isEmpty()){study=(Study)list.get(0);}
		return study;
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
