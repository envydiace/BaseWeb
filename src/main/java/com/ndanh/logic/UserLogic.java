package com.ndanh.logic;

import com.ndanh.Mapper.UserMapper;
import com.ndanh.dto.UserDTO;
import com.ndanh.dto.request.user.AddUserRequest;
import com.ndanh.dto.request.user.EditUserRequest;
import com.ndanh.entity.Department;
import com.ndanh.entity.User;
import com.ndanh.exception.NotFoundException;
import com.ndanh.exception.ValidateException;
import com.ndanh.repository.DepartmentRepository;
import com.ndanh.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UserLogic {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DepartmentRepository departmentRepository;

    public UserDTO addUser(AddUserRequest request) {
        User u = userRepository.getByUsername(request.getUsername());
        if (!Objects.isNull(u)) {
            throw new ValidateException("username existed!");
        }
        Department department = departmentRepository.findById(request.getDepartmentId()).orElse(null);
        User user = User.builder()
                .username(request.getUsername())
                .age(request.getAge())
                .gender(request.getGender())
                .department(department)
                .build();
        return userMapper.toDto(userRepository.save(user));
    }

    public UserDTO updateUser(EditUserRequest request) {
        User user = userRepository.findById(request.getId()).orElseThrow(() -> new NotFoundException("Not found user with id: "+ request.getId()));
        Department department = departmentRepository.findById(request.getDepartmentId()).orElse(null);
        user.setUsername(request.getUsername());
        user.setName(request.getName());
        user.setAge(request.getAge());
        user.setGender(request.getGender());
        user.setDepartment(department);
        return userMapper.toDto(userRepository.save(user));
    }
}