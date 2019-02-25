package tech.petmall.petmall.manager.service;

import java.util.List;

import tech.petmall.petmall.bean.User;

public interface UserService {

	List<User> queryAll();

	User queryLoginUser(User user);

}
