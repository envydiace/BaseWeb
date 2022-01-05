package com.ndanh.service;

import com.ndanh.dto.DepartmentDTO;
import com.ndanh.entity.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DeptService {
    List<DepartmentDTO> getAllDept();
    DepartmentDTO getById(int id);
    DepartmentDTO createDept(Department department);

}
