package com.ndanh.service;

import com.ndanh.dto.UserDTO;
import com.ndanh.dto.request.user.AddUserRequest;
import com.ndanh.dto.request.user.EditUserRequest;
import com.ndanh.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<UserDTO> getAllUser();
    UserDTO getUserById(int id);
    UserDTO createUser(AddUserRequest request);
    UserDTO deleteUser(int id);
    UserDTO updateUser(EditUserRequest request);
    List<UserDTO> searchByName(String name);
    List<UserDTO> getSortListUser(String field);
    List<UserDTO> getListUser(int pageNo, int pageSize );
    List<UserDTO> getSortListUserPaging(String field,int pageNo, int pageSize);
    List<UserDTO> getListUserByName(String name, int pageNo, int pageSize );

}
