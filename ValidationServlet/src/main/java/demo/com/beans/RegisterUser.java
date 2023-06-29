package demo.com.beans;

import java.time.LocalDate;
import java.util.Arrays;

public class RegisterUser {
	private int uid;
	private String name;
	private String address;
	private String username;
	private String Skills[];
	private LocalDate dt;
	private String gender;
	private String city;
	public RegisterUser() {
		super();
	}
	public RegisterUser(int uid, String name, String address, String username, String[] skills,
			LocalDate dt, String gender, String city) {
		super();
		this.uid = uid;
		this.name = name;
		this.address = address;
		this.username = username;
		
		Skills = skills;
		this.dt = dt;
		this.gender = gender;
		this.city = city;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String[] getSkills() {
		return Skills;
	}
	public void setSkills(String[] skills) {
		Skills = skills;
	}
	public LocalDate getDt() {
		return dt;
	}
	public void setDt(LocalDate dt) {
		this.dt = dt;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "RegisterUser [uid=" + uid + ", name=" + name + ", address=" + address + ", username=" + username
				+ ", Skills=" + Arrays.toString(Skills) + ", dt=" + dt + ", gender=" + gender
				+ ", city=" + city + "]";
	}
	
	
	

}
