package Service;

import java.util.List;

import Entity.Power;

public interface IPowerManage {
	public Power getPower(String actionName);
	public void addPower(Power power);
	public void deletePower(Power power);
	public void updatePower(Power power);
	public List<?> getAll();
}
