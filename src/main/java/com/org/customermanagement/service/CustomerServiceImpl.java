package com.org.customermanagement.service;

import com.org.customermanagement.model.Customer;
import com.org.customermanagement.repository.CustomerRepository;
import com.org.customermanagement.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        return customerRepository.findById(id)
                .map(existingCustomer -> {
                    existingCustomer.setName(customer.getName());
                    existingCustomer.setEmail(customer.getEmail());
                    existingCustomer.setPhone(customer.getPhone());
                    return customerRepository.save(existingCustomer);
                })
                .orElseThrow(() -> new RuntimeException("Customer not found with id " + id));
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
