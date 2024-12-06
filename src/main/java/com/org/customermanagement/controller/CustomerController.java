package com.org.customermanagement.controller;

import com.org.customermanagement.dto.CustomerRequestDTO;
import com.org.customermanagement.dto.CustomerResponseDTO;
import com.org.customermanagement.model.Customer;
import com.org.customermanagement.repository.CustomerRepository;
import com.org.customermanagement.util.CustomerMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public List<CustomerResponseDTO> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(CustomerMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public CustomerResponseDTO addCustomer(@RequestBody CustomerRequestDTO requestDTO) {
        Customer customer = CustomerMapper.toEntity(requestDTO);
        customer.setTotalPurchases(0.0); // 초기 구매 금액 설정
        Customer savedCustomer = customerRepository.save(customer);
        return CustomerMapper.toResponseDTO(savedCustomer);
    }

    @PutMapping("/{id}")
    public CustomerResponseDTO updateCustomer(@PathVariable Long id, @RequestBody CustomerRequestDTO requestDTO) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        customer.setName(requestDTO.getName());
        customer.setEmail(requestDTO.getEmail());
        customer.setPhone(requestDTO.getPhone());
        Customer updatedCustomer = customerRepository.save(customer);
        return CustomerMapper.toResponseDTO(updatedCustomer);
    }
}
