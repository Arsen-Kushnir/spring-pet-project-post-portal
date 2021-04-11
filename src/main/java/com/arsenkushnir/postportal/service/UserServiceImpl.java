package com.arsenkushnir.postportal.service;

import com.arsenkushnir.postportal.domain.Post;
import com.arsenkushnir.postportal.domain.User;
import com.arsenkushnir.postportal.domain.UserRole;
import com.arsenkushnir.postportal.dto.CreateUserDto;
import com.arsenkushnir.postportal.dto.ResponseUserDto;
import com.arsenkushnir.postportal.exception.ServiceException;
import com.arsenkushnir.postportal.exception.UserDuplicationException;
import com.arsenkushnir.postportal.exception.UserPasswordsException;
import com.arsenkushnir.postportal.mapper.UserDtoMapper;
import com.arsenkushnir.postportal.repository.PostRepository;
import com.arsenkushnir.postportal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService, AdminUserInitializer ,UserDetailsService {

    private final UserRepository userRepository;

    private final PostRepository postRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    private final Environment environment;

    private final UserDtoMapper mapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PostRepository postRepository, BCryptPasswordEncoder passwordEncoder, Environment environment, UserDtoMapper mapper) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.passwordEncoder = passwordEncoder;
        this.environment = environment;
        this.mapper = mapper;
    }

    @Override
    public void create(CreateUserDto createUserDto) {
        if(!StringUtils.equals(createUserDto.getPassword(), createUserDto.getRepeatedPassword())){
            throw new UserPasswordsException("Passwords do not match!");
        }

        if(userRepository.existsByUsername(createUserDto.getUsername())){
            throw new UserDuplicationException("User with the specified username already exists!");
        }

        User user = User.builder()
                .firstName(createUserDto.getFirstName())
                .lastName(createUserDto.getLastName())
                .age(createUserDto.getAge())
                .username(createUserDto.getUsername())
                .password(passwordEncoder.encode(createUserDto.getPassword()))
                .role(UserRole.ROLE_USER)
                .active(true)
                .build();

        userRepository.save(user);
    }

    @Override
    public ResponseUserDto getById(Long id){
        return mapper.toDto(getByIdOrThrowException(id));
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        User user = getByIdOrThrowException(id);

       List<Post> posts = postRepository.findAllByAuthorUserId(id);
       postRepository.deleteAll(posts);

       userRepository.delete(user);
    }

    @Override
    public void createAdminIfNotExists() {
        if(userRepository.existsByUsername("admin")){
            return;
        }

        User newAdminUser = User.builder()
                .firstName(
                        Objects.requireNonNull(environment.getProperty("admin.default.first_name"))
                )
                .lastName(
                        Objects.requireNonNull(environment.getProperty("admin.default.last_name"))
                )
                .age(Integer.parseInt(
                        Objects.requireNonNull(environment.getProperty("admin.default.age")))
                )
                .username(
                        Objects.requireNonNull(environment.getProperty("admin.default.username"))
                )
                .password(passwordEncoder.encode(
                        Objects.requireNonNull(environment.getProperty("admin.default.password")))
                )
                .role(UserRole.ROLE_ADMIN)
                .active(true)
                .build();

        userRepository.save(newAdminUser);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                        String.format("User with the specified [%s] not found", username))
                );
    }

    private User getByIdOrThrowException(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new ServiceException("User not found!"));
    }
}
