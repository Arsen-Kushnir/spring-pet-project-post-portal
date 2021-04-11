package com.arsenkushnir.postportal.mapper;

import com.arsenkushnir.postportal.domain.User;
import com.arsenkushnir.postportal.dto.ResponseUserDto;
import org.springframework.stereotype.Component;

@Component
public class UserDtoMapper {

    public ResponseUserDto toDto(User user){
        return ResponseUserDto.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .age(user.getAge())
                .role(user.getRole())
                .build();
    }
}
