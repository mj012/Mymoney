package com.onward.example.myMoneyPlatform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onward.example.myMoneyPlatform.entity.Portfolio;
import com.onward.example.myMoneyPlatform.service.PortfolioService;

@RestController
@RequestMapping(value = "/portfolio")
public class PortfolioController {

	/**
	 * Autowiring the portfolioService to make use of its methods.
	 */
	@Autowired
	private PortfolioService portfolioService;

	/**
	 * This method creates a new portfolio by calling createportfolio method from
	 * portfolioService.
	 * 
	 * @param portfolio
	 * @return portfolio
	 */

	@PostMapping("/addportfolio")
	public Portfolio addportfolio(@RequestBody Portfolio portfolio) {
		return portfolioService.createportfolio(portfolio);
	}

	/**
	 * This method retrieves all the portfolios by calling getAllportfolios method
	 * from portfolioService.
	 * 
	 * @return List<portfolio>
	 */

	@GetMapping("/getportfolios")
	public List<Portfolio> findAllportfolios() {
		return portfolioService.getAllportfolios();
	}

	/**
	 * This method retrieves a specific portfolio by calling getportfolioById method
	 * from portfolioService.
	 * 
	 * @param portfolioId
	 * @return portfolio
	 */

	@GetMapping("/getportfolio/{portfolioId}")
	public Portfolio findportfolioById(@PathVariable long portfolioId) {
		return portfolioService.getportfolioById(portfolioId);
	}

	/**
	 * This method updates an existing portfolio by calling updateportfolio method
	 * from portfolioService.
	 * 
	 * @param portfolio
	 * @return portfolio
	 */

	@PutMapping("/updateportfolio")
	public Portfolio updateportfolio(@RequestBody Portfolio portfolio) {
		return portfolioService.updateportfolio(portfolio);
	}

	/**
	 * This method deletes an existing portfolio by calling deleteportfolio method
	 * from portfolioService.
	 * 
	 * @param portfolioId
	 * @return String
	 */

	@DeleteMapping("/deleteportfolio/{portfolioId}")
	public String deleteportfolio(@PathVariable Long portfolioId) {
		return portfolioService.deleteportfolio(portfolioId);
	}
}
