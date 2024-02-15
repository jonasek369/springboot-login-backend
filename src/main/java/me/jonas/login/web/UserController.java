package me.jonas.login.web;

import jakarta.validation.Valid;
import me.jonas.login.model.User;
import me.jonas.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }


    @GetMapping(path="")
    public String hello(){
        return "Hello world";
    }

    @PostMapping(path = "/api/login")
    public boolean login(@RequestBody @Valid User payloadUser){
        return userService.loginUser(payloadUser);
    }

    @PostMapping(path = "/api/register")
    public boolean register(@RequestBody @Valid User payloadUser){
        if(userService.contains(payloadUser)){
            return false;
        }
        userService.add(new User(payloadUser.getName(), payloadUser.getEmail(), payloadUser.getPasswordHash()));
        return true;
    }
}
