package com.linux.huhx.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer implements Serializable {

  private long id;
  private String firstName;
  private String lastName;

}
