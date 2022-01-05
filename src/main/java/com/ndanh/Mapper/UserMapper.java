package com.ndanh.Mapper;

import com.ndanh.dto.UserDTO;
import com.ndanh.entity.User;
import com.ndanh.repository.DepartmentRepository;
import com.ndanh.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    @Autowired
    private UserRepository repository;

    @Autowired
    DepartmentRepository departmentRepository;

    public UserDTO toUserDTO(User user){
        String name = departmentRepository.getById(user.getDepartment().getDepId()).getDepName();
        return new UserDTO(user.getId(), user.getUsername(), user.getName(),user.getAge(),user.isGender(),name);

    }

    public User toUser(UserDTO userDTO){
        User user = repository.getById(userDTO.getId());
//        user.setUsername(userDTO.getUsername());
//        user.setName(userDTO.getName());
//        user.setAge(userDTO.getAge());
//        user.setGender(userDTO.isGender());
        return user;

    }

}
