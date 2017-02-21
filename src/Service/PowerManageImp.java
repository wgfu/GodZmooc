package Service;

import javax.annotation.Resource;

import Dao.IPowerDao;
import Entity.Power;

public class PowerManageImp implements IPowerManage{
   @Resource
   private IPowerDao iPowerDao;
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
}
