package com.ndanh.controller.impl;

import com.ndanh.common.ApiResponse;
import com.ndanh.controller.UserController;
import com.ndanh.dto.UserDTO;
import com.ndanh.dto.request.user.AddUserRequest;
import com.ndanh.dto.request.user.EditUserRequest;
import com.ndanh.entity.User;
import com.ndanh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserControllerImpl implements UserController {

    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<UserDTO> getUserById(int id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @Override
    public ApiResponse getListUser() {
        return new ApiResponse(userService.getAllUser());
    }

    @Override
    public ApiResponse addUser(@RequestBody AddUserRequest request) {
        return new ApiResponse(userService.createUser(request), "Create user Success");
    }

    @Override
    public ApiResponse updateUser(EditUserRequest request) {
        return new ApiResponse(userService.updateUser(request), "Edit success");
    }

    @Override
    public ApiResponse deleteUser(int id) {
        return new ApiResponse(userService.deleteUser(id), "Delete user success");
    }

    @Override
    public ResponseEntity<List<UserDTO>> searchUser(String name) {
        return ResponseEntity.ok(userService.searchByName(name));
    }

    @Override
    public ResponseEntity<List<UserDTO>> sortListUserByField(String field) {
        return ResponseEntity.ok(userService.getSortListUser(field));
    }

    @Override
    public ResponseEntity<List<UserDTO>> pagingAndSortListUserByField(int pageNo, int pageSize, String field) {
        return ResponseEntity.ok(userService.getSortListUserPaging(field, pageNo, pageSize));
    }

    @Override
    public ResponseEntity<List<UserDTO>> pagingListUser(int pageNo, int pageSize) {
        return ResponseEntity.ok(userService.getListUser(pageNo, pageSize));
    }

    @Override
    public ResponseEntity<UserDTO> checkLogin(String username, String password) {
        return null;
    }

    @Override
    public ResponseEntity<List<UserDTO>> searchUserByName(String name, int pageNo, int pageSize) {
        return ResponseEntity.ok(userService.getListUserByName(name, pageNo, pageSize));
    }
}
