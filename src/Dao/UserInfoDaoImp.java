package Dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import Entity.UserInfo;

public class UserInfoDaoImp implements IUserInfoDao{
	private HibernateTemplate hibernateTemplate;

	 public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {  
		        this.hibernateTemplate = hibernateTemplate;  
		    } 
	@Override
	public UserInfo getUserInfo(String userid) {
		// TODO Auto-generated method stub
		UserInfo userInfo =null;
		String sql="from userinfo u where u.userid=?";
		 List<?> list=hibernateTemplate.find(sql, userid);
		if(!list.isEmpty()){userInfo=(UserInfo)list.get(0);}
		return userInfo;
		
	}

	@Override
	public void addUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(userInfo);
	}

	@Override
	public void deleteUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(userInfo);
	}

	@Override
	public void updateUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(userInfo);
	}

}
