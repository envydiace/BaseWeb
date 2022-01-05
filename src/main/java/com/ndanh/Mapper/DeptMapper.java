package com.ndanh.Mapper;

import com.ndanh.dto.DepartmentDTO;
import com.ndanh.entity.Department;
import com.ndanh.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeptMapper {
    @Autowired
    DepartmentRepository repository;

    public DepartmentDTO toDeptDTO(Department department){
        DepartmentDTO departmentDTO = new DepartmentDTO(department.getDepId(),department.getDepName(),department.getUsers().size());
        return departmentDTO;
    }
}
