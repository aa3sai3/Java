package com.song.work.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {
	/**
	 * 跳转到主页
	 * 
	 * @author slj
	 */
	@RequestMapping("index")
	public String toIndex() {
		return "/main/index";
	}

	/**
	 * 跳转到top.jsp
	 * 
	 * @author slj
	 */
	@RequestMapping("top")
	public String toTop() {
		return "/main/top";
	}

	/**
	 * 跳转到left.jsp
	 * 
	 * @author slj
	 */
	@RequestMapping("left")
	public String toLeft() {
		return "/main/left";
	}
	/**
	 * 跳转到body.jsp
	 * 
	 * @author slj
	 */
	@RequestMapping("body")
	public String toBody() {
		return "/main/body";
	}

	/**
	 * 跳转到用户注册页面
	 * 
	 * @author slj
	 */
	@RequestMapping("registerUser")
	public String toRegisterUser() {
		return "/register/registerUser";
	}

	/**
	 * 跳转到企业注册页面
	 * 
	 * @author slj
	 */
	@RequestMapping("registerCom")
	public String toRegisterCom() {
		return "register/registerCom";
	}
}
