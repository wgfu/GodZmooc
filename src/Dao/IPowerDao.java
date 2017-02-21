package Dao;

import Entity.Power;

public interface IPowerDao {
public Power getPower(String actionName);
public void addPower(Power power);
public void deletePower(Power power);
public void updatePower(Power power);
}