package Dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import Entity.Part;



public class PartDaoImp implements ITestAndHomeworkDao{
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
		Part part=null;
		String sql="from Part p where p.partname=?";
		 List<?> list=hibernateTemplate.find(sql, t);
		if(!list.isEmpty()){part=(Part)list.get(0);}
		return (T) part;
		
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
