package com.ndanh.service.impl;

import com.ndanh.Mapper.UserMapper;
import com.ndanh.dto.UserDTO;
import com.ndanh.entity.User;
import com.ndanh.exception.DuplicateIdException;
import com.ndanh.exception.NotFoundException;
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
            result.add(mapper.toUserDTO( user));
        }
        return result;
    }

    @Override
    public UserDTO getUserById(int id) {
        for (User u:userRepository.findAll()){
            if(u.getId()==id){
                return mapper.toUserDTO(u);
            }
        }

        throw new NotFoundException("User khong ton tai");
    }

    @Override
    public UserDTO createUser(User user) {
        for(User u :userRepository.findAll()){
            if(u.getUsername().equals(user.getUsername())){
                throw new DuplicateIdException("username khong hop le");
            }
        }
        UserDTO userDTO = mapper.toUserDTO(userRepository.save(user));
        return userDTO;
    }

    @Override
    public UserDTO deleteUser(int id) {
        User user = userRepository.getById(id);
        userRepository.delete(user);
        return mapper.toUserDTO(user);
    }

    @Override
    public UserDTO updateUser(User user, int id) {
        User user1 = userRepository.getById(id);
        String username = user.getUsername();
        String name = user.getName();
        String password = user.getPassword();
        boolean gender = user.isGender();
        int age = user.getAge();
        if(username!=null) user1.setUsername(username);
        if(name!=null) user1.setName(name);
        if(password!=null) user1.setPassword(password);

        return mapper.toUserDTO( userRepository.save(user) );
    }

    @Override
    public  List<UserDTO> searchByName(String name) {
        List<User> users = userRepository.searchByName(name);
        List<UserDTO> userDTOS = new ArrayList<>();
        for(User u :users){
            userDTOS.add(mapper.toUserDTO(u));
        }
        return  userDTOS;
    }


}
