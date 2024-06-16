package microservicedemo.usermanagement.controller;

import lombok.extern.slf4j.Slf4j;
import microservicedemo.usermanagement.model.User;
import microservicedemo.usermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(User user, Model model) {
        log.info("Received registration request: {}", user);
        User existingUser = userService.findByUsername(user.getUsername());
        if (existingUser != null) {
            model.addAttribute("error", "Username already exists");
            return "register";
        }
        userService.save(user);
        log.info("User registered successfully: {}", user);
        model.addAttribute("message", "Registration successful! Please login.");
        // Redirect to the login page after successful registration
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String login(User user, Model model) {
        log.info("Received login request for username: {}", user.getUsername());
        User existingUser = userService.findByUsername(user.getUsername());
        if (existingUser == null || !existingUser.getPassword().equals(user.getPassword())) {
            model.addAttribute("error", "Invalid username or password");
            return "/login";
        }
        log.info("User logged in successfully: {}", user);
        return "redirect:/home";
    }


    @GetMapping("/home")
    public String home() {
        return "home";
    }
}
