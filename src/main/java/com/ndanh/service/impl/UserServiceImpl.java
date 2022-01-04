package com.ndanh.service.impl;

import com.ndanh.Mapper.UserMapper;
import com.ndanh.dto.UserDTO;
import com.ndanh.entity.User;
import com.ndanh.repository.UserRepository;
import com.ndanh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper mapper;

    @Override
    public List<UserDTO> getAllUser() {
        List<UserDTO> result = new ArrayList<>();
        List<User> users = userRepository.findAll();
        for(User user: users){
            result.add(mapper.toUserDTO(user));
        }
        return result;
    }

    @Override
    public UserDTO getUserById(int id) {

        return mapper.toUserDTO((User) userRepository.getById(id));
    }

    @Override
    public UserDTO createUser(User user) {
        return mapper.toUserDTO(userRepository.save(user));
    }



    @Override
    public UserDTO deleteUser(int id) {
        User user = userRepository.getById(id);
        userRepository.delete(user);
        return mapper.toUserDTO(user);
    }

    @Override
    public UserDTO updateUser(User user, int id) {
        user.setId(id);
        return mapper.toUserDTO( (User) userRepository.save(user) );
    }


}
