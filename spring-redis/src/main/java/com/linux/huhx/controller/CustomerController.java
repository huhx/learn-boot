package com.linux.huhx.controller;

import com.linux.huhx.model.Customer;
import com.linux.huhx.repository.CustomerRepository;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

  @Autowired
  private CustomerRepository customerRepository;

  @PostMapping("/save")
  @ResponseStatus(HttpStatus.CREATED)
  public String createCustomers() {
    customerRepository.save(new Customer(1L, "Jack", "Smith"));
    customerRepository.save(new Customer(2L, "Adam", "Johnson"));
    customerRepository.save(new Customer(3L, "Kim", "Smith"));
    customerRepository.save(new Customer(4L, "David", "Williams"));
    customerRepository.save(new Customer(5L, "Peter", "Davis"));
    return "done";
  }

  @RequestMapping()
  public List<Customer> findAll() {
    Map<Long, Customer> customers = customerRepository.findAll();
    return customers.values().stream().collect(Collectors.toList());
  }

  @RequestMapping("/{customerId}")
  public Customer findById(@PathParam("customerId") Long customerId) {
    return customerRepository.find(customerId);
  }

  @RequestMapping(value = "/uppercase")
  public String postCustomer(@RequestParam("id") Long id) {
    Customer customer = customerRepository.find(id);
    customer.setFirstName(customer.getFirstName().toUpperCase());
    customer.setLastName(customer.getLastName().toUpperCase());

    customerRepository.update(customer);

    return "Done";
  }

  @RequestMapping("/delete/{customerId}")
  public String deleteById(@PathParam("customerId") Long id) {
    customerRepository.delete(id);
    return "Done";
  }
}
