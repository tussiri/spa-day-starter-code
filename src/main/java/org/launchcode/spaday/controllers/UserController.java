package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {
    //TODO create a handler method displayAddUserForm() should correspond to the path /user/add and return add.html

    @GetMapping("add")
    public String displayAddUserForm(){

        return "user/add";

    }


    //TODO create a handler with this signature:
    @PostMapping("")
     public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        if(user.getPassword().equals(verify)){
            return "user/index";
        }else{
            model.addAttribute("error", "Passwords do not match! Try again.");
            model.addAttribute("username", user.getUsername());
            model.addAttribute("email", user.getEmail());
            return "user/add";
        }

    }

}
