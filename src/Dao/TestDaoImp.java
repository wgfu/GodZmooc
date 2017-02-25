package Dao;

import java.util.List;


import org.springframework.orm.hibernate3.HibernateTemplate;

public class TestDaoImp implements ITestAndHomeworkDao{
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
		// TODO Auto-generated method stub
		String sql="from Test t where t.classid=?";
		 List<?> list=hibernateTemplate.find(sql, t);
		if(!list.isEmpty()){return (T) list;}
		return null;
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
