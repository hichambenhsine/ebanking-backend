package org.glsid.ebankingbackend.service;

import org.glsid.ebankingbackend.dto.BankAccountDTO;
import org.glsid.ebankingbackend.dto.CurrentBankAccountDTO;
import org.glsid.ebankingbackend.dto.SavingBankAccountDTO;
import org.glsid.ebankingbackend.exception.BankAccountNotFoundException;
import org.glsid.ebankingbackend.exception.CustomerNotFoundException;

import java.util.List;

public interface BankAccountService {
    CurrentBankAccountDTO saveCurrentBankAccount(double initialBalance, double overDraft, Long customerId) throws CustomerNotFoundException;
    SavingBankAccountDTO saveSavingBankAccount(double initialBalance, double interestRate, Long customerId) throws CustomerNotFoundException;
    BankAccountDTO getBankAccount(String accountId) throws BankAccountNotFoundException;
    List<BankAccountDTO> getAllBankAccounts();
}