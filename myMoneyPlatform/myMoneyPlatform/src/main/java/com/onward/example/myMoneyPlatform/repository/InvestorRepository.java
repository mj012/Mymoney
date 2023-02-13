package com.onward.example.myMoneyPlatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onward.example.myMoneyPlatform.entity.Investor;

@Repository
public interface InvestorRepository extends JpaRepository<Investor, Long> {

}
