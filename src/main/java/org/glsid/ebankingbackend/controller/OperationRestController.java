package org.glsid.ebankingbackend.controller;

import lombok.AllArgsConstructor;
import org.glsid.ebankingbackend.dto.*;
import org.glsid.ebankingbackend.exception.BalanceNotSufficientException;
import org.glsid.ebankingbackend.exception.BankAccountNotFoundException;
import org.glsid.ebankingbackend.service.OperationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/operations")
@AllArgsConstructor
@CrossOrigin("*")
public class OperationRestController {
    private OperationService operationService;

    @GetMapping("/{accountId}/history")
    public List<AccountOperationDTO> getHistory(@PathVariable String accountId) {
        return operationService.getFullAccountHistory(accountId);
    }

    @GetMapping("/{accountId}/page")
    public AccountHistoryDTO getAccountHistory(
            @PathVariable String accountId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) throws BankAccountNotFoundException {
        return operationService.getAccountHistory(accountId, page, size);
    }

    @PostMapping("/debit")
    public AccountOperationDTO debit(@RequestBody DebitDTO request) throws BankAccountNotFoundException, BalanceNotSufficientException {
        return operationService.debit(request.getAccountId(), request.getAmount(), request.getDescription());
    }

    @PostMapping("/credit")
    public AccountOperationDTO credit(@RequestBody CreditDTO request) throws BankAccountNotFoundException {
        return operationService.credit(request.getAccountId(), request.getAmount(), request.getDescription());
    }

    @PostMapping("/transfer")
    public void transfer(@RequestBody TransferRequestDTO request) throws BankAccountNotFoundException, BalanceNotSufficientException {
        operationService.transfer(request.getAccountSource(), request.getAccountDestination(), request.getAmount());
    }
}