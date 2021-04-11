package com.arsenkushnir.postportal.dto;

import com.arsenkushnir.postportal.domain.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder()
@AllArgsConstructor
@NoArgsConstructor
public class ResponseUserDto {

    private Long id;

    private String firstName;

    private String lastName;

    private Integer age;

    private UserRole role;
}
