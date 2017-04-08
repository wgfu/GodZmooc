package Action;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;

import Entity.Power;
import Entity.User;
import Service.IPowerManage;
import Service.IUserManage;
import oracle.net.aso.i;

public class PowerManageAction extends ActionSupport{
	private Power power;
	public Power getPower() {
		return power;
	}

	public void setPower(Power power) {
		this.power = power;
	}

	private int level;
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	private String actionName;
	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	@Resource
	private IPowerManage iPowerManage;
	public IPowerManage getIPowerManage() {
		return iPowerManage;
	}

	public void setIPowerManage(IPowerManage iPowerManage) {
		this.iPowerManage = iPowerManage;
	}

	public IUserManage getIUserManage() {
		return iUserManage;
	}

	public void setIUserManage(IUserManage iUserManage) {
		this.iUserManage = iUserManage;
	}

	@Resource
	private IUserManage iUserManage;
	private int powernum;
	public int getPowernum() {
		return powernum;
	}

	public void setPowernum(int powernum) {
		this.powernum = powernum;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	private String userid;

	public String addPowerInfoAction() throws Exception
	{
		String actionname=power.getActionName();
		if(iPowerManage.getPower(actionname)==null)
		{
			iPowerManage.addPower(getPower());
		}
		
		
		return SUCCESS;
	}
	
	public String changePowerInfoAction() throws Exception
	{
		Power power=iPowerManage.getPower(getActionName());
		power.setLevel(getLevel());
		iPowerManage.updatePower(power);
		return SUCCESS;
	}
	
	public String changeUserPowerAction() throws Exception
	{
		User user=iUserManage.getUserByUserid(getUserid());
		user.setPower(getPowernum());
		iUserManage.updateUser(user);
		return SUCCESS;
	}
}
