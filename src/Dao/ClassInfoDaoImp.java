package Dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import Entity.ClassInfo;


public class ClassInfoDaoImp implements IClassInfoDao{
    HibernateTemplate hibernateTemplate;
    
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public ClassInfo getClassInfo(int classid) {
		// TODO Auto-generated method stub
				ClassInfo classInfo=null;
				String sql="from ClassInfo c where c.classid=?";
				 List<?> list=hibernateTemplate.find(sql, classid);
				if(!list.isEmpty()){classInfo=(ClassInfo)list.get(0);}
				return classInfo;
	}

	@Override
	public void addClassInfo(ClassInfo classInfo) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(classInfo);
		
	}

	@Override
	public void deleteClassInfo(ClassInfo classInfo) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(classInfo);
	}

	@Override
	public void updateClassInfo(ClassInfo classInfo) {
		// TODO Auto-generated method stub
		hibernateTemplate.merge(classInfo);
	}

}
