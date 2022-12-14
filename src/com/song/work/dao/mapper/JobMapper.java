package com.song.work.dao.mapper;

import com.song.work.model.Job;
import com.song.work.model.JobExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JobMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table job
	 * @mbggenerated  Wed Mar 22 08:54:53 CST 2017
	 */
	int countByExample(JobExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table job
	 * @mbggenerated  Wed Mar 22 08:54:53 CST 2017
	 */
	int deleteByExample(JobExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table job
	 * @mbggenerated  Wed Mar 22 08:54:53 CST 2017
	 */
	int deleteByPrimaryKey(Integer jobId);

	int deleteByName(String jobName);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table job
	 * @mbggenerated  Wed Mar 22 08:54:53 CST 2017
	 */
	int insert(Job record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table job
	 * @mbggenerated  Wed Mar 22 08:54:53 CST 2017
	 */
	int insertSelective(Job record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table job
	 * @mbggenerated  Wed Mar 22 08:54:53 CST 2017
	 */
	List<Job> selectByExample(JobExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table job
	 * @mbggenerated  Wed Mar 22 08:54:53 CST 2017
	 */
	Job selectByPrimaryKey(Integer jobId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table job
	 * @mbggenerated  Wed Mar 22 08:54:53 CST 2017
	 */
	int updateByExampleSelective(@Param("record") Job record, @Param("example") JobExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table job
	 * @mbggenerated  Wed Mar 22 08:54:53 CST 2017
	 */
	int updateByExample(@Param("record") Job record, @Param("example") JobExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table job
	 * @mbggenerated  Wed Mar 22 08:54:53 CST 2017
	 */
	int updateByPrimaryKeySelective(Job record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table job
	 * @mbggenerated  Wed Mar 22 08:54:53 CST 2017
	 */
	int updateByPrimaryKey(Job record);

}