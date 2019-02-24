package com.atguigu.atnewmall.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.atnewmall.bean.AJAXResult;
import com.atguigu.atnewmall.bean.User;
import com.atguigu.atnewmall.common.util.MD5Util;
import com.atguigu.atnewmall.manager.service.RegService;;
//是发放的范德萨
@Controller
@RequestMapping("/user")
public class RegController {
	@Autowired
	private RegService regService;
	@ResponseBody
	@RequestMapping("/doAJAXReg")
	public Object doAJAXReg(User user) {
		AJAXResult result = new AJAXResult();
		user.setUserpswd(MD5Util.digest(user.getUserpswd()));
		User dbUser=regService.RegUser(user);
		
		if(dbUser!=null) {
			result.setSuccess(true);
		}
		else {
			result.setSuccess(false);
		}
		return result;
	}
}
