package com.onward.example.myMoneyPlatform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onward.example.myMoneyPlatform.entity.Investor;
import com.onward.example.myMoneyPlatform.exception.ResourceNotFoundException;
import com.onward.example.myMoneyPlatform.repository.InvestorRepository;

@Service
public class InvestorService {

	// Autowiring the InvestorRepository to access the database operations
	@Autowired
	private InvestorRepository investorRepository;

	// Method to create an Investor
	public Investor createInvestor(Investor investor) {
		// Saving the Investor to database using the save method of InvestorRepository
		return investorRepository.save(investor);
	}

	// Method to retrieve all the Investors from database
	public List<Investor> getAllInvestors() {
		// Retrieving all the Investors from database using the findAll method of
		// InvestorRepository
		return investorRepository.findAll();
	}

	// Method to retrieve a specific Investor by their id
	public Investor getInvestorById(Long investorId) {
		// Retrieving the Investor from database using the findById method of
		// InvestorRepository
		// Returns the Investor if present, else returns null
		return investorRepository.findById(investorId).orElseThrow(
				() -> new ResourceNotFoundException(String.format("Investor ID %d not found", investorId)));
	}

	// Method to update an existing Investor
	public Investor updateInvestor(Investor investor) {
		// Retrieving the existing Investor from database using the findById method of
		// InvestorRepository
		Investor existingInvestor = investorRepository.findById(investor.getInvestorId()).orElse(null);

		// Updating the details of the existing Investor
		existingInvestor.setInvestorName(investor.getInvestorName());
		existingInvestor.setInvestorEmail(investor.getInvestorEmail());
		existingInvestor.setInvestorPhone(investor.getInvestorPhone());

		// Saving the updated Investor to database using the save method of
		// InvestorRepository
		return investorRepository.save(existingInvestor);

	}

	// Method to delete an Investor by their id
	public String deleteInvestor(Long investorId) {
		// Deleting the Investor from database using the deleteById method of
		// InvestorRepository
		investorRepository.deleteById(investorId);

		// Returning a message confirming the deletion of Investor
		return "Investor with id " + investorId + " has been removed.";
	}
}
