package com.simplee2ebackendE.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplee2ebackendE.model.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
