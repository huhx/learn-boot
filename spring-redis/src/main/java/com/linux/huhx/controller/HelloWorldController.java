package com.linux.huhx.controller;

import com.linux.huhx.model.Customer;
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
}
