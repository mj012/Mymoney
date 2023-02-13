package com.onward.example.myMoneyPlatform.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ManyToAny;

@Entity
public class Portfolio {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long portfolioID;
	private long portfolioValue;
	private int allocationPercentage;

	@Column(name = "investorID")
	Long investorId;
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "investorId")
//	private Investor investor;
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "PortfolioId", referencedColumnName = "portfolioID")
//	private List<Investor> investor;

	public Portfolio(long portfolioID, long portfolioValue, int allocationPercentage, Investor investor,
			long investorId) {
		super();
		this.portfolioID = portfolioID;
		this.portfolioValue = portfolioValue;
		this.allocationPercentage = allocationPercentage;
		this.investorId = investorId;
	}

	public Portfolio() {

	}

	public long getPortfolioID() {
		return portfolioID;
	}

	public void setPortfolioID(long portfolioID) {
		this.portfolioID = portfolioID;
	}

	public long getPortfolioValue() {
		return portfolioValue;
	}

	public void setPortfolioValue(long portfolioValue) {
		this.portfolioValue = portfolioValue;
	}

	public int getAllocationPercentage() {
		return allocationPercentage;
	}

	public void setAllocationPercentage(int allocationPercentage) {
		this.allocationPercentage = allocationPercentage;
	}

	public long getInvestorId() {
		return investorId;
	}

	public void setInvestorId(long investorId) {
		this.investorId = investorId;
	}

}
