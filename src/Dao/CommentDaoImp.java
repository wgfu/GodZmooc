package Dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import Entity.Comment;;

public class CommentDaoImp implements ICommentPartDao{
private HibernateTemplate hibernateTemplate;
    
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<?> getRuslt(T t) {
		// TODO Auto-generated method stub
		
		String sql="from Comment c where c.partid=?";
		 List<?> list=hibernateTemplate.find(sql, t);
		if(!list.isEmpty())
		{
			return  list;
		}
		else
		{
			return null;
		}
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
