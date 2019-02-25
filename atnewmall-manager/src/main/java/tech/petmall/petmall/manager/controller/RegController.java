package tech.petmall.petmall.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tech.petmall.petmall.bean.AJAXResult;
import tech.petmall.petmall.bean.User;
import tech.petmall.petmall.common.util.MD5Util;
import tech.petmall.petmall.manager.service.RegService;;

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
