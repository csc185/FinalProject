package com.posbravo.model;

// Generated Jun 10, 2014 6:20:56 PM by Hibernate Tools 3.4.0.CR1

/**
 * UserPromotion generated by hbm2java
 */
public class UserPromotion implements java.io.Serializable {

	private Integer userPromotionId;
	private PromotionGroup promotionGroup;
	private User user;
	private String promotionCode;

	public UserPromotion() {
	}

	public UserPromotion(PromotionGroup promotionGroup, User user,
			String promotionCode) {
		this.promotionGroup = promotionGroup;
		this.user = user;
		this.promotionCode = promotionCode;
	}

	public Integer getUserPromotionId() {
		return this.userPromotionId;
	}

	public void setUserPromotionId(Integer userPromotionId) {
		this.userPromotionId = userPromotionId;
	}

	public PromotionGroup getPromotionGroup() {
		return this.promotionGroup;
	}

	public void setPromotionGroup(PromotionGroup promotionGroup) {
		this.promotionGroup = promotionGroup;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPromotionCode() {
		return this.promotionCode;
	}

	public void setPromotionCode(String promotionCode) {
		this.promotionCode = promotionCode;
	}

}
