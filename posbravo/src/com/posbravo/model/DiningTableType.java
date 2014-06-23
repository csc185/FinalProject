package com.posbravo.model;

// Generated Jun 10, 2014 6:20:56 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * DiningTableType generated by hbm2java
 */
public class DiningTableType implements java.io.Serializable {

	private Integer diningTableTypeId;
	private String type;
	private Set diningTables = new HashSet(0);

	public DiningTableType() {
	}

	public DiningTableType(String type) {
		this.type = type;
	}

	public DiningTableType(String type, Set diningTables) {
		this.type = type;
		this.diningTables = diningTables;
	}

	public Integer getDiningTableTypeId() {
		return this.diningTableTypeId;
	}

	public void setDiningTableTypeId(Integer diningTableTypeId) {
		this.diningTableTypeId = diningTableTypeId;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set getDiningTables() {
		return this.diningTables;
	}

	public void setDiningTables(Set diningTables) {
		this.diningTables = diningTables;
	}

}