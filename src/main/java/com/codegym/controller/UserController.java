package com.codegym.controller;

import com.codegym.model.User;
import com.codegym.service.IUserService;
import com.codegym.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserController {
    private IUserService userService = new UserService();
    @GetMapping("/users")
    public ModelAndView showForm(){
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }
    @PostMapping("/users")
    public ModelAndView create(@Validated @ModelAttribute User user, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return new ModelAndView("home","user",user);
        }else {
        int id =(int) Math.random()*1000;
        user.setId(id);
        userService.save(user);
        ModelAndView modelAndView = new ModelAndView("result","user",new User());
        return modelAndView;
        }
    }
}
