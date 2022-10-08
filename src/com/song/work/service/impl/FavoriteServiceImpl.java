package com.song.work.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.song.work.dao.mapper.FavoritesMapper;
import com.song.work.model.Favorites;
import com.song.work.model.FavoritesExample;
import com.song.work.model.FavoritesExample.Criteria;
import com.song.work.service.IFavoriteService;
@Service
@Transactional
public class FavoriteServiceImpl implements IFavoriteService{
	@Autowired
	public FavoritesMapper favoritesMapper;
	/**
	 * 判断是否是第一次收藏
	 * @author slj
	 * */
	public Favorites findFavoriteByAll_(String realname, String jobAddress, String jobName, String companyName) {
		FavoritesExample example=new FavoritesExample();
		Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(realname)) {
			criteria.andRealnameEqualTo(realname);
		}
		if (StringUtils.isNotBlank(jobAddress)) {
			criteria.andJobAddressEqualTo(jobAddress);
		}
		if (StringUtils.isNotBlank(jobName)) {
			criteria.andJobNameEqualTo(jobName);
		}
		if (StringUtils.isNotBlank(companyName)) {
			criteria.andCompanyNameEqualTo(companyName);
		}
		List<Favorites> favoritesList = favoritesMapper.selectByExample(example);
		if (favoritesList != null && !favoritesList.isEmpty()) {
			return favoritesList.get(0);
		}
		return null;
	}
	/**
	 * 插入收藏
	 * @author slj
	 * */
	public int insertFavorite(Favorites favorites_) {
		int result = favoritesMapper.insert(favorites_);
		return result;
	}
	/**
	 * 删除收藏
	 * @author slj
	 * */
	public int deleteFavorite(Integer fid) {
		int result = favoritesMapper.deleteByPrimaryKey(fid);
		return result;
	}
	/**
	 * 查询职位收藏记录
	 * @author slj
	 * */
	public List<Favorites> findFavoriteByRealName(String realname) {
		FavoritesExample example=new FavoritesExample();
		Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(realname)) {
			criteria.andRealnameEqualTo(realname);
		}
		//根据真实名字查询
		List<Favorites> favoritesList = favoritesMapper.selectByExample(example);
		if (favoritesList != null && !favoritesList.isEmpty()) {
			return favoritesList;
		}
		return null;
	}

}
