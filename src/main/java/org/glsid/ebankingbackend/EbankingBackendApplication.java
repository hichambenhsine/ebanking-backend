package org.glsid.ebankingbackend;

import org.glsid.ebankingbackend.entity.AccountOperation;
import org.glsid.ebankingbackend.entity.CurrentAccount;
import org.glsid.ebankingbackend.entity.Customer;
import org.glsid.ebankingbackend.entity.SavingAccount;
import org.glsid.ebankingbackend.enums.AccountStatus;
import org.glsid.ebankingbackend.enums.OperationType;
import org.glsid.ebankingbackend.repository.AccountOperationRepository;
import org.glsid.ebankingbackend.repository.BankAccountRepository;
import org.glsid.ebankingbackend.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class EbankingBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbankingBackendApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository,
                                        BankAccountRepository bankAccountRepository,
                                        AccountOperationRepository accountOperationRepository){
        return args -> {
            Stream.of("Ali","Hamza","Yassmine").forEach(name->{
                Customer customer = new Customer();
                customer.setName(name);
                customer.setEmail(name+"@gmail.com");
                customerRepository.save(customer);
            });
            customerRepository.findAll().forEach(customer -> {
                CurrentAccount currentAccount=new CurrentAccount();
                currentAccount.setId(UUID.randomUUID().toString());
                currentAccount.setBalance(Math.random()*10000);
                currentAccount.setOverDraft(23000);
                currentAccount.setCreatedAt(new Date());
                currentAccount.setCustomer(customer);
                currentAccount.setStatus(AccountStatus.CREATED);
                bankAccountRepository.save(currentAccount);
            });
            customerRepository.findAll().forEach(customer -> {
                SavingAccount savingAccount=new SavingAccount();
                savingAccount.setId(UUID.randomUUID().toString());
                savingAccount.setBalance(Math.random()*10000);
                savingAccount.setInterestRate(4.3);
                savingAccount.setCreatedAt(new Date());
                savingAccount.setCustomer(customer);
                savingAccount.setStatus(AccountStatus.CREATED);
                bankAccountRepository.save(savingAccount);
            });
            bankAccountRepository.findAll().forEach(account->{
                for (int i =0; i<10; i++){
                    AccountOperation accountOperation = new AccountOperation();
                    accountOperation.setOperationDate(new Date());
                    accountOperation.setAmount(Math.random()*15000);
                    accountOperation.setType(Math.random()>0.5? OperationType.CREDIT : OperationType.DEBIT);
                    accountOperation.setBankAccount(account);
                    accountOperationRepository.save(accountOperation);
                }
            });
        };

    }

}
