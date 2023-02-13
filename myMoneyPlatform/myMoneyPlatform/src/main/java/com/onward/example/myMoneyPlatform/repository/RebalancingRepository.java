package com.onward.example.myMoneyPlatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onward.example.myMoneyPlatform.entity.Rebalancing;

@Repository
public interface RebalancingRepository extends JpaRepository<Rebalancing, Long> {

}
