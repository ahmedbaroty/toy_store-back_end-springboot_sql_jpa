package com.orange.toystorebackend.controllers;

import com.orange.toystorebackend.entities.User;
import com.orange.toystorebackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping(method = RequestMethod.POST, value = "/user/login")
    public User login(@RequestBody User user) {
        User actualUser = userService.getUserByEmail(user.getEmail());
        if (actualUser != null) {
            if (bCryptPasswordEncoder.matches(user.getPassword(), actualUser.getPassword())) {
                actualUser.setPassword(user.getPassword());
                return actualUser;
            }
        }
        return userService.findUserByMailAndPassword(
                user.getEmail(),
                user.getPassword());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/user/add")
    public User signUp(@RequestBody User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userService.addUser(user);
    }

    @CrossOrigin("http://localhost:8080")
    @RequestMapping(method = RequestMethod.PUT, value = "/user/update")
    public User updateProfile(@RequestBody User user) {
        String password = user.getPassword();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        User updatedUser = userService.updateUser(user);
        updatedUser.setPassword(password);
        return updatedUser;
    }

    @RequestMapping(method = RequestMethod.GET , value = "/user/{userId}")
    public User getUser(@PathVariable Integer userId){
        return userService.getUser(userId);
    }
}
