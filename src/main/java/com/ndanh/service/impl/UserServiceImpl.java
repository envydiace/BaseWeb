package com.ndanh.service.impl;

import com.ndanh.Mapper.UserMapper;
import com.ndanh.dto.UserDTO;
import com.ndanh.entity.User;
import com.ndanh.exception.DuplicateIdException;
import com.ndanh.exception.NotFoundException;
import com.ndanh.repository.UserRepository;
import com.ndanh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    @Override
    public List<UserDTO> getSortListUser(String field) {
        List<UserDTO> result = new ArrayList<>();
        List<User> list = userRepository.findAll(Sort.by(Sort.Direction.ASC,field));
        for(User u:list){
            result.add(mapper.toUserDTO(u));
        }
        return result;
    }

    @Override
    public List<UserDTO> getListUser(int pageNo, int pageSize) {
        List<UserDTO> userDTOList = new ArrayList<>();
        Page<User> userPage = userRepository.findAll(PageRequest.of(pageNo-1,pageSize));
        for(User u:userPage){
            userDTOList.add(mapper.toUserDTO(u));
        }
        return userDTOList;
    }

    @Override
    public List<UserDTO> getSortListUserPaging(String field, int pageNo, int pageSize) {
        List<UserDTO> result = new ArrayList<>();
        Page<User> userPage = userRepository.findAll(PageRequest.of(pageNo-1,pageSize).withSort(Sort.by(field)));
        for(User u:userPage){
            result.add(mapper.toUserDTO(u));
        }
        return result;
    }


}
