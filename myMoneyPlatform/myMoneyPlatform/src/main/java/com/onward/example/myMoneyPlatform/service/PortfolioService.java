package com.onward.example.myMoneyPlatform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onward.example.myMoneyPlatform.entity.Portfolio;
import com.onward.example.myMoneyPlatform.exception.ResourceNotFoundException;
import com.onward.example.myMoneyPlatform.repository.PortfolioRepository;

@Service
public class PortfolioService {

	@Autowired
	private PortfolioRepository portfolioRepository;

	public Portfolio createportfolio(Portfolio portfolio) {
		return portfolioRepository.save(portfolio);
	}

	public List<Portfolio> getAllportfolios() {
		return portfolioRepository.findAll();
	}

	public Portfolio getportfolioById(Long portfolioID) {
		return portfolioRepository.findById(portfolioID).orElseThrow(
				() -> new ResourceNotFoundException(String.format("PORTFOLIO ID %d not found", portfolioID)));
	}

	public Portfolio updateportfolio(Portfolio portfolioID) {
		Portfolio existingportfolio = portfolioRepository.findById(portfolioID.getPortfolioID()).orElse(null);
		existingportfolio.setAllocationPercentage(portfolioID.getAllocationPercentage());
		existingportfolio.setPortfolioValue(portfolioID.getPortfolioValue());
//		existingportfolio.setInvestorId(portfolioID.getInvestorId());
		return portfolioRepository.save(existingportfolio);

	}

	public String deleteportfolio(Long portfolioId) {
		portfolioRepository.deleteById(portfolioId);
		return "portfolio removed" + portfolioId;
	}
}
