package com.arsenkushnir.postportal.service;

import com.arsenkushnir.postportal.domain.Post;
import com.arsenkushnir.postportal.domain.User;
import com.arsenkushnir.postportal.dto.CreatePostDto;
import com.arsenkushnir.postportal.dto.ResponsePostDto;

import java.util.List;

public interface PostService {

    void create(CreatePostDto createPostDto, User user);

    List<Post> getAll();

    List<Post> getAllByAuthorUserId(Long id);

    List<Post> getAllByTitleContains(String title);

    ResponsePostDto getById(Long id);

    ResponsePostDto getByIdIfAuthor(Long id, User user);

    void update(CreatePostDto createPostDto, Long id);

    void deleteById(Long id);
}
