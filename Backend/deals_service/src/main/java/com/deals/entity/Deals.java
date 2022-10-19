package com.deals.entity;

import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@Document(collection = "Deals")
public class Deals {
	
	@Transient
	public static final String SEQUENCE_NAME = "deals_sequence";
	@Id
	private Integer dealId;
	
	@NotEmpty(message="dealname should not be empty")
	private String dealName;
	
//	@NotEmpty(message="price should not be empty")
	private Integer price;
	
//	@NotEmpty(message="Cashback should not be empty")
	private Integer cashback;
	
	@NotEmpty(message="Url should not be empty")
	private String url;
	@NotEmpty(message="imageurl should not be empty")
	private String imageUrl;
	
	public Deals(Integer dealId, String dealName, Integer price, int cashback, String url,String imageUrl) {
		super();
		this.dealId = dealId;
		this.dealName = dealName;
		this.price = price;
		this.cashback = cashback;
		this.url = url;
		this.imageUrl=imageUrl;
	}
	public Deals() {
		super();
	}
	public Integer getDealId() {
		return dealId;
	}
	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}
	public String getDealName() {
		return dealName;
	}
	public void setDealName(String dealName) {
		this.dealName = dealName;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public int getCashback() {
		return cashback;
	}
	public void setCashback(int cashback) {
		this.cashback = cashback;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
}