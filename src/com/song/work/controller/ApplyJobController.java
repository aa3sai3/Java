package com.song.work.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.song.work.model.Apply;
import com.song.work.model.Company;
import com.song.work.model.Message;
import com.song.work.service.IApplyJobService;

import org.springframework.ui.Model;
/**
 * 求职申请控制
 * @author slj
 * */
@Controller
@RequestMapping("/apply")
public class ApplyJobController {
	@Autowired
	private IApplyJobService applyJobService;
	/**
	 * 企业查询所有的申请者
	 * @author slj
	 * */
	@RequestMapping("/showApply")
	public String findAllApply(String companyName,Model model,HttpServletRequest request){
		Company company = (Company) request.getSession().getAttribute("currCom");
		if(company!=null){
			List<Apply> applyList = applyJobService.findAllByCompanyName(companyName);
			model.addAttribute("applyList", applyList);
			return "apply/Company_showApply";
		}else{
			return "company/reLogin";
		}
	}
	/**
	 * 投递简历并判断是否是第一次投递
	 * @author slj
	 * */
	@RequestMapping("/delivery")
	@ResponseBody
	public Message accept(String jobName,String jobAddress,Date releaseTime,
			String realname,Double jobSalary,String companyName){
		Message  message=new Message();
		if(realname==null ||realname.isEmpty()){//判断用户是否登录
			message.setStr("您还没有登录！");
			return message;
		}
		Apply apply = applyJobService.findApplyByAll(realname,jobAddress,jobName);
		if(apply==null){
			//插入职位具体数据
			Apply apply_=new Apply();
			apply_.setJobAddress(jobAddress);
			apply_.setJobName(jobName);
			apply_.setJobSalary(jobSalary);
			apply_.setRealname(realname);
			apply_.setReleaseTime(releaseTime);
			apply_.setCompanyName(companyName);
			int result=applyJobService.insertApply(apply_);
			System.out.println(jobName);
			if(result==1){
				message.setStr("投递成功！");
				return message;
			}else{
				message.setStr("不好意思，投递失败！");
				return message;
			}
		}else{
			//第二次申请
			message.setStr("请不要重复投递！");
			return message;
		}
	}

	/**
	 * 根据ID删除职位投递记录
	 * @author slj
	 * */
	@RequestMapping("deleteById")
	public String deleteById(Integer sid) {

		applyJobService.deleteById(sid);
		// 重定向到投递记录界面
		return "apply/Company_showApply";
	}

	/**
	 * 职位投递记录
	 * @author slj
	 * */
	@RequestMapping("/applyRecord")
	public String findApplyByRealName(String realname,Model model){
		List<Apply> applyList_ = applyJobService.findApplyRecordByRealname(realname);
		model.addAttribute("applyList_", applyList_);
		return "apply/User_showApplyRecord";
	}

}
