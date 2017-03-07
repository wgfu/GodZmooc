package Dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import Entity.Homework;

public class HomeworkDaoImp implements ITestAndHomeworkDao{
	 private HibernateTemplate hibernateTemplate;
	   
		public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getRuslt(T t) {
		// TODO Auto-generated method stub
	Homework homework=null;
		 List<?> list=hibernateTemplate.findByExample(t);
		if(!list.isEmpty()){
			homework=(Homework) list.get(0);
			return (T) homework;
			}
		return (T) homework;
	}

	@Override
	public <T> void updateT(T t) {
		// TODO Auto-generated method stub
		hibernateTemplate.merge(t);
	}

	@Override
	public <T> void deleteT(T t) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(t);
	}

	@Override
	public <T> void addT(T t) {
		// TODO Auto-generated method stub
		
		hibernateTemplate.save(t);
	}

}
