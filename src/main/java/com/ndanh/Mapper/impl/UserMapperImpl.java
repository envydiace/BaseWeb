package com.ndanh.Mapper.impl;

import com.ndanh.Mapper.UserMapper;
import com.ndanh.dto.UserDTO;
import com.ndanh.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class UserMapperImpl implements UserMapper {

    @Autowired
    private ModelMapper modelMapper;

    public UserDTO toDto(User user) {
        UserDTO dto = modelMapper.map(user, UserDTO.class);
        dto.setDepartmentId(!Objects.isNull(user.getDepartment())? user.getDepartment().getDepId() : 0);
        dto.setDepartmentName(!Objects.isNull(user.getDepartment())? user.getDepartment().getDepName() : null);
        return dto;
    }

    @Override
    public User toEntity(UserDTO dto) {
        return null;
    }

    @Override
    public List<UserDTO> toDto(List<User> entityList) {
        return null;
    }

    @Override
    public List<User> toEntity(List<UserDTO> dtoList) {
        return null;
    }


}
