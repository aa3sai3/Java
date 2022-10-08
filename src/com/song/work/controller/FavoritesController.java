package com.song.work.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.song.work.model.Favorites;
import com.song.work.model.Message;
import com.song.work.service.IFavoriteService;

@Controller
@RequestMapping("/favorite")
public class FavoritesController {
	/**
	 * 职位收藏
	 * @author slj
	 * */
	@Autowired
	private IFavoriteService favoriteService;
	
	@RequestMapping("favorite")
	@ResponseBody
	public Message favorite(String jobName,String jobAddress,Date saveTime,
			String realname,Double jobSalary,String companyName) {
		Message  message=new Message();
		if(realname==null ||realname.isEmpty()){//判断用户是否登录
			message.setStr("您还没有登录！");
			return message;
		}
		Favorites favorites = favoriteService.findFavoriteByAll_(realname,jobAddress,jobName,companyName);
		if(favorites==null){
			//插入职位具体数据
			Favorites favorites_=new Favorites();
			favorites_.setJobAddress(jobAddress);
			favorites_.setJobName(jobName);
			favorites_.setJobSalary(jobSalary);
			favorites_.setRealname(realname);
			favorites_.setReleaseTime(saveTime);//收藏时的时间
			favorites_.setCompanyName(companyName);
			int result=favoriteService.insertFavorite(favorites_);
			if(result==1){
				message.setStr("收藏成功！");
				return message;
			}else{
				message.setStr("不好意思，收藏失败！");
				return message;
			}
		}else{
			//第二次申请
			message.setStr("请不要重复收藏！");
			return message;
		}
	}
	/**
	 * 职位收藏记录
	 * @author xjh
	 * */
	@RequestMapping("/favoriteRecord")
	public String findFavoriteByRealName(String realname,Model model){
		List<Favorites> favoritesList= favoriteService.findFavoriteByRealName(realname);
		model.addAttribute("favoritesList", favoritesList);
		return "favorite/User_showFavoriteListRecord";
	}
	/**
	 * 删除职位收藏记录
	 * @author xjh
	 * */
	@RequestMapping("/deleteFavoriteRecord")
	public String deleteRecord(Integer fid){
		favoriteService.deleteFavorite(fid);
		return "redirect:favoriteRecord";
	}
}
