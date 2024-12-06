package com.org.customermanagement.util;

import com.org.customermanagement.dto.CustomerRequestDTO;
import com.org.customermanagement.dto.CustomerResponseDTO;
import com.org.customermanagement.model.Customer;

public class CustomerMapper {

    // CustomerRequestDTO -> Customer
    public static Customer toEntity(CustomerRequestDTO dto) {
        Customer customer = new Customer();
        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());
        customer.setPhone(dto.getPhone());
        return customer;
    }

    // Customer -> CustomerResponseDTO
    public static CustomerResponseDTO toResponseDTO(Customer customer) {
        CustomerResponseDTO responseDTO = new CustomerResponseDTO();
        responseDTO.setId(customer.getId());
        responseDTO.setName(customer.getName());
        responseDTO.setEmail(customer.getEmail());
        responseDTO.setPhone(customer.getPhone());
        responseDTO.setTotalPurchases(customer.getTotalPurchases());
        return responseDTO;
    }
}
