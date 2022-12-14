package pl.coderslab.charity.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.service.UserService;


@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }

    @PostMapping("/login")
    public String postLogin(){
        return "redirect:/";
    }

}
