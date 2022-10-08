package com.song.work.service;

import java.util.List;

import com.song.work.model.Company;

public interface ICompanyService {
	// 查询所有
	public List<Company> findAll();

	// 根据id查询
	public Company findCompanyById(Integer cid);

	// 根据id删除
	public void deleteById(Integer cid);

	public Company login(Company company);

	// 修改
	public void updateCompany(Company company);

	/**
	 * 校验登录名是否存在
	 * 
	 * @author slj
	 * @param companyLoginName  公司登录名字
	 * @return
	 */
	public int findCompanyByName(String companyLoginName);

	/**
	 * 公司注册
	 * @author slj
	 */
	public void save(Company company);
	/**
	 * 公司注册 
	 * @author slj
	 * @return
	 */
	public Company getCompanyByNameAndPwd(String companyLoginName, String companyPwd);
	/**
	 * 判定公司名称是否唯一
	 * @author slj
	 * @return
	 */
	public int findByCompanyName(String companyName);
}
