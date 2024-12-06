package com.org.customermanagement.dto;

import lombok.Data;

@Data
public class CustomerResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private Double totalPurchases;
}
