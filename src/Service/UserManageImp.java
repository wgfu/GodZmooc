package Service;

import javax.annotation.Resource;

import Dao.IUserDao;
import Entity.User;

public class UserManageImp implements IUserManage{
    @Resource
    private IUserDao iUserDao;
	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return iUserDao.getUser(username);
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		iUserDao.addUser(user);
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		iUserDao.deleteUser(user);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		iUserDao.updateUser(user);
	}

}
