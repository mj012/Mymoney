package com.onward.example.myMoneyPlatform.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onward.example.myMoneyPlatform.exception.ResourceNotFoundException;
import com.onward.example.myMoneyPlatform.entity.Investor;
import com.onward.example.myMoneyPlatform.service.InvestorService;

/**
 * The InvestorController class is responsible for handling all the incoming
 * requests related to Investor Entity.
 */

@RestController
@RequestMapping(value = "/investor")
public class InvestorController {

	/**
	 * Autowiring the InvestorService to make use of its methods.
	 */
	@Autowired
	private InvestorService investorService;

	/**
	 * This method creates a new Investor by calling createInvestor method from
	 * InvestorService.
	 * 
	 * @param investor
	 * @return Investor
	 */

	@PostMapping("/addInvestor")
	public Investor addInvestor(@RequestBody Investor investor) {
		return investorService.createInvestor(investor);
	}

	/**
	 * This method retrieves all the Investors by calling getAllInvestors method
	 * from InvestorService.
	 * 
	 * @return List<Investor>
	 */

	@GetMapping("/getInvestors")
	public List<Investor> findAllInvestors() {
		return investorService.getAllInvestors();
	}

	/**
	 * This method retrieves a specific Investor by calling getInvestorById method
	 * from InvestorService.
	 * 
	 * @param investorId
	 * @return Investor
	 * 
	 */

	@GetMapping("/getInvestor/{investorId}")
	public Investor findInvestorById(@PathVariable long investorId) throws ResourceNotFoundException {
		return investorService.getInvestorById(investorId);
	}

	/**
	 * This method updates an existing Investor by calling updateInvestor method
	 * from InvestorService.
	 * 
	 * @param investor
	 * @return Investor
	 */

	@PutMapping("/updateInvestor")
	public Investor updateInvestor(@RequestBody Investor investor) {
		return investorService.updateInvestor(investor);
	}

	/**
	 * This method deletes an existing Investor by calling deleteInvestor method
	 * from InvestorService.
	 * 
	 * @param investorId
	 * @return String
	 */

	@DeleteMapping("/deleteInvestor/{investorId}")
	public String deleteInvestor(@PathVariable Long investorId) {
		return investorService.deleteInvestor(investorId);
	}
}
