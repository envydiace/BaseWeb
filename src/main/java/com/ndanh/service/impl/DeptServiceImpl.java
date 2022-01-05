package com.ndanh.service.impl;

import com.ndanh.Mapper.DeptMapper;
import com.ndanh.controller.exception.DuplicateIdException;
import com.ndanh.dto.DepartmentDTO;
import com.ndanh.entity.Department;
import com.ndanh.entity.User;
import com.ndanh.repository.DepartmentRepository;
import com.ndanh.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class DeptServiceImpl implements DeptService {
    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    DeptMapper deptMapper;

    @Override
    public List<DepartmentDTO> getAllDept() {
        List<DepartmentDTO> result = new ArrayList<>();
        List<Department> departments = departmentRepository.findAll();
        for(Department d:departments){
           result.add( deptMapper.toDeptDTO(d));
        }
        return result;
    }

    @Override
    public DepartmentDTO getById(int id) {
        return null;
    }

    @Override
    public DepartmentDTO createDept(Department department) {
        for(Department d :departmentRepository.findAll()){
            if(d.getDepName().equals(department.getDepName())){
                throw new DuplicateIdException("Ten Department khong hop le");
            }
        }
        return deptMapper.toDeptDTO( departmentRepository.save(department));
    }
}
