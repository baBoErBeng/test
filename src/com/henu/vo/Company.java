package com.henu.vo;

public class Company {
	private String companyName,legalperson,registeredfund,registeredtime,phone,email,address,qita;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getLegalperson() {
		return legalperson;
	}

	public void setLegalperson(String legalperson) {
		this.legalperson = legalperson;
	}

	public String getRegisteredfund() {
		return registeredfund;
	}

	public void setRegisteredfund(String registeredfund) {
		this.registeredfund = registeredfund;
	}

	public String getRegisteredtime() {
		return registeredtime;
	}

	public void setRegisteredtime(String registeredtime) {
		this.registeredtime = registeredtime;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getQita() {
		return qita;
	}

	public void setQita(String qita) {
		this.qita = qita;
	}

	@Override
	public String toString() {
		return "Company [companyName=" + companyName + ", legalperson=" + legalperson + ", registeredfund="
				+ registeredfund + ", registeredtime=" + registeredtime + ", phone=" + phone + ", email=" + email
				+ ", address=" + address + ", qita=" + qita + "]";
	}
	
}
