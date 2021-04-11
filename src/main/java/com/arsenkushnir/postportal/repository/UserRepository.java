package com.arsenkushnir.postportal.repository;

import com.arsenkushnir.postportal.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    boolean existsByUsername(String username);

    Optional<User> findUserByUsername(String username);

    List<User> findAll();
}
