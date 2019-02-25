package tech.petmall.petmall.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.petmall.petmall.bean.User;
import tech.petmall.petmall.manager.dao.UserDao;
import tech.petmall.petmall.manager.service.UserService;

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
