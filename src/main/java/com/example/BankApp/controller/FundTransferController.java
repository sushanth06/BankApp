package com.example.BankApp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BankApp.entity.FundTransfer;
import com.example.BankApp.service.FundTransferService;

@RestController
@RequestMapping("/fundTransfer")
public class FundTransferController {
	

	@Autowired
	FundTransferService fundTransferService ;
	
	@PostMapping
	public FundTransfer transferFund(@RequestBody FundTransfer fundTransfer) {
		return fundTransferService.transferFund(fundTransfer);
	}
 
}
