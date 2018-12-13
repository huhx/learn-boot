package com.linux.huhx.controller;

import com.linux.huhx.model.User;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  @PostMapping
  public User postUser(@RequestBody @Valid User user) {
    return user;
  }
}

