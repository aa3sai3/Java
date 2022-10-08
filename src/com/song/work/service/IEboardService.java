package com.song.work.service;

import java.util.List;

import com.song.work.model.Eboard;

public interface IEboardService {
	/**
	 *查询所有新闻和公告
	 * */
	public List<Eboard> findAllJournalism();
	
}	
