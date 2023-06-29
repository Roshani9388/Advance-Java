package demo.com.service;

import demo.com.beans.MyUser;
import demo.com.beans.RegisterUser;
import demo.com.dao.LoginDao;
import demo.com.dao.LoginDaoImpl;

public class LoginServiceImpl implements LoginService {

	private LoginDao ld;
	
	public LoginServiceImpl() {
		super();
		this.ld = new LoginDaoImpl();
	}
	
	
	@Override
	public MyUser validateUser(String uname, String password) {
		
		return ld.ValidateUser(uname,password);
	}


	@Override
	public int addRegisterUser(RegisterUser ru, MyUser user) {
		return ld.addUser(ru,user);
		
	}
	

}
