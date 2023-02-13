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

import com.onward.example.myMoneyPlatform.entity.Transaction;
import com.onward.example.myMoneyPlatform.service.TransactionService;

@RestController
@RequestMapping(value = "/transaction")
public class TransactionController {

	/**
	 * Autowiring the transactionService to make use of its methods.
	 */
	@Autowired
	private TransactionService transactionService;

	/**
	 * This method creates a new transaction by calling createtransaction method
	 * from transactionService.
	 * 
	 * @param transaction
	 * @return transaction
	 */

	@PostMapping("/addtransaction")
	public Transaction addtransaction(@RequestBody Transaction transaction) {
		return transactionService.createTransaction(transaction);
	}

	/**
	 * This method retrieves all the transactions by calling getAlltransactions
	 * method from transactionService.
	 * 
	 * @return List<transaction>
	 */

	@GetMapping("/gettransactions")
	public List<Transaction> findAlltransactions() {
		return transactionService.getAlltransactions();
	}

	/**
	 * This method retrieves a specific transaction by calling gettransactionById
	 * method from transactionService.
	 * 
	 * @param transactionId
	 * @return transaction
	 */

	@GetMapping("/gettransaction/{transactionId}")
	public Transaction findtransactionById(@PathVariable long transactionId) {
		return transactionService.getTransactionById(transactionId);
	}

	/**
	 * This method updates an existing transaction by calling updatetransaction
	 * method from transactionService.
	 * 
	 * @param transaction
	 * @return transaction
	 */

	@PutMapping("/updatetransaction")
	public Transaction updatetransaction(@RequestBody Transaction transaction) {
		return transactionService.updateTransaction(transaction);
	}

	/**
	 * This method deletes an existing transaction by calling deletetransaction
	 * method from transactionService.
	 * 
	 * @param transactionId
	 * @return String
	 */

	@DeleteMapping("/deletetransaction/{transactionId}")
	public String deletetransaction(@PathVariable Long transactionId) {
		return transactionService.deletetransaction(transactionId);
	}
}
