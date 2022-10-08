package com.song.work.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.song.work.dao.mapper.EboardMapper;
import com.song.work.model.Eboard;
import com.song.work.model.EboardExample;
import com.song.work.service.IEboardService;
@Service
@Transactional
public class IEboardServiceImpl implements IEboardService{
	
	@Autowired
	public EboardMapper eboardMapper;
	
	/**
	 * 查询所有新闻和公告
	 * */
	public List<Eboard> findAllJournalism() {
		EboardExample example=new EboardExample();
		List<Eboard> eboardList = eboardMapper.selectByExample(example);
		if (eboardList != null && !eboardList.isEmpty()) {
			return eboardList;
		}
		return null;
	}

}
