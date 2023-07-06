package com.demo.dao;

import java.util.List;

import com.demo.beans.MyUser;

public interface LoginDao {

	MyUser validateUser(String uname, String password);

}
