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

import com.onward.example.myMoneyPlatform.entity.Rebalancing;
import com.onward.example.myMoneyPlatform.service.RebalancingService;

@RestController
@RequestMapping(value = "/rebalancing")
public class RebalancingController {
	/**
	 * Autowiring the rebalancingService to make use of its methods.
	 */
	@Autowired
	private RebalancingService rebalancingService;

	/**
	 * This method creates a new rebalancing by calling createrebalancing method
	 * from rebalancingService.
	 * 
	 * @param rebalancing
	 * @return rebalancing
	 */

	@PostMapping("/addrebalancing")
	public Rebalancing addrebalancing(@RequestBody Rebalancing rebalancing) {
		return rebalancingService.createRebalancing(rebalancing);
	}

	/**
	 * This method retrieves all the rebalancings by calling getAllrebalancings
	 * method from rebalancingService.
	 * 
	 * @return List<rebalancing>
	 */

	@GetMapping("/getrebalancings")
	public List<Rebalancing> findAllrebalancings() {
		return rebalancingService.getAllRebalancings();
	}

	/**
	 * This method retrieves a specific rebalancing by calling getrebalancingById
	 * method from rebalancingService.
	 * 
	 * @param rebalancingId
	 * @return rebalancing
	 */

	@GetMapping("/getrebalancing/{rebalancingId}")
	public Rebalancing findrebalancingById(@PathVariable long rebalancingId) {
		return rebalancingService.getRebalancingById(rebalancingId);
	}

	/**
	 * This method updates an existing rebalancing by calling updaterebalancing
	 * method from rebalancingService.
	 * 
	 * @param rebalancing
	 * @return rebalancing
	 */

	@PutMapping("/updaterebalancing")
	public Rebalancing updaterebalancing(@RequestBody Rebalancing rebalancing) {
		return rebalancingService.updateRebalancing(rebalancing);
	}

	/**
	 * This method deletes an existing rebalancing by calling deleterebalancing
	 * method from rebalancingService.
	 * 
	 * @param rebalancingId
	 * @return String
	 */

	@DeleteMapping("/deleterebalancing/{rebalancingId}")
	public String deleterebalancing(@PathVariable Long rebalancingId) {
		return rebalancingService.deleteRebalancing(rebalancingId);
	}
}
