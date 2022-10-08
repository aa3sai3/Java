package com.song.work.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.song.work.model.Message;
import com.song.work.model.User;
import com.song.work.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	public IUserService userService;
	/**
	 * User查看个人简历
	 * @author xjh
	 */
	@RequestMapping("showResume")
	public String showResume(Model model,HttpServletRequest request) {
		//获得session中存的当前对象
		User currUser = (User) request.getSession().getAttribute("currUser");
		String realname=currUser.getRealname();
		//根据真实姓名查询用户
		User user = userService.findUserByRealname(realname);
		model.addAttribute("user", user);
		return "user/User_showResume";
	}
	//转跳修改简历
	@RequestMapping("editResume")
	public String editResume(Model model,Integer uid) {
		User user = userService.findById(uid);
		if(user!=null){
			model.addAttribute("user", user);
		}
		return "user/User_editResume";
	}
	//保存简历
	@RequestMapping("saveResume")
	public String saveResume(Model model,User user) {
		userService.saveResume(user);
		model.addAttribute("user", user);
		return "forward:showResume";//转发到预览简历
	}



	/**
	 * Admin查询所有用户
	 * @author xjh
	 */
	@RequestMapping("showAllUser")
	public String findAllUser(Model model) {
		List<User> userList = userService.findAll();
		model.addAttribute("userList", userList);
		return "user/Admin_showAllUser";
	}
	//跳转到修改页面
	@RequestMapping("editUser")
	public String editUser(Integer uid, Model model) {
		// 根据id查询
		User user = userService.findById(uid);
		// 页面回显
		model.addAttribute("user", user);
		return "user/Admin_editUser";
	}
	//保存修改
	@RequestMapping("editUserSubmit")
	public String editUserSubmit(Integer uid, User user) {
		userService.updateUser(uid, user);
		return "redirect:showAllUser";
	}
	// Admin根据ID进行删除
	@RequestMapping("deleteUser")
	public String deleteById(Integer uid) {
		userService.deleteById(uid);
		// 重定向到用户列表界面
		return "redirect:showAllUser";
	}


	/**
	 * Company根据用户真实名字查询其详细
	 * @author xjh
	 */
	@RequestMapping("findUserByRealname")
	public String showUserByRealname(String realname,Model model) {
		User user = userService.findUserByRealname(realname);
		if(user!=null){
			model.addAttribute("user", user);
			return "user/Company_showOneUser";
		}else{
			throw new RuntimeException("对不起，没有该用户的具体信息");
		}
	}

	/**
	 * 用户注册
	 * @author xjh
	 * @return
	 */
	//跳转到注册页面
	@RequestMapping("register")
	public String toRegister(Model model) {
		return "/register/registerUser";
	}
	@RequestMapping("registerUser")
	@ResponseBody
	public Message registUser(User user) {
		Message msg=new Message();
		//根据登录名来判断
		int result = userService.findByUserLoginName(user.getLoginName());
		if(result==1){//登录名已经有了
			msg.setStr("用户登录名已经存在");
			return msg;
		}else{
			userService.save(user);//插入具体数据
			msg.setStr("success");
			return msg;
		}
	}
	/**
	 * 用户登录
	 * @author xjh
	 * @return
	 */
	@RequestMapping("login")
	public String login(Model model) {
		return "user/login";
	}
	/**
	 * 用户登录
	 * @author xjh
	 * */
	@RequestMapping("/accessLogin")
	@ResponseBody
	public Message accessLogin(HttpServletRequest request, String loginName, String loginPwd,Model model) {
		User currUser = userService.getUserByNameAndPwd(loginName,loginPwd);//根据登录名向数据库中查询用户
		Message msg=new Message();
		if(currUser==null){
			msg.setStr("fail");
			return msg;
		}else{
			HttpSession session = request.getSession();
			session.setAttribute("currUser", currUser);
			msg.setStr("success");
			return msg;
		}
	}

	/**
	 * 退出登录
	 * @author xjh
	 */
	@RequestMapping(value = "/exit")
	public String exit(HttpServletRequest request) throws Exception {
		//退出时清空session
		//request.getSession().invalidate();
		request.getSession().removeAttribute("currUser");
		return "/user/login";
	}
}
