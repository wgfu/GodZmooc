package Dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import Entity.Reply;

public class ReplyDaoImp implements ICommentPartDao{
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
	
			String sql="from Reply p where p.replyid=?";
			 List<?> list=hibernateTemplate.find(sql, t);
			if(!list.isEmpty()){
				return  list;
				}
			
			return null;
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
