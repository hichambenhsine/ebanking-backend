package org.glsid.ebankingbackend.controller;

import lombok.AllArgsConstructor;
import org.glsid.ebankingbackend.dto.BankAccountDTO;
import org.glsid.ebankingbackend.exception.BankAccountNotFoundException;
import org.glsid.ebankingbackend.service.BankAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@AllArgsConstructor
@CrossOrigin("*")
public class BankAccountRestController {
    private BankAccountService bankAccountService;

    @GetMapping("/{id}")
    public BankAccountDTO getBankAccount(@PathVariable String id) throws BankAccountNotFoundException {
        return bankAccountService.getBankAccount(id);
    }

    @GetMapping
    public List<BankAccountDTO> getAllAccounts() {
        return bankAccountService.getAllBankAccounts();
    }
}
