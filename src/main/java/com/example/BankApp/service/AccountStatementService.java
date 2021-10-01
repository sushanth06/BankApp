package com.example.BankApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.BankApp.entity.FundTransfer;

public interface AccountStatementService {
	
	@Autowired	
	public List<FundTransfer> getAccountStatementFromID(Long accountID);

}
