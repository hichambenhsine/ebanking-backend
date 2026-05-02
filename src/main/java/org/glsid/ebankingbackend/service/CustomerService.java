package org.glsid.ebankingbackend.service;

import org.glsid.ebankingbackend.dto.CustomerDTO;
import org.glsid.ebankingbackend.exception.CustomerNotFoundException;

import java.util.List;

public interface CustomerService {

    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    CustomerDTO getCustomer(Long customerId) throws CustomerNotFoundException;
    CustomerDTO updateCustomer(CustomerDTO customerDTO);
    void deleteCustomer(Long customerId);
    List<CustomerDTO> getAllCustomers();
    List<CustomerDTO> searchCustomers(String keyword);
}
