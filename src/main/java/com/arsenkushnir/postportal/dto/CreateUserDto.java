package com.arsenkushnir.postportal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDto {

    @NotBlank(message = "Should not be empty!")
    private String firstName;

    @NotBlank(message = "Should not be empty!")
    private String lastName;

    @NotNull(message = "Should not be empty!")
    @Min(value = 0, message = "Should not be less then zero!")
    private Integer age;

    @NotBlank(message = "Should not be empty!")
    private String username;

    @NotBlank(message = "Should not be empty!")
    private String password;

    @NotBlank(message = "Should not be empty!")
    private String repeatedPassword;
}
