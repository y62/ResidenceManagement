package com.example.bas.Controller;

import com.example.bas.Service.Model.User;
import com.example.bas.Service.User.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import java.util.Optional;
/**
 * Vi annotere klassen som Controller.
 * Autowirer pga. dependency injection.
 * Mapper HTTP requests til metoder.
 */
@Controller
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/user")
    public String user(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "user";
    }

    @GetMapping("/userCreate")
    public String createUser(Model model) {
        model.addAttribute("user", new User());
        return "userCreate";
    }

    @PostMapping("/userCreate")
    public String createUser(@ModelAttribute User user) {
        userService.create(user);
        return "redirect:/roleCreate";
    }

    @GetMapping("/userUpdate/{userId}")
    public String updateUser(@PathVariable Integer userId, Model model) {
        model.addAttribute("user", userService.findUserById(userId).get());
        return "userUpdate";
    }

    @PostMapping("/userUpdate")
    public String updateUser(@ModelAttribute User user) {
        userService.update(user);
        return "redirect:/user";
    }

    @GetMapping("/userDelete/{userId}")
    public String deleteUser(@PathVariable("userId") int userId, Model model) {
        Optional<User> user = userService.findUserById(userId);
        model.addAttribute("user", user.get());
        return "userDelete";
    }

    @PostMapping("/userDelete")
    public String deleteUser(@ModelAttribute User user) {
        userService.delete(user.getUserId());
        return "redirect:/";
    }
}
