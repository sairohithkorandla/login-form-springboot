package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo.User;


@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository; // ✅ this line is important!

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "form";
    }

    @PostMapping("/submit")
    public String submitForm(@ModelAttribute User user, Model model) {
        userRepository.save(user); // ✅ this saves one user
        model.addAttribute("username", user.getUsername());
        return "success";
    }
}
