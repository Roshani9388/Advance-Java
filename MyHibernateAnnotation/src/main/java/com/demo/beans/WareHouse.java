package com.demo.beans;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Embeddable
public class WareHouse {
	

	private int wid;
	private String wname;
	private String wloc;
	
	public WareHouse() {
		super();
	}

	public WareHouse(int wid, String wname, String wloc) {
		super();
		this.wid = wid;
		this.wname = wname;
		this.wloc = wloc;
	}

	public int getWid() {
		return wid;
	}

	public void setWid(int wid) {
		this.wid = wid;
	}

	public String getWname() {
		return wname;
	}

	public void setWname(String wname) {
		this.wname = wname;
	}

	public String getWloc() {
		return wloc;
	}

	public void setWloc(String wloc) {
		this.wloc = wloc;
	}

	@Override
	public String toString() {
		return "WareHouse [wid=" + wid + ", wname=" + wname + ", wloc=" + wloc + "]";
	}
	
	

}
