package com.song.work.service;

import java.util.List;

import com.song.work.model.Job;
import com.song.work.pojoExt.JobInfoExt;

public interface IJobService {
	/**
	 * 查看所有工作职位
	 * 
	 * @author slj
	 * @return
	 */
	public List<JobInfoExt> findAll(String jobName,String jobAddress,String companyName);
	/**
	 * 查询指定cid下的jobName,目的是判断新增工作是否重复
	 * */
	public Job findByCidAndJobName(Integer cid,String jobName);
	/**
	 * 新增职位
	 * */
	public int insertJob(Job job);

	public int deleteJob(String jobName);

	public int updateJob(Job job);

}
