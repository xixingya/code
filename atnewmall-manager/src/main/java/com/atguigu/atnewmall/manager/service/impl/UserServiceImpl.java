package com.atguigu.atnewmall.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.atnewmall.bean.User;
import com.atguigu.atnewmall.manager.dao.UserDao;
import com.atguigu.atnewmall.manager.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public List<User> queryAll() {
		return userDao.queryAll();
	}

	public User queryLoginUser(User user) {
		return userDao.queryLoginUser(user);
	}
}
