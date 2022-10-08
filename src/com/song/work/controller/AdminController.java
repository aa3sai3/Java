package com.song.work.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.song.work.model.Admin;
import com.song.work.model.Message;
import com.song.work.service.IAdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private IAdminService adminService;
	/**
	 * 管理员登录
	 * @author slj
	 * */
	@RequestMapping("login")
	public String AdminLogin(Model model){
		//admin目录下的login页面
		return "/admin/login";
	}
	/**
	 * 进入管理员登录
	 * @author slj
	 * @return
	 * */
	@RequestMapping("accessLogin")
	@ResponseBody
	public Message accessLogin(HttpServletRequest request, String adminName, String adminPwd,Model model) {
		Admin currAdmin = adminService.getAdminByNameAndPwd(adminName,adminPwd);//根据登录名向数据库中查询用户
		Message msg=new Message();
		if(currAdmin==null){
			msg.setStr("fail");
		}else{
			HttpSession session = request.getSession();
			session.setAttribute("currAdmin", currAdmin);
			msg.setStr("success");
		}
		return msg;
	}
	/**
	 * 退出登录
	 * @author slj
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/exit")
	public String exit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//退出时清空session
		//request.getSession().invalidate();
		request.getSession().removeAttribute("currAdmin");
		return "/admin/login";
	}
	/**
	 * 后台首页
	 * @author slj
	 * */
	@RequestMapping("index")
	public String AdminIndex(Model model){
		return "/admin/index";
	}
	/**
	 * 跳转到后台top.jsp
	 * @author slj
	 */
	@RequestMapping("top")
	public String toTop() {
		return "/admin/top";
	}
	/**
	 * 跳转到left.jsp
	 * @author slj
	 */
	@RequestMapping("left")
	public String toLeft() {
		return "/admin/left";
	}
	/**
	 * 跳转到body.jsp
	 * @author slj
	 */
	@RequestMapping("body")
	public String toBody() {
		return "/admin/body";
	}

}
