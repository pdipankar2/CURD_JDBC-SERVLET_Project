package com.jtc.entity;

public class Customer {
	
	private Integer policyId;
	private String holderName;
	private String policyName;
	private String email;
	private long phone;
	private Integer age;
	private String gender;
	private String policyType;
	private Integer premium;
	
	
	
	
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}






	public Customer(Integer policyId, String holderName, String policyName, String email, long phone, Integer age,
			String gender, String policyType, Integer premium) {
		super();
		this.policyId = policyId;
		this.holderName = holderName;
		this.policyName = policyName;
		this.email = email;
		this.phone = phone;
		this.age = age;
		this.gender = gender;
		this.policyType = policyType;
		this.premium = premium;
	}






	public Customer(String holderName, String policyName, String email, long phone, Integer age, String gender,
			String policyType, Integer premium) {
		super();
		this.holderName = holderName;
		this.policyName = policyName;
		this.email = email;
		this.phone = phone;
		this.age = age;
		this.gender = gender;
		this.policyType = policyType;
		this.premium = premium;
	}






	public Integer getPolicyId() {
		return policyId;
	}






	public void setPolicyId(Integer policyId) {
		this.policyId = policyId;
	}






	public String getHolderName() {
		return holderName;
	}






	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}






	public String getPolicyName() {
		return policyName;
	}






	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}






	public String getEmail() {
		return email;
	}






	public void setEmail(String email) {
		this.email = email;
	}






	public long getPhone() {
		return phone;
	}






	public void setPhone(long phone) {
		this.phone = phone;
	}






	public Integer getAge() {
		return age;
	}






	public void setAge(Integer age) {
		this.age = age;
	}






	public String getGender() {
		return gender;
	}






	public void setGender(String gender) {
		this.gender = gender;
	}






	public String getPolicyType() {
		return policyType;
	}






	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}






	public Integer getPremium() {
		return premium;
	}






	public void setPremium(Integer premium) {
		this.premium = premium;
	}






	@Override
	public String toString() {
		return "Customer [policyId=" + policyId + ", holderName=" + holderName + ", policyName=" + policyName
				+ ", email=" + email + ", phone=" + phone + ", age=" + age + ", gender=" + gender + ", policyType="
				+ policyType + ", premium=" + premium + "]";
	}






}
