package com.example.BoardGameProject.controllers;

import com.example.BoardGameProject.models.RoleSystem.User;
import com.example.BoardGameProject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.function.Function;

@RestController
@RequestMapping("/admin")
public class AdminController
{
    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration(Model model)
    {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @GetMapping
    public String userList(Model model)
    {
        model.addAttribute("allUsers", userService.allUsers());
        return "admin";
    }

    @PostMapping
    public String deleteUser(@RequestParam(required = true, defaultValue = "" ) Long userId,
            @RequestParam(required = true, defaultValue = "" ) String action,
            Model model)
    {
        if (action.equals("delete")){
            userService.deleteUser(userId);
        }
        return "redirect:/admin";
    }

    @PostMapping("/registration/store")
    public String addStore(@ModelAttribute("userForm") @Valid User userForm, BindingResult bindingResult, Model model)
    {
        return registration(userForm, bindingResult, model, user -> userService.saveStore(user));
    }

    @PostMapping("/registration/admin")
    public String addAdmin(@ModelAttribute("userForm") @Valid User userForm, BindingResult bindingResult, Model model)
    {
        return registration(userForm, bindingResult, model, user -> userService.saveAdmin(user));
    }

    private String registration(User userForm, BindingResult bindingResult, Model model, Function<User,Boolean> save)
    {
        if (bindingResult.hasErrors())
        {
            return "registration";
        }
        if (!userForm.getPassword().equals(userForm.getPasswordConfirm()))
        {
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "registration";
        }
        if (!save.apply(userForm))
        {
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "registration";
        }
        return "redirect:/";
    }
}
