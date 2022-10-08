package com.song.work.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.song.work.model.Eboard;
import com.song.work.service.IEboardService;

@Controller
@RequestMapping("/eBoard")
public class EBoardController {//系统公告以及职位新闻
	
	@Autowired
	public IEboardService eboardService;
	
	/**
	 * 查看所有新闻和公告
	 * @author slj
	 * */
	@RequestMapping("/showNews")
	public String showJournalism(Model model){
		List<Eboard> eboardList = eboardService.findAllJournalism();
		model.addAttribute("eboardList", eboardList);
		return "/main/listEboard";
	}
}
