package com.song.work.service;

import java.util.List;

import com.song.work.model.Favorites;

public interface IFavoriteService {
	/**
	 * 判断是否是第一次收藏
	 * @author slj
	 * */
	public Favorites findFavoriteByAll_(String realname, String jobAddress, String jobName, String companyName);
	/**
	 * 插入新的收藏
	 * @author slj
	 * */
	public int insertFavorite(Favorites favorites_);
	/**
	 * 删除新的收藏
	 * @author slj
	 * */
	public int deleteFavorite(Integer fid);
	/**
	 * 查询职位收藏记录
	 * @author slj
	 * */
	public List<Favorites> findFavoriteByRealName(String realname);
	
}
