package com.demo.beans;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ProductNew")
public class Product {
	@Id
	private int pid;
	private String pname;
	
	@Embedded
	private WareHouse wh;
	
	public Product() {
		super();
	}

	public Product(int pid, String pname, WareHouse wh) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.wh = wh;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public WareHouse getWh() {
		return wh;
	}

	public void setWh(WareHouse wh) {
		this.wh = wh;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + "]";
	}
	
	

}
