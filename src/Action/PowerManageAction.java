package Action;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;

import Service.IPowerManage;
import Service.IUserManage;

public class PowerManageAction extends ActionSupport{
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
	private int power;
	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
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
		return SUCCESS;
	}
	
	public String changePowerInfoAction() throws Exception
	{
		return SUCCESS;
	}
	
	public String changeUserPowerActino() throws Exception
	{
		return SUCCESS;
	}
}
