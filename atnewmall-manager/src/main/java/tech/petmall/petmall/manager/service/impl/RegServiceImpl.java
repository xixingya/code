package tech.petmall.petmall.manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.petmall.petmall.bean.User;
import tech.petmall.petmall.manager.dao.RegDao;
import tech.petmall.petmall.manager.service.RegService;

@Service
public class RegServiceImpl implements RegService {
	@Autowired
	private RegDao regDao;
	
	

	public User RegUser(User user) {
		// TODO Auto-generated method stub
		return regDao.regUser(user);
	}

}
