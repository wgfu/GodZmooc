package Service;

import java.util.List;

import javax.annotation.Resource;

import Dao.IPowerDao;
import Entity.Power;

public class PowerManageImp implements IPowerManage{
   @Resource
   private IPowerDao iPowerDao;
	public IPowerDao getIPowerDao() {
	return this.iPowerDao;
}

public void setIPowerDao(IPowerDao iPowerDao) {
	this.iPowerDao = iPowerDao;
}

	@Override
	public Power getPower(String actionName) {
		// TODO Auto-generated method stub
		return iPowerDao.getPower(actionName);
	}

	@Override
	public void addPower(Power power) {
		// TODO Auto-generated method stub
		iPowerDao.addPower(power);
	}

	@Override
	public void deletePower(Power power) {
		// TODO Auto-generated method stub
		iPowerDao.deletePower(power);
	}

	@Override
	public void updatePower(Power power) {
		// TODO Auto-generated method stub
		iPowerDao.updatePower(power);
	}
	public List<?> getAll()
	{
		return iPowerDao.getAll();
	}
}
