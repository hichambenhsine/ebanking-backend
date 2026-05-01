package org.glsid.ebankingbackend.repository;

import org.glsid.ebankingbackend.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
}
