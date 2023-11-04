package com.ndanh.service.impl;

import com.ndanh.Mapper.UserMapper;
import com.ndanh.dto.UserDTO;
import com.ndanh.dto.request.user.AddUserRequest;
import com.ndanh.dto.request.user.EditUserRequest;
import com.ndanh.entity.User;
import com.ndanh.exception.NotFoundException;
import com.ndanh.exception.ValidateException;
import com.ndanh.logic.UserLogic;
import com.ndanh.repository.UserRepository;
import com.ndanh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserLogic userLogic;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserDTO> getAllUser() {
        List<UserDTO> result = new ArrayList<>();
        List<User> users = userRepository.findAll();
        for (User user : users) {
            result.add(userMapper.toDto(user));
        }
        return result;
    }

    @Override
    public UserDTO getUserById(int id) {
        for (User u : userRepository.findAll()) {
            if (u.getId() == id) {
                return userMapper.toDto(u);
            }
        }

        throw new NotFoundException("User khong ton tai");
    }

    @Override
    public UserDTO createUser(AddUserRequest request) {
        return userLogic.addUser(request);
    }

    @Override
    public UserDTO deleteUser(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found user with id: "+ id));
        userRepository.delete(user);
        return userMapper.toDto(user);
    }

    @Override
    public UserDTO updateUser(EditUserRequest request) {
        return userLogic.updateUser(request);
    }

    @Override
    public List<UserDTO> searchByName(String name) {
        List<User> users = userRepository.searchByName(name);
        List<UserDTO> userDTOS = new ArrayList<>();
        for (User u : users) {
            userDTOS.add(userMapper.toDto(u));
        }
        return userDTOS;
    }

    @Override
    public List<UserDTO> getSortListUser(String field) {
        List<UserDTO> result = new ArrayList<>();
        List<User> list = userRepository.findAll(Sort.by(Sort.Direction.ASC, field));
        for (User u : list) {
            result.add(userMapper.toDto(u));
        }
        return result;
    }

    @Override
    public List<UserDTO> getListUser(int pageNo, int pageSize) {
        List<UserDTO> userDTOList = new ArrayList<>();
        Page<User> userPage = userRepository.findAll(PageRequest.of(pageNo - 1, pageSize));
        for (User u : userPage) {
            userDTOList.add(userMapper.toDto(u));
        }
        return userDTOList;
    }

    @Override
    public List<UserDTO> getSortListUserPaging(String field, int pageNo, int pageSize) {
        List<UserDTO> result = new ArrayList<>();
        Page<User> userPage = userRepository.findAll(PageRequest.of(pageNo - 1, pageSize).withSort(Sort.by(field)));
        for (User u : userPage) {
            result.add(userMapper.toDto(u));
        }
        return result;
    }

    @Override
    public List<UserDTO> getListUserByName(String name, int pageNo, int pageSize) {
        List<UserDTO> userDTOS = new ArrayList<>();
        Page<User> userPage = userRepository.findAllByNameContaining(name, PageRequest.of(pageNo - 1, pageSize));
        for (User u : userPage) {
            userDTOS.add(userMapper.toDto(u));
        }
        return userDTOS;
    }


}
