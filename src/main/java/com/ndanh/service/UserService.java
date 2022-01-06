package com.ndanh.service;

import com.ndanh.dto.UserDTO;
import com.ndanh.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<UserDTO> getAllUser();
    UserDTO getUserById(int id);
    UserDTO createUser(User user);
    UserDTO deleteUser(int id);
    UserDTO updateUser(User user,int id);
    List<UserDTO> searchByName(String name);
    List<UserDTO> getSortListUser(String field);
    List<UserDTO> getListUser(int pageNo, int pageSize );
    List<UserDTO> getSortListUserPaging(String field,int pageNo, int pageSize);
    List<UserDTO> getListUserByName(String name, int pageNo, int pageSize );

}
