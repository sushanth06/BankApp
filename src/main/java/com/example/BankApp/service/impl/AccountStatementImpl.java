package com.example.BankApp.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BankApp.entity.FundTransfer;
import com.example.BankApp.repository.FundTransferRepository;
import com.example.BankApp.service.AccountStatementService;

@Service
public class AccountStatementImpl implements AccountStatementService {
	
	@Autowired
	FundTransferRepository fundTransferRepository;


	@Override
	public List<FundTransfer> getAccountStatementFromID(Long accountID) {
		return fundTransferRepository.findByFromAccountID(accountID);
	}
}

