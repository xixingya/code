package com.atguigu.atnewmall.manager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.atguigu.atnewmall.bean.User;

public interface UserDao {

	@Select("select * from t_user")
	List<User> queryAll();

	User queryLoginUser(User user);

}
