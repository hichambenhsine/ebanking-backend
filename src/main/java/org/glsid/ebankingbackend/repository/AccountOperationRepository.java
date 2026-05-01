package org.glsid.ebankingbackend.repository;

import org.glsid.ebankingbackend.entity.AccountOperation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountOperationRepository extends JpaRepository<AccountOperation, Long> {
}
