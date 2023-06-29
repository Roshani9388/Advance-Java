package demo.com.dao;

import demo.com.beans.MyUser;
import demo.com.beans.RegisterUser;

public interface LoginDao {

	MyUser ValidateUser(String uname, String password);


	int addUser(RegisterUser ru, MyUser user);

}
