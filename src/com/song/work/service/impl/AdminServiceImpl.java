package com.song.work.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.song.work.dao.mapper.AdminMapper;
import com.song.work.model.Admin;
import com.song.work.model.AdminExample;
import com.song.work.model.AdminExample.Criteria;
import com.song.work.service.IAdminService;

@Service
@Transactional
public class AdminServiceImpl implements IAdminService{
	@Autowired
	private AdminMapper adminMapper;
	/**
	 * 根据名字和密码查询管理员用户
	 * @author slj
	 * */
	public Admin getAdminByNameAndPwd(String adminName,String adminPwd) {
		AdminExample example=new AdminExample();
		Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(adminName)) {
			criteria.andAdminNameEqualTo(adminName);
		}
		if (StringUtils.isNotBlank(adminPwd)) {
			criteria.andAdminPwdEqualTo(adminPwd);
		}
		List<Admin> adminList = adminMapper.selectByExample(example);
		if (adminList != null && !adminList.isEmpty()) {
			return adminList.get(0);
		}
		return null;
	}

}
