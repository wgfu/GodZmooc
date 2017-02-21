package Service;

import Entity.User;

public interface IUserManage {
	public User getUser(String username);
	public void addUser(User user);
	public void deleteUser(User user);
	public void updateUser(User user);
}
