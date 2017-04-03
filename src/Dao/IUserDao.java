package Dao;

import Entity.User;

public interface IUserDao {
	public User getUser(String username);
	public void addUser(User user);
	public void deleteUser(User user);
	public void updateUser(User user);
	public User getUserByUserid(String userid);
}