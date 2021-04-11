package com.arsenkushnir.postportal.service;

import com.arsenkushnir.postportal.domain.Post;
import com.arsenkushnir.postportal.domain.User;
import com.arsenkushnir.postportal.dto.CreatePostDto;
import com.arsenkushnir.postportal.dto.ResponsePostDto;
import com.arsenkushnir.postportal.exception.ServiceException;
import com.arsenkushnir.postportal.mapper.PostDtoMapper;
import com.arsenkushnir.postportal.repository.PostRepository;
import com.arsenkushnir.postportal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;

    private final UserRepository userRepository;

    private final PostDtoMapper mapper;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository, PostDtoMapper mapper) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public void create(CreatePostDto createPostDto, User user) {
        Post post = Post.builder()
                .authorUserId(user.getId())
                .title(createPostDto.getTitle())
                .anons(createPostDto.getAnons())
                .fullText(createPostDto.getFullText())
                .createdAt(LocalDateTime.now())
                .build();

        postRepository.save(post);
    }

    @Override
    public ResponsePostDto getById(Long id) {
        Post post = getByIdOrThrowException(id);

        User author = userRepository.findById(post.getAuthorUserId())
                .orElseThrow(() -> new ServiceException("User not found!"));

        String authorFullName = author.getFirstName() + " " + author.getLastName();

        return mapper.toDto(post, authorFullName);
    }

    @Override
    public List<Post> getAll() {
        return postRepository.findAll().stream()
                .sorted(
                        (post1, post2) -> post2.getCreatedAt().compareTo(post1.getCreatedAt())
                )
                .collect(Collectors.toList());
    }

    @Override
    public List<Post> getAllByAuthorUserId(Long id){
        return postRepository.findAllByAuthorUserId(id);
    }

    @Override
    public List<Post> getAllByTitleContains(String title) {
        return postRepository.findAllByTitleContains(title.trim()).stream()
                .sorted(
                        (post1, post2) -> post2.getCreatedAt().compareTo(post1.getCreatedAt())
                )
                .collect(Collectors.toList());
    }

    @Override
    public ResponsePostDto getByIdIfAuthor(Long id, User user) {
        return mapper.toDto(postRepository.findByIdAndAuthorUserId(id, user.getId()),
                user.getFirstName() + " " + user.getLastName());
    }

    @Override
    public void update(CreatePostDto createPostDto, Long id) {
        Post post = getByIdOrThrowException(id);

        post.setTitle(createPostDto.getTitle());
        post.setAnons(createPostDto.getAnons());
        post.setFullText(createPostDto.getFullText());

        postRepository.save(post);
    }

    @Override
    public void deleteById(Long id){
        Post post = getByIdOrThrowException(id);

        postRepository.delete(post);
    }

    private Post getByIdOrThrowException(Long id){
        return postRepository.findById(id)
                .orElseThrow(() -> new ServiceException("Post not found!"));
    }
}
