package web.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web.Dao.UserDao;
import web.Model.User;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    private final UserDao dao;

    @Autowired
    public UserController(UserDao dao) {
        this.dao = dao;
    }

    @GetMapping(value = "/allUsers")
    public String showAllUsers(Model model) {
        List<User> allUsers = dao.getAllUsers();
        model.addAttribute("allUsers",allUsers);
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm Spring MVC application");
        messages.add("5.2.0 version by sep'19 ");
        model.addAttribute("messages", messages);
        return "all-Users";
    }
}
