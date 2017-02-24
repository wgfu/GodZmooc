package Dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import Entity.Comment;;

public class CommentDaoImp implements ITestAndHomeworkDao{
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
		Comment comment=null;
		String sql="from Comment c where c.partid=?";
		 List<?> list=hibernateTemplate.find(sql, t);
		if(!list.isEmpty())
		{
			return (T) list;
		}
		else
		{
			return (T) comment;
		}
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
