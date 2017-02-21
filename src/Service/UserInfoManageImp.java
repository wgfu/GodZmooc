package Service;

import javax.annotation.Resource;

import Dao.IUserInfoDao;
import Entity.UserInfo;

public class UserInfoManageImp implements IUserInfoManage{
@Resource
private IUserInfoDao iUserInfoDao;
	@Override
	public UserInfo getUserInfo(String userid) {
		// TODO Auto-generated method stub
		return iUserInfoDao.getUserInfo(userid);
	}

	@Override
	public void addUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		iUserInfoDao.addUserInfo(userInfo);
	}

	@Override
	public void deleteUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		iUserInfoDao.deleteUserInfo(userInfo);
	}

	@Override
	public void updateUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		iUserInfoDao.updateUserInfo(userInfo);
	}

}
