package com.onward.example.myMoneyPlatform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onward.example.myMoneyPlatform.entity.Rebalancing;
import com.onward.example.myMoneyPlatform.exception.ResourceNotFoundException;
import com.onward.example.myMoneyPlatform.repository.RebalancingRepository;

@Service
public class RebalancingService {

	@Autowired
	private RebalancingRepository rebalancingRepository;

	public Rebalancing createRebalancing(Rebalancing rebalancing) {
		return rebalancingRepository.save(rebalancing);
	}

	public List<Rebalancing> getAllRebalancings() {
		return rebalancingRepository.findAll();
	}

	public Rebalancing getRebalancingById(Long rebalancingId) {
		return rebalancingRepository.findById(rebalancingId).orElseThrow(
				() -> new ResourceNotFoundException(String.format("REBALANCING ID %d not found", rebalancingId)));
	}

	public Rebalancing updateRebalancing(Rebalancing rebalancingId) {
		Rebalancing existingrebalancing = rebalancingRepository.findById(rebalancingId.getRebalancingId()).orElse(null);
		existingrebalancing.setAllocationPercentage(rebalancingId.getAllocationPercentage());
		existingrebalancing.setRebalancedValue(rebalancingId.getRebalancedValue());
		existingrebalancing.setRebalancedPercentage(rebalancingId.getRebalancedPercentage());
		existingrebalancing.setRebalancedDate(rebalancingId.getRebalancedDate());
		existingrebalancing.setPortfolioValue(rebalancingId.getPortfolioValue());
		existingrebalancing.setPortfolioId(rebalancingId.getPortfolioId());
		return rebalancingRepository.save(existingrebalancing);

	}

	public String deleteRebalancing(Long rebalancingId) {
		rebalancingRepository.deleteById(rebalancingId);
		return "rebalancing removed" + rebalancingId;
	}
}
