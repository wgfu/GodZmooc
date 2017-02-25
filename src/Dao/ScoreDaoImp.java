package Dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import Entity.score;


public class ScoreDaoImp implements ITestAndHomeworkDao{
	private HibernateTemplate hibernateTemplate;
	   
	public HibernateTemplate getHibernateTemplate() {
	return hibernateTemplate;
}

public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
	this.hibernateTemplate = hibernateTemplate;
}
	@SuppressWarnings("unchecked")
	@Override
	public <T> T getRuslt(Class<T> t) {
		score score=null;
		String sql="from score s where s.testid=?";
		 List<?> list=hibernateTemplate.find(sql, t);
		if(!list.isEmpty()){score=(score)list.get(0);}
		return  (T) score;
	}

	@Override
	public <T> void updateT(Class<T> t) {
		// TODO Auto-generated method stub
		hibernateTemplate.merge(t);
	}

	@Override
	public <T> void deleteT(Class<T> t) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(t);
	}

	@Override
	public <T> void addT(Class<T> t) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(t);
	}

}
