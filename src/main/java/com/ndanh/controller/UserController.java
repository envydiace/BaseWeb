package com.ndanh.controller;

import com.ndanh.common.ApiResponse;
import com.ndanh.dto.UserDTO;
import com.ndanh.dto.request.user.AddUserRequest;
import com.ndanh.dto.request.user.EditUserRequest;
import com.ndanh.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/users")
public interface UserController {

    @GetMapping("/{id}")
    ResponseEntity<UserDTO> getUserById(@PathVariable int id);

    @GetMapping("")
    ApiResponse getListUser();

    @PostMapping("/add")
    ApiResponse addUser(@RequestBody AddUserRequest request);

    @PutMapping("/edit")
    ApiResponse updateUser(@RequestBody EditUserRequest request);

    @DeleteMapping("/{id}")
    ApiResponse deleteUser(@PathVariable int id);

    @GetMapping("/search")
    ResponseEntity<List<UserDTO>> searchUser(@RequestParam(value = "keyword") String name);

    @GetMapping("/search/{field}")
    ResponseEntity<List<UserDTO>> sortListUserByField(@PathVariable String field);

    @GetMapping("/page")
    ResponseEntity<List<UserDTO>> pagingAndSortListUserByField(@RequestParam(name = "pageNo", required = false, defaultValue = "1") int pageNo,
                                                               @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize,
                                                               @RequestParam(name = "field", required = false, defaultValue = "id") String field);

    @GetMapping("/list")
    ResponseEntity<List<UserDTO>> pagingListUser(@RequestParam int pageNo, @RequestParam int pageSize);

    @PostMapping("/login")
    ResponseEntity<UserDTO> checkLogin(@RequestBody String username, @RequestBody String password);

    @GetMapping("/searchBy")
    ResponseEntity<List<UserDTO>> searchUserByName(@RequestParam String name, @RequestParam int pageNo, @RequestParam int pageSize);
}
