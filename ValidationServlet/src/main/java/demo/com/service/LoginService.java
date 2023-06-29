package demo.com.service;

import demo.com.beans.MyUser;
import demo.com.beans.RegisterUser;

public interface LoginService {

	MyUser validateUser(String uname, String password);

	int addRegisterUser(RegisterUser ru, MyUser user);

}
