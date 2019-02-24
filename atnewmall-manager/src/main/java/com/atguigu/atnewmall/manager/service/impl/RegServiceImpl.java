package com.atguigu.atnewmall.manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.atnewmall.bean.User;
import com.atguigu.atnewmall.manager.dao.RegDao;
import com.atguigu.atnewmall.manager.service.RegService;

@Service
public class RegServiceImpl implements RegService {
	@Autowired
	private RegDao regDao;
	
	

	public User RegUser(User user) {
		// TODO Auto-generated method stub
		return regDao.regUser(user);
	}

}
