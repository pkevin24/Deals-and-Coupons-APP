package com.coupons.entity;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@Document(collection="coupons")
public class Coupons {
	@Id
	private Integer couponId;
	
	@NotEmpty(message="Name should not be null")
	private String couponName;
	
	//@NotEmpty(message="code should not be empty")
	private int couponCode;
	
	@NotEmpty(message="code should not be empty")
	private String couponType;
	
	//@NotEmpty(message="code should not be empty")
	private int couponCounts;
	
	@NotEmpty(message="code should not be empty")
	private String linkUrl;
	
	@NotEmpty(message="code should not be empty")
	private String imgUrl;
	
	
	public Coupons(Integer couponId, String couponName, int couponCode, String couponType, int couponCounts,
			String linkUrl, String imgUrl) {
		super();
		this.couponId = couponId;
		this.couponName = couponName;
		this.couponCode = couponCode;
		this.couponType = couponType;
		this.couponCounts = couponCounts;
		this.linkUrl = linkUrl;
		this.imgUrl = imgUrl;
	}
	
	public Integer getCouponId() {
		return couponId;
	}

	public String getCouponName() {
		return couponName;
	}

	public int getCouponCode() {
		return couponCode;
	}

	public String getCouponType() {
		return couponType;
	}

	public int getCouponCounts() {
		return couponCounts;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public String getImgUrl() {
		return imgUrl;
	}


	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}

	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}

	public void setCouponCode(int couponCode) {
		this.couponCode = couponCode;
	}

	public void setCouponType(String couponType) {
		this.couponType = couponType;
	}

	public void setCouponCounts(int couponCounts) {
		this.couponCounts = couponCounts;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	

	public Coupons() {
		super();
	}
 
	@Transient
	public static final String SEQUENCE_NAME = "coupons_sequence";
}
