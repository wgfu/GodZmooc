package Dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import Entity.Class;

public class ClassDaoImp implements IClassDao{
	 HibernateTemplate hibernateTemplate;
	    
		public HibernateTemplate getHibernateTemplate() {
			return hibernateTemplate;
		}

		public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
			this.hibernateTemplate = hibernateTemplate;
		}
@Override
public Class getClassByType(String type)
{
	Class class1=null;
	String sql="from Class c where c.type=?";
	 List<?> list=hibernateTemplate.find(sql, type);
	if(!list.isEmpty()){class1=(Class)list.get(0);}
	return class1;
	}


	@Override
	public void addClass(Class class1) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(class1);
		
	}

	@Override
	public void deleteClass(Class class1) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(class1);
	}

	@Override
	public void updateClass(Class class1) {
		// TODO Auto-generated method stub
		hibernateTemplate.merge(class1);
	}

}
