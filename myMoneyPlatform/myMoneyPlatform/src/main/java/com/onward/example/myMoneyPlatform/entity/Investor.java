package com.onward.example.myMoneyPlatform.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

//This class represents the Investor entity in our money platform
@Entity
public class Investor {
	// Auto-generated primary key for the Investor entity
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long investorId;

	// Fields representing the Investor's name, email, and phone number
	private String investorName;

	private String investorEmail;

	private String investorPhone;

//	@OneToMany(mappedBy="investor")
//    private List<Portfolio> portfolio;
	
	 @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	 @JoinColumn(name = "investorID", referencedColumnName = "investorId")
	 Set<Portfolio> portfolio = new HashSet<>();

	public Investor(long investorId, String investorName, String investorEmail, String investorPhone) {
		super();
		this.investorId = investorId;
		this.investorName = investorName;
		this.investorEmail = investorEmail;
		this.investorPhone = investorPhone;
	}

	public Investor() {

	}

	public long getInvestorId() {
		return investorId;
	}

	public void setInvestorId(long investorId) {
		this.investorId = investorId;
	}

	public String getInvestorName() {
		return investorName;
	}

	public void setInvestorName(String investorName) {
		this.investorName = investorName;
	}

	public String getInvestorEmail() {
		return investorEmail;
	}

	public void setInvestorEmail(String investorEmail) {
		this.investorEmail = investorEmail;
	}

	public String getInvestorPhone() {
		return investorPhone;
	}

	public void setInvestorPhone(String investorPhone) {
		this.investorPhone = investorPhone;
	}

}
