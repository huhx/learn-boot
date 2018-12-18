package com.linux.huhx.repository;

import com.linux.huhx.model.Customer;
import java.util.Map;

public interface CustomerRepository {

  void save(Customer customer);

  Customer find(Long id);

  Map<Long, Customer> findAll();

  void update(Customer customer);

  void delete(Long id);
}
