package com.demo.beans;

import javax.persistence.Embeddable;

@Embeddable
public class Warehouse {
	private int wid;
	private String wname;
	private String loc;
	
	public Warehouse() {
		super();
	}

	public Warehouse(int wid, String wname, String loc) {
		super();
		this.wid = wid;
		this.wname = wname;
		this.loc = loc;
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

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	@Override
	public String toString() {
		return "Warehouse [wid=" + wid + ", wname=" + wname + ", loc=" + loc + "]";
	}
	
	

}
