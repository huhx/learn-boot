package com.linux.huhx.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {

  @NotNull(message = "username is not empty")
  private String username;
  @NotNull
  private String password;

  @Min(value = 18)
  private Integer age;
}
