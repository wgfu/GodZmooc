package Dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

public class DiscussionDaoImp implements ICommentPartDao{
private HibernateTemplate hibernateTemplate;
    
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public <T> List<?> getRuslt(T t) {
		// TODO Auto-generated method stub
		if(t!=null&&t!="")
		{
	
		 List<?> list=hibernateTemplate.findByExample(t);
		
		if(!list.isEmpty()){return list;}
		return null;
		}
	else{
		String sql="from Discussion d";
		 List<?> list=hibernateTemplate.find(sql);
		
		if(!list.isEmpty()){return list;}
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
