package com.song.work.service;

import java.util.List;

import com.song.work.model.Apply;

public interface IApplyJobService {
	/**
	 * 根据真实名字查询职位，保障用户只可以申请一次
	 * @author slj
	 * */
	public Apply findApplyByAll(String realname,String jobAdress,String jobName);
	/**
	 * 插入具体职位值
	 * @author slj
	 * */
	public int insertApply(Apply newApply);
	/**
	 * 根据ID删除职位投递记录
	 * @author slj
	 * */
	public void deleteById(Integer sid);
	/**
	 * 根据真实姓名查询所有的申请记录
	 * @author slj
	 * */
	public List<Apply> findApplyRecordByRealname(String realname);
	/**
	 * 根据企业名查询所有的申请者
	 * @author slj
	 * @return
	 * */
	public List<Apply> findAllByCompanyName(String companyName);
}
