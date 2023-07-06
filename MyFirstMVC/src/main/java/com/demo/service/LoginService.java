package com.demo.service;

import java.util.List;

import com.demo.beans.MyUser;

public interface LoginService {

	MyUser validate(String uname, String password);

}
