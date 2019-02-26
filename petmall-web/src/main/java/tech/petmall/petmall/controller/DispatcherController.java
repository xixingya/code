package tech.petmall.petmall.controller;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.filefilter.RegexFileFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 调度控制器
 * @author 18801
 *
 */
@Controller
public class DispatcherController {

	@RequestMapping(value= {"/index", "", "/", "/index/"})
	public String index() {
		return "index";
	}
	@RequestMapping("/reg")
	public String reg() {
		return "reg";
	}
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/logout")
	public String logout( HttpSession session ) {
		
		//session.removeAttribute("loginUser");
		session.invalidate();
		return "redirect:/login";
	}
	
	@RequestMapping("/member")
	public String member() {
		return "member";
	}
	
	@RequestMapping("/main")
	public String main() {
		return "main";
	}
}
