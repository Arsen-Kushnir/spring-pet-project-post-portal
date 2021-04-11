package com.arsenkushnir.postportal.controller;

import com.arsenkushnir.postportal.domain.Post;
import com.arsenkushnir.postportal.dto.ResponsePostDto;
import com.arsenkushnir.postportal.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class MainController {

    private final PostService postService;

    @Autowired
    public MainController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public String index(Model model){

        List<Post> posts = postService.getAll();

        model.addAttribute("posts", posts);

        return "/main/index";
    }

    @GetMapping("/main/posts/{id}")
    public String getById(@PathVariable Long id, Model model){

        ResponsePostDto responsePostDto = postService.getById(id);

        model.addAttribute("post", responsePostDto);

        return "/post/show";
    }
}
