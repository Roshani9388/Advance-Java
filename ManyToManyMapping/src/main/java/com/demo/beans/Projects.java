package com.demo.beans;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Projectmany")
public class Projects {
	
	@Id
	private int pid;
	private String pname;
	private int duration;
	
	@ManyToMany(mappedBy="pset")
	private Set<Employee> eset;

	public Projects() {
		super();
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



	public int getDuration() {
		return duration;
	}



	public void setDuration(int duration) {
		this.duration = duration;
	}



	public Set<Employee> getEset() {
		return eset;
	}



	public void setEset(Set<Employee> eset) {
		this.eset = eset;
	}



	public Projects(int pid, String pname, int duration, Set<Employee> eset) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.duration = duration;
		this.eset = eset;
	}



	@Override
	public String toString() {
		return "Projects [pid=" + pid + ", pname=" + pname + ", duration=" + duration  + "]";
	}
	
	

}
