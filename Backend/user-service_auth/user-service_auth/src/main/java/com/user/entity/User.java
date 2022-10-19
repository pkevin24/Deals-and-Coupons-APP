package com.user.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "User")
public class User {

	@Transient
	public static final String SEQUENCE_NAME = "user_sequence";

	@Id
	private Integer id;

	@NotEmpty(message = "Name should not be null")
	private String name;

	@NotEmpty(message = "Username should not be null")
	private String userName;

	// @Pattern(regexp="^\\d{10}$",message="invalid mobile number")
	private Long phoneNumber;

	@Email
	private String email;

	// @Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",message="Weak
	// password")
	private String password;

	private Integer points;

	private Set<Role> role;

	private List<Deals> deals = new ArrayList<>();

	private List<Coupons> coupons = new ArrayList<>();

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Integer id, String name, String userName, Long phoneNumber, String email, String password,
			Integer points, Set<Role> role, List<Deals> deals, List<Coupons> coupons) {
		super();
		this.id = id;
		this.name = name;
		this.userName = userName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
		this.points = points;
		this.role = role;
		this.deals = deals;
		this.coupons = coupons;
	}

	public User(Integer id, String name, String userName, Long phoneNumber, String email, String password,
			Integer points) {
		super();
		this.id = id;
		this.name = name;
		this.userName = userName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
		this.points = points;
	}

	public List<Deals> getDeals() {
		return deals;
	}

	public void setDeals(List<Deals> deals) {
		this.deals = deals;
	}

	public List<Coupons> getCoupons() {
		return coupons;
	}

	public void setCoupons(List<Coupons> coupons) {
		this.coupons = coupons;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public Set<Role> getRole() {
		return role;
	}

	public void setRole(Set<Role> role) {
		this.role = role;
	}

}
