package com.song.work.pojoExt;

import com.song.work.model.Apply;
import com.song.work.model.Company;
import com.song.work.model.Job;

public class JobInfoExt extends Job{
	
	private Company company;
	
	
	private Apply apply;
	
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}



	public Apply getApply() {
		return apply;
	}

	public void setApply(Apply apply) {
		this.apply = apply;
	}
	
}
