package com.code.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code.main.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Customer findByEmail(String email);
}
