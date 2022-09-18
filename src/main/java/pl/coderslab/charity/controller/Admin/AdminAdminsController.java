package pl.coderslab.charity.controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.entity.UserRole;
import pl.coderslab.charity.service.UserService;

import java.util.List;

@Controller
public class AdminAdminsController {

    private final UserService userService;

    public AdminAdminsController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin/admins")
    public String getAdmins(Model model){
        UserRole role = userService.findByName("ADMIN").get();
        List<User> adminsList = userService.findUsersByRole(role);
        model.addAttribute("adminsList", adminsList);
        return "/admin/admins/admin-admins";
    }

    @GetMapping("/admin/admins/change/{id}")
    public String changeAdminToUser(@PathVariable Long id) {
        User user = userService.findUserById(id).get();
        userService.changeRoleToUser(user);
        return "redirect:/admin/admins";
    }

    @GetMapping("/admin/admins/edit/{id}")
    public String editEmail(@PathVariable Long id, Model model) {
        User user = userService.findUserById(id).get();
        model.addAttribute("user", user);
        return "admin/admins/admin-edit";
    }

    @PostMapping("/admin/admins/edit")
    public String usersPostEdit(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/admin/admins";
    }

}
