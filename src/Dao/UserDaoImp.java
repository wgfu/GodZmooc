package Dao;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import Entity.User;

public class UserDaoImp implements IUserDao{
	private HibernateTemplate hibernateTemplate;

	 public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {  
		        this.hibernateTemplate = hibernateTemplate;  
		    } 
	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		User user =null;
		String sql="from User u where u.username=?";
		 List<?> list=hibernateTemplate.find(sql, username);
		if(!list.isEmpty()){user=(User)list.get(0);}
		return user;
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(user);
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(user);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		hibernateTemplate.merge(user);
		
	}
	public User getUserByUserid(String userid)
	{// TODO Auto-generated method stub
	User user =null;
	String sql="from User u where u.userid=?";
	 List<?> list=hibernateTemplate.find(sql, userid);
	if(!list.isEmpty()){user=(User)list.get(0);}
	return user;
}
}
