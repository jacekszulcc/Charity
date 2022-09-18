package pl.coderslab.charity.controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.dto.UserRegistrationDto;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.entity.UserRole;
import pl.coderslab.charity.service.UserService;

import java.util.List;

@Controller
public class AdminUsersController {
    private final UserService userService;

    public AdminUsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping({"/admin/users", "/admin"})
    public String getUsers(Model model){
        UserRole role = userService.findByName("USER").get();
        List<User> usersList = userService.findUsersByRole(role);
        model.addAttribute("usersList", usersList);
        return "admin/users/admin-users";
    }

    @GetMapping("/admin/users/delete/{id}")
    public String institutionDelete(@PathVariable Long id) {
        userService.deleteUserById(id);
        return "redirect:/admin/users";
    }

    @GetMapping("/admin/users/change/{id}")
    public String changeUserToAdmin(@PathVariable Long id) {
        User user = userService.findUserById(id).get();
        userService.changeRoleToAdmin(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/admin/users/edit/{id}")
    public String editEmail(@PathVariable Long id, Model model) {
        User user = userService.findUserById(id).get();
        model.addAttribute("user", user);
        return "admin/users/users-edit";
    }

    @PostMapping("/admin/users/edit")
    public String usersPostEdit(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/admin/users/add")
    public String newUser(Model model){
        UserRegistrationDto userRegistration = new UserRegistrationDto();
        model.addAttribute("userRegistration", userRegistration);
        return "admin/users/users-add";
    }

    @PostMapping("/admin/users/add")
    public String addUser(Model model, UserRegistrationDto userRegistration){
        userService.registerUserWithDefaultRole(userRegistration);
        return "redirect:/admin/users";
    }


}
