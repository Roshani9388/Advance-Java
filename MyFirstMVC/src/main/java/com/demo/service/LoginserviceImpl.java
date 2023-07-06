package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.MyUser;
import com.demo.dao.LoginDao;

@Service
public class LoginserviceImpl implements LoginService{
	
@Autowired	
private LoginDao ldao;

@Override
public MyUser validate(String uname, String password) {
	
	return ldao.validateUser(uname,password);
}
}
