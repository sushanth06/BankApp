package com.example.BankApp.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.BankApp.entity.FundTransfer;

public interface FundTransferService {
	
	@Autowired
	public FundTransfer transferFund(FundTransfer fundTransfer);
}
