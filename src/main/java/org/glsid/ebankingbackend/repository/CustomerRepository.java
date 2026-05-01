package org.glsid.ebankingbackend.repository;

import org.glsid.ebankingbackend.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
