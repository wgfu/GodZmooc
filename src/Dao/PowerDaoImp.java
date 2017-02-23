package Dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import Entity.Power;


public class PowerDaoImp implements IPowerDao{
	private HibernateTemplate hibernateTemplate;

	 public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {  
		        this.hibernateTemplate = hibernateTemplate;  
		    } 
	@Override
	public Power getPower(String actionName) {
		// TODO Auto-generated method stub
		Power power=null;
		String sql="from Power p where p.actionName=?";
		 List<?> list=hibernateTemplate.find(sql, actionName);
		if(!list.isEmpty()){power=(Power)list.get(0);}
		return power;
		
	}

	@Override
	public void addPower(Power power) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(power);
		
	}

	@Override
	public void deletePower(Power power) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(power);
		
	}

	@Override
	public void updatePower(Power power) {
		// TODO Auto-generated method stub
		hibernateTemplate.merge(power);
	}

}
