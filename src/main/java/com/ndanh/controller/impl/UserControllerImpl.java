package com.ndanh.controller.impl;

import com.ndanh.Mapper.UserMapper;
import com.ndanh.controller.UserController;
import com.ndanh.dto.UserDTO;
import com.ndanh.entity.User;
import com.ndanh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class UserControllerImpl implements UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Override
    public ResponseEntity<UserDTO> getUserById(int id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @Override
    public ResponseEntity<List<UserDTO>> getListUser() {
        return ResponseEntity.ok( userService.getAllUser());
    }

    @Override
    public ResponseEntity<UserDTO> addUser(User user) {
        return ResponseEntity.ok( userService.createUser(user));
    }

    @Override
    public ResponseEntity<UserDTO> updateUser(User user, int id) {
        return ResponseEntity.ok( userService.updateUser(user,id));
    }

    @Override
    public ResponseEntity<UserDTO> deleteUser(int id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }
}
