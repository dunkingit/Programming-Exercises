package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.User;
import com.techelevator.tenmo.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserDao userDao;

    @GetMapping("/{id}")
    public int getUserId(@PathVariable int id) {
        User user = userDao.getUserById(id);
        if (user != null) {
            return user.getId();
        }
        return -1;
    }

    @GetMapping("/{username}")
    public int getUserName(@PathVariable String username) {
        User user = userDao.getUserByUsername(username);
        if (user != null) {
            return user.getId();
        }
        return -1;
    }

    @GetMapping("/list")
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @GetMapping("/getusers")
    public List<UserDto> getUsersDto() {
        return userDao.getUsersDto();
    }

}
