package com.song.work.service;

import java.util.List;

import com.song.work.model.User;

public interface IUserService {
	/**
	 * 用户注册
	 * 
	 * @author slj
	 */
	public void save(User user);

	// 查询所有用户
	public List<User> findAll();

	// 根据id查询用户
	public User findById(Integer uid);

	// 根据id删除用户
	public void deleteById(Integer uid);

	// 修改
	public void updateUser(Integer uid, User user);
	//用户登录
	public User getUserByNameAndPwd(String loginName, String loginPwd);
	/**
	 * 根据登录名查找用户
	 * */
	public int findByUserLoginName(String loginName);
	/**
	 * 根据真实姓名查找用户
	 * @author slj
	 * */
	public User findUserByRealname(String realname);
	
	public void saveResume(User user);
}
