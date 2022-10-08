package com.song.work.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.song.work.model.Company;
import com.song.work.model.Job;
import com.song.work.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.song.work.pojoExt.JobInfoExt;
import com.song.work.service.IJobService;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/job")
public class JobController {
	@Autowired
	private IJobService iJobService;

	/**
	 * 添加职位
	 * @author slj
	 * */
	@RequestMapping("addJob")
	@ResponseBody
	public Message addJob(HttpServletRequest request,int cid,String jobName,String jobAddress,double jobSalary,
						   String releaseTime) throws ParseException {
//	public Message addPost(HttpServletRequest request,
//						   @RequestParam("cid") String cid,
//						   @RequestParam("jobAddress") String jobAddress,
//						   @RequestParam("jobName") String jobName,
//						   @RequestParam("jobSalary") String jobSalary,
//						   @RequestParam("releaseTime") String releaseTime) throws ParseException {
		Message msg=new Message();
		Company company = (Company) request.getSession().getAttribute("currCom");
		if(company!=null){
			Job job= iJobService.findByCidAndJobName(cid,jobName);
			if(job==null){
				//将数据封装到新的job对象，插入数据库
				Job job_=new Job();
				job_.setCid(String.valueOf(cid));
				job_.setJobAddress(jobAddress);
				job_.setJobName(jobName);
				job_.setJobSalary(jobSalary);
				//job_.setJobSalary(Double.parseDouble(jobSalary));
				job_.setReleaseTime(new SimpleDateFormat("yyyy-MM-dd").parse(releaseTime));
				int result = iJobService.insertJob(job_);
				if(result==1){
					msg.setStr("success");
					return msg;
				}else{
					msg.setStr("插入职位失败");
					return msg;
				}
			}else{
				//不可以
				msg.setStr("新增的职位名称不可以重复");
				return msg;
			}
		}else{
			msg.setStr("fail");
			return msg;
		}
	}
	/**
	 * 查询出所有的职位
	 * @author slj
	 * @param jobInfoExt 职位详细信息对象
	 * @return
	 * */
	@RequestMapping("findAllJob")
	public String findAllJob(String jobName,String jobAddress,String companyName,Model model){
		List<JobInfoExt> jobInfoList = iJobService.findAll(jobName,jobAddress,companyName);
		model.addAttribute("jobInfoList", jobInfoList);
		return "job/User_showAllJob";
	}

	@RequestMapping("showCompanyJob")
	public String findCompanyJob(String jobName,String jobAddress,String companyName,Model model){
		List<JobInfoExt> CompanyJobInfoList = iJobService.findAll(jobName,jobAddress,companyName);
		model.addAttribute("CompanyJobInfoList", CompanyJobInfoList);
		return "job/Company_showJob";
	}

	// 删除Job
	@RequestMapping("deleteJob")
	public String deleteCompany(String jobName, Model model) {
		// 根据Name
		iJobService.deleteJob(jobName);
		return "redirect:showCompanyJob";
	}

	// 跳转到修改Job页面
	@RequestMapping("editJob")
	public String editJob(Integer cid,String jobName, Model model) {
		// 根据id查询
		Job job = iJobService.findByCidAndJobName(cid,jobName);
		// 页面回显
		model.addAttribute("job", job);
		model.addAttribute("TempJobName", job.getJobName());
		return "job/Company_editJob";
	}

	//提交Job修改
	@RequestMapping("editJobSubmit")
	@ResponseBody
	public Message editJobSubmit(HttpServletRequest request, int jobId,int cid,String TempJobName,String jobName,String jobAddress,double jobSalary,
								 String releaseTime) throws ParseException {
		Message msg=new Message();
		Company company = (Company) request.getSession().getAttribute("currCom");
		if(company!=null){
			Job job_= iJobService.findByCidAndJobName(cid,jobName);
			System.out.println(TempJobName);
			if(job_==null||TempJobName.equals(jobName)){
				//将数据封装到新的job对象，插入数据库
				Job job=new Job();
				job.setJobId(jobId);
				job.setCid(String.valueOf(cid));
				job.setJobAddress(jobAddress);
				job.setJobName(jobName);
				job.setJobSalary(jobSalary);
				job.setReleaseTime(new SimpleDateFormat("yyyy-MM-dd").parse(releaseTime));
				int result = iJobService.updateJob(job);
				if(result==1){
					msg.setStr("success");
				} else{
					msg.setStr("插入职位失败");
				}
			}
			else{
				//不可以
				msg.setStr("新增的职位名称不可以重复");
			}
		}else{
			msg.setStr("fail");
		}
		return msg;
	}

	//提交企业修改
//	@RequestMapping("editJobSubmit")
//	public String editJobSubmit(HttpServletRequest request,Job job)  {
//		Message msg=new Message();
//		Company company = (Company) request.getSession().getAttribute("currCom");
//		if(company!=null){
//			System.out.println(job.getCid());
//			Job job_= iJobService.findByCidAndJobName(Integer.parseInt(job.getCid()),job.getJobName());
//			if(job_==null){
//				//将数据封装到新的job对象，插入数据库
//				int result = iJobService.updateJob(job);
//				if(result==1){
//					msg.setStr("success");
//				}else{
//					msg.setStr("插入职位失败");
//				}
//			}else{
//				//不可以
//				msg.setStr("新增的职位名称不可以重复");
//			}
//		}else{
//			msg.setStr("fail");
//		}
//		return "redirect:findCompanyJob";
//	}

}
