package com.example.BankApp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BankApp.entity.FundTransfer;
import com.example.BankApp.entity.User;
import com.example.BankApp.repository.FundTransferRepository;
import com.example.BankApp.repository.UserRepository;
import com.example.BankApp.service.FundTransferService;

@Service
public class FundTransferImpl implements FundTransferService {
	@Autowired
	FundTransferRepository fundTransferRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public FundTransfer transferFund(FundTransfer fundTransfer) {
		validateAndMakeTransaction(fundTransfer);
		return fundTransferRepository.save(fundTransfer);
	}

	private void validateAndMakeTransaction(FundTransfer fundTransfer) throws IllegalArgumentException {
		// first check if from and to accountids exists
		// Check if balance is available
		// change balance in both the account -> add/remove
		long fromAccountID = fundTransfer.getFromAccountID();
		long toAccountID = fundTransfer.getToAccountID();
		long amountToTransfer = fundTransfer.getAmountToTransfer();

		User fromUser = userRepository.findByAccountIDEquals(fromAccountID);
		User toUser = userRepository.findByAccountIDEquals(toAccountID);
		if (fromUser == null && toUser == null) {
			throw new IllegalArgumentException("Both Sender account and Receipient account doesn't exists,Please double check");
		} else if (fromUser == null) {
			throw new IllegalArgumentException("Sender account doesn't exists,Please double check fromAccountID");
		} else if (toUser == null) {
			throw new IllegalArgumentException("Recepient account doesn't exists, Please double check toAccountID");
		} else if (fromUser.getInitialAmt() < amountToTransfer) {
			throw new IllegalArgumentException("Funds are not sufficient to make this trnasaction,Please load funds");
		}else if (amountToTransfer == 0) {
			throw new IllegalArgumentException("Please add amount to transfer");
		}
		
		long finalAmountOfSender = fromUser.getInitialAmt() - amountToTransfer;
		userRepository.updateUser(fromAccountID,(int) finalAmountOfSender );
		
		long finalAmountOfRecepient = toUser.getInitialAmt() + amountToTransfer;
		userRepository.updateUser(toAccountID,(int) finalAmountOfRecepient);
		
	}
	
}
