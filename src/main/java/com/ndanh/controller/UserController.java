package com.ndanh.controller;

import com.ndanh.dto.UserDTO;
import com.ndanh.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/users")
public interface UserController {

    @GetMapping("/{id}")
    ResponseEntity<UserDTO> getUserById(@PathVariable int id);

    @GetMapping("")
    ResponseEntity<List<UserDTO>> getListUser();

    @PostMapping("")
    ResponseEntity<UserDTO> addUser(@RequestBody User user);

    @PutMapping("/{id}")
    ResponseEntity<UserDTO> updateUser(@RequestBody User user,@PathVariable int id);

    @DeleteMapping("/{id}")
    ResponseEntity<UserDTO> deleteUser(@PathVariable int id);

    @GetMapping("/search")
    ResponseEntity<List<UserDTO>> searchUser(@RequestParam(value = "keyword") String name);

    @PostMapping("/login")
    ResponseEntity<UserDTO> checkLogin(@RequestBody String username,@RequestBody String password);
}
