package org.glsid.ebankingbackend.controller;

import lombok.AllArgsConstructor;
import org.glsid.ebankingbackend.dto.CustomerDTO;
import org.glsid.ebankingbackend.exception.CustomerNotFoundException;
import org.glsid.ebankingbackend.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
@CrossOrigin("*")
public class CustomerRestController {
    private CustomerService customerService;

    @GetMapping
    public List<CustomerDTO> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/search")
    public List<CustomerDTO> searchCustomers(@RequestParam(name = "keyword", defaultValue = "") String keyword) {
        return customerService.searchCustomers("%" + keyword + "%");
    }

    @GetMapping("/{id}")
    public CustomerDTO getCustomer(@PathVariable Long id) throws CustomerNotFoundException {
        return customerService.getCustomer(id);
    }

    @PostMapping
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerService.saveCustomer(customerDTO);
    }

    @PutMapping("/{id}")
    public CustomerDTO updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
        customerDTO.setId(id);
        return customerService.updateCustomer(customerDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }
}