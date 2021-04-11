package com.arsenkushnir.postportal.repository;

import com.arsenkushnir.postportal.domain.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {

    List<Post> findAll();

    List<Post> findAllByAuthorUserId(Long id);

    List<Post> findAllByTitleContains(String title);

    Post findByIdAndAuthorUserId(Long id, Long authorUserId);
}
