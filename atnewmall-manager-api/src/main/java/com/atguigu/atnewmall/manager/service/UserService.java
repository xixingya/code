package com.atguigu.atnewmall.manager.service;

import java.util.List;

import com.atguigu.atnewmall.bean.User;

public interface UserService {

	List<User> queryAll();

	User queryLoginUser(User user);

}
