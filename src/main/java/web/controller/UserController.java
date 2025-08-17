package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", userService.readAll());
        return "users";
    }

    @PostMapping("/create")
    public String createUser(@RequestParam("name") String name,
                             @RequestParam("age") int age,
                             @RequestParam("email") String email) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);
        userService.create(user);
        return "redirect:/users";
    }

    @PostMapping("/update")
    public String updateUser(@RequestParam("id") Long id,
                             @RequestParam("name") String name,
                             @RequestParam("age") int age,
                             @RequestParam("email") String email) {
        User user = userService.read(id);
        if (user != null) {
            user.setName(name);
            user.setAge(age);
            user.setEmail(email);
            userService.update(user);
        }
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
