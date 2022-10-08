package com.song.work.dao.mapper;

import java.util.List;
import java.util.Map;

import com.song.work.pojoExt.JobInfoExt;

public interface JobInfoExtMapper {
	/*
	 * 查看所有工作职位,外加模糊查询.
	 * @author slj
	 * @return 
	 * */
	public List<JobInfoExt> findAll(Map<String,Object> map);
}
