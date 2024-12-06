package com.org.customermanagement.repository;

import com.org.customermanagement.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // 추가로 이름으로 검색하는 메서드 정의 (선택 사항)
    List<Customer> findByNameContaining(String keyword);
}
