package com.beans;

public class signup 
{
	private String full_Name;
	private String mobile;
	private String password;
	private String confirm_Password;
	private String role;
	public String getFull_Name() {
		return full_Name;
	}
	public void setFull_Name(String full_Name) {
		this.full_Name = full_Name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirm_Password() {
		return confirm_Password;
	}
	public void setConfirm_Password(String confirm_Password) {
		this.confirm_Password = confirm_Password;
	}
	
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "signup [full_Name=" + full_Name + ", mobile=" + mobile + ", password=" + password
				+ ", confirm_Password=" + confirm_Password + ", role=" + role + "]";
	}
	
	

}
