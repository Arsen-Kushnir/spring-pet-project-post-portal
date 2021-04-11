package com.arsenkushnir.postportal.controller;

import com.arsenkushnir.postportal.domain.Post;
import com.arsenkushnir.postportal.domain.User;
import com.arsenkushnir.postportal.dto.CreateUserDto;
import com.arsenkushnir.postportal.dto.ResponseUserDto;
import com.arsenkushnir.postportal.service.PostService;
import com.arsenkushnir.postportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/accounts")
public class AccountController {

    private final UserService userService;

    private final PostService postService;

    @Autowired
    public AccountController(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }

    @PostMapping()
    public String create(@Valid CreateUserDto createUserDto){

        userService.create(createUserDto);

        return "redirect:/login";
    }

    @GetMapping("/index")
    public String myAccount(@AuthenticationPrincipal User user, Model model){

        List<Post> posts = postService.getAllByAuthorUserId(user.getId());

        model.addAttribute("posts", posts);
        model.addAttribute("user", user);

        return "account/index";
    }

    @GetMapping("/data")
    public String myAccountData(@AuthenticationPrincipal User user, Model model){

        ResponseUserDto responseUserDto = userService.getById(user.getId());

        model.addAttribute("user", responseUserDto);

        return "account/show";
    }

    @GetMapping("/all")
    public String getUsers(@AuthenticationPrincipal User user, Model model){

        List<User> users = userService.getAll();

        model.addAttribute("users", users);
        model.addAttribute("user", user);

        return "account/users";
    }

    @PostMapping("delete/{id}")
    public String delete(@PathVariable Long id){

        userService.delete(id);

        return "redirect:/accounts/all";
    }
}
