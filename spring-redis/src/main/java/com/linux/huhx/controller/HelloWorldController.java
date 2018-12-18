package com.linux.huhx.controller;

import com.linux.huhx.model.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helloworld")
public class HelloWorldController {

  @PostMapping()
  public Customer postHelloWorld(@RequestBody Customer customer) {
    return customer;
  }

  @GetMapping("/{customerId}")
  public Customer getHelloWorld(@PathVariable String customerId) {
    return Customer.builder().id(Long.valueOf(customerId)).firstName("Hongxiang").lastName("Hu").build();
  }
}