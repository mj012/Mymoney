package com.onward.example.myMoneyPlatform.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Rebalancing {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long rebalancingId;
	private int rebalancedValue;
	private int rebalancedPercentage;
	private int rebalancedDate;
	private long portfolioId;
	private int portfolioValue;
	private int allocationPercentage;
/*
	@OneToMany
	@JoinColumn(name = "portfolioId", referencedColumnName = "portfolioId")
	private long portfolioId;
	@OneToMany
	@JoinColumn(name = "portfolioValue", referencedColumnName = "portfolioValue")
	private int portfolioValue;
	@OneToMany
	@JoinColumn(name = "allocationPercentage", referencedColumnName = "allocationPercentage")
	private int allocationPercentage;
*/
	public Rebalancing(long rebalancingId, int rebalancedValue, int rebalancedPercentage, int rebalancedDate,
			long portfolioId, int portfolioValue, int allocationPercentage) {
		super();
		this.rebalancingId = rebalancingId;
		this.rebalancedValue = rebalancedValue;
		this.rebalancedPercentage = rebalancedPercentage;
		this.rebalancedDate = rebalancedDate;
		this.portfolioId = portfolioId;
		this.portfolioValue = portfolioValue;
		this.allocationPercentage = allocationPercentage;
	}

	public Rebalancing() {

	}

	public long getRebalancingId() {
		return rebalancingId;
	}

	public void setRebalancingId(long rebalancingId) {
		this.rebalancingId = rebalancingId;
	}

	public int getRebalancedValue() {
		return rebalancedValue;
	}

	public void setRebalancedValue(int rebalancedValue) {
		this.rebalancedValue = rebalancedValue;
	}

	public int getRebalancedPercentage() {
		return rebalancedPercentage;
	}

	public void setRebalancedPercentage(Object object) {
		this.rebalancedPercentage = (int) object;
	}

	public int getRebalancedDate() {
		return rebalancedDate;
	}

	public void setRebalancedDate(int rebalancedDate) {
		this.rebalancedDate = rebalancedDate;
	}

	public long getPortfolioId() {
		return portfolioId;
	}

	public void setPortfolioId(long portfolioId) {
		this.portfolioId = portfolioId;
	}

	public int getPortfolioValue() {
		return portfolioValue;
	}

	public void setPortfolioValue(int portfolioValue) {
		this.portfolioValue = portfolioValue;
	}

	public int getAllocationPercentage() {
		return allocationPercentage;
	}

	public void setAllocationPercentage(int allocationPercentage) {
		this.allocationPercentage = allocationPercentage;
	}


}
