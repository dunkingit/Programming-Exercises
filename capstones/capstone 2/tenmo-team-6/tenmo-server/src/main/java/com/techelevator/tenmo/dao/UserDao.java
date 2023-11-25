package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.RegisterUserDto;
import com.techelevator.tenmo.model.User;
import com.techelevator.tenmo.model.UserDto;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.List;

public interface UserDao {

    List<User> getUsers();

    List<UserDto> getUsersDto();

    User getUserById(int id);

    User getUserByUsername(String username);

    User createUser(RegisterUserDto user);
    int getUserIdByUserName(String username);

}
