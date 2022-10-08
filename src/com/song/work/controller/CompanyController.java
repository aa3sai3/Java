package com.song.work.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.song.work.model.Company;
import com.song.work.model.Message;
import com.song.work.service.ICompanyService;

@Controller
@RequestMapping("/com")
public class CompanyController {

	@Autowired
	public ICompanyService companyService;

	/**
	 * 跳转至企业登录页面
	 * @author xjh
	 * @return
	 */
	@RequestMapping("login")
	public String login() {
		return "/company/login";
	}
	/**
	 * 企业登录
	 * @author xjh
	 * */
	@RequestMapping("accessLogin")
	@ResponseBody
	public Message accessComLogin(HttpServletRequest request, String companyLoginName, String companyPwd,Model model) {
		Company currCom = companyService.getCompanyByNameAndPwd(companyLoginName,companyPwd);//根据登录名向数据库中查询用户
		Message msg=new Message();
		if(currCom==null){
			msg.setStr("fail");
		}else{
			HttpSession session = request.getSession();
			session.setAttribute("currCom", currCom);
			msg.setStr("success");
		}
		return msg;
	}

	/**
	 * 跳转至企业注册页面
	 * @author xjh
	 * @return
	 */
	@RequestMapping("register")
	public String register() {
		return "register/registerCom";
	}
	/**
	 * 企业注册
	 * @author xjh
	 * */
	@RequestMapping("registerCom")
	@ResponseBody
	public Message registCom(Company company) {
		Message msg=new Message();
		int result = companyService.findCompanyByName(company.getCompanyLoginName());//获得公司登录名去数据库中查询
		if(result==1){//公司登录名已经存在
			msg.setStr("公司登录名已经存在");
			return msg;
		}else if(result==0){//公司登录名也没被注册
			int result_ = companyService.findByCompanyName(company.getCompanyName());	//判断公司名称是否唯一
			if(result_==1){
				msg.setStr("公司名已经存在");
				return msg;
			}else{
				//公司名字也没被注册
				companyService.save(company);//插入具体数据
				msg.setStr("success");
				return msg;
			}
		}
		return msg;
	}

	/**
	 * 退出登录
	 * @author xjh
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/exit")
	public String exit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//退出时清空session
		//request.getSession().invalidate();
		request.getSession().removeAttribute("currCom");
		return "/company/login";
	}

	/**
	 * 跳转到添加职位页面
	 *  @author xjh
	 * */
	@RequestMapping("toAddJob")
	public String toAddJob(Model model) {
		return "job/Company_addJob";
	}

	/**
	 * 跳转到查询职位页面
	 *  @author xjh
	 * */
	@RequestMapping("toSelectJob")
	public String toSelectJob(Model model) {
		return "job/Company_showJob";
	}

	// 管理员根据ID进行删除
	@RequestMapping("deleteById")
	public String deleteById(Integer cid) {
		companyService.deleteById(cid);
		// 重定向到列表界面
		return "redirect:showAllCompany";
	}


	// 查询所有企业
	@RequestMapping("showAllCompany")
	public String findAllCompany(Model model) {
		List<Company> companyList = companyService.findAll();
		model.addAttribute("companyList", companyList);
		return "company/Admin_showAllCompany";
	}


	// 跳转到修改页面
	@RequestMapping("editCompany")
	public String editCompany(Integer cid, Model model) {
		// 根据id查询
		Company company = companyService.findCompanyById(cid);
		// 页面回显
		model.addAttribute("company", company);
		return "company/Admin_editCompany";
	}
	//提交企业修改
	@RequestMapping("editCompanySubmit")
	public String editCompanySubmit(Company company) {
		System.out.println(company.getEmpNum());
		companyService.updateCompany(company);
		return "redirect:findAllCompany";
	}



	//company转跳企业修改
	@RequestMapping("editResume")
	public String editResume(Integer cid,Model model) {
		Company company = companyService.findCompanyById(cid);
		model.addAttribute("company", company);
		return "company/Company_editResume";
	}
	//company提交企业修改
	@RequestMapping("editResumeSubmit")
	public String saveResume(Company company) {
		companyService.updateCompany(company);
		return "company/Company_editResume";
	}


	/**
	 * 用户查询一个企业详细信息
	 * */
	@RequestMapping("showOneCompany")
	public String show(Integer cid,String jobName,String jobAddress,Date releaseTime,Double jobSalary,String companyName,Model model){
		Company company = companyService.findCompanyById(cid);
		model.addAttribute("jobName", jobName);
		model.addAttribute("jobAddress",jobAddress);
		model.addAttribute("releaseTime", releaseTime);
		model.addAttribute("jobSalary",jobSalary);
		model.addAttribute("companyName",companyName);
		model.addAttribute("company", company);
		return "job/User_showOneCompany";
	}



	/**
	 * 跳转至企业首页
	 * @author xjh
	 * @return
	 */
	@RequestMapping("index")
	public String index() {
		return "/company/index";
	}
	/**
	 * 跳转到后台top.jsp
	 * @author xjh
	 */
	@RequestMapping("top")
	public String toTop() {
		return "/company/top";
	}
	/**
	 * 跳转到left.jsp
	 * @author xjh
	 */
	@RequestMapping("left")
	public String toLeft() {
		return "/company/left";
	}
	/**
	 * 跳转到body.jsp
	 * @author xjh
	 */
	@RequestMapping("body")
	public String toBody() {
		return "/company/body";
	}

}
