package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.dto.UserRegistrationDto;
import pl.coderslab.charity.service.UserService;

@Controller
public class RegistrationController {
    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String registrationForm(Model model) {
        UserRegistrationDto userRegistration = new UserRegistrationDto();
        model.addAttribute("user", userRegistration);
        return "register";
    }

}
