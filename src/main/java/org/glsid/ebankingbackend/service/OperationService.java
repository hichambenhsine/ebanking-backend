package org.glsid.ebankingbackend.service;

import org.glsid.ebankingbackend.dto.AccountHistoryDTO;
import org.glsid.ebankingbackend.dto.AccountOperationDTO;
import org.glsid.ebankingbackend.exception.BalanceNotSufficientException;
import org.glsid.ebankingbackend.exception.BankAccountNotFoundException;

import java.util.List;

public interface OperationService {
    AccountOperationDTO debit(String accountId, double amount, String description) throws BankAccountNotFoundException, BalanceNotSufficientException;
    AccountOperationDTO credit(String accountId, double amount, String description) throws BankAccountNotFoundException;
    void transfer(String accountIdSource, String accountIdDestination, double amount) throws BankAccountNotFoundException, BalanceNotSufficientException;
    List<AccountOperationDTO> getFullAccountHistory(String accountId);
    AccountHistoryDTO getAccountHistory(String accountId, int page, int size) throws BankAccountNotFoundException;
}