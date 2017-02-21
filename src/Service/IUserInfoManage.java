package Service;

import Entity.UserInfo;

public interface IUserInfoManage {
	public UserInfo getUserInfo(String userid);
	public void addUserInfo(UserInfo userInfo);
	public void deleteUserInfo(UserInfo userInfo);
	public void updateUserInfo(UserInfo userInfo);
}
