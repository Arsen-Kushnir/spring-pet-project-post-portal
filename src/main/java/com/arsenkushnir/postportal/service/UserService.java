package com.arsenkushnir.postportal.service;

import com.arsenkushnir.postportal.domain.User;
import com.arsenkushnir.postportal.dto.CreateUserDto;
import com.arsenkushnir.postportal.dto.ResponseUserDto;

import java.util.List;

public interface UserService {

    void create(CreateUserDto user);

    List<User> getAll();

    ResponseUserDto getById(Long id);

    void delete(Long id);
}
