package tech.petmall.petmall.manager.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tech.petmall.petmall.bean.AJAXResult;
import tech.petmall.petmall.bean.User;
import tech.petmall.petmall.common.util.MD5Util;
import tech.petmall.petmall.manager.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	/**
	 * AJAX请求方法必须访问对象，不需要跳转页面，
	 * 必须增加注解：@ResponseBody
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/doAJAXLogin")
	public Object doAJAXLogin( User user, HttpSession session ) {
		
		// Object ==> json ==> string
		// User ==> {"属性名":属性值,"属性名":属性值}
		// List ==> [{"属性名":属性值,"属性名":属性值}, {"属性名":属性值,"属性名":属性值}]
		// Map  ==> {"Key":value}
		AJAXResult result = new AJAXResult();
		user.setUserpswd(MD5Util.digest(user.getUserpswd()));
		User dbUser = userService.queryLoginUser(user);
		if ( dbUser != null ) {
			
			// 存储登陆用户信息
			session.setAttribute("loginUser", dbUser);
			result.setSuccess(true);
		} else {
			result.setSuccess(false);
		}
		
		return result;
	}
	
	/**
	 * 如果web程序出现乱码：
	 * 1）增加字符编码过滤器（POST）
	 * 2）修改服务器的配置，增加对URI字符的解析(GET)
	 * @param user
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/dologin")
	public String dologin( User user, Model model ) throws Exception {
		
		//String s = user.getLoginacct();
		//System.out.println("s = " + s);
		
		// 1) 将乱码字符串按照错误的编码方式恢复成原始字节码序列
		//byte[] bs = s.getBytes("ISO8859-1");
		// 2) 将原始的字节码序列按照正确的编码变成正确的文字
		//s = new String(bs, "UTF-8");
		//System.out.println("s = " + s);
		
		// 获取表单提交的数据
		// 1) req.getParameter("loginacct");
		// 2) 参数列表中直接增加同名的参数
		// 3) 将参数封装为实体类对象(表单数据名称=实体类中属性名称)
		
		// 查询用户信息（账号，密码）
		User dbUser = userService.queryLoginUser(user);
		// 返回查询结果
		// 对返回结果进行判断
		if ( dbUser != null ) {
			// 如果用户存在的场合，跳转到主页面
			return "main";
		} else {
			// 如果用户不存在，那么跳转回登陆页面，并提示错误信息
			String errorMsg = "登陆账号或密码不正确，请重新输入";
			model.addAttribute("errorMsg", errorMsg);
			return "redirect:/login";
		}
		
		
	}
}
