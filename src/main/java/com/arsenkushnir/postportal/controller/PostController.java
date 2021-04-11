package com.arsenkushnir.postportal.controller;

import com.arsenkushnir.postportal.domain.Post;
import com.arsenkushnir.postportal.domain.User;
import com.arsenkushnir.postportal.dto.CreatePostDto;
import com.arsenkushnir.postportal.dto.ResponsePostDto;
import com.arsenkushnir.postportal.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/new")
    public String createForm(){
        return "post/new";
    }

    @PostMapping()
    public String create(@Valid CreatePostDto createPostDto, @AuthenticationPrincipal User user){

        postService.create(createPostDto, user);

        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String getByIdForSpecifiedUser(@AuthenticationPrincipal User user, @PathVariable Long id, Model model){

        ResponsePostDto responsePostDto = postService.getByIdIfAuthor(id, user);

        model.addAttribute("post", responsePostDto);
        model.addAttribute("user", user);

        return "/post/show";
    }

    @GetMapping("/search")
    public String getSearchResult(@RequestParam String title, Model model){

        List<Post> posts = postService.getAllByTitleContains(title);

        model.addAttribute("posts", posts);

        return "main/index";
    }

    @GetMapping("/update/{id}")
    public String getUpdate(@PathVariable Long id, Model model){

        ResponsePostDto responsePostDto = postService.getById(id);

        model.addAttribute("post", responsePostDto);

        return "post/update";
    }

    @PostMapping("/update/{id}")
    public String update(@Valid CreatePostDto createPostDto, @PathVariable Long id){

        postService.update(createPostDto, id);

        return "redirect:/users/account";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id){

        postService.deleteById(id);

        return "redirect:/users/account";
    }
}
