package com.ndanh.service.impl;

import com.ndanh.Mapper.DeptMapper;
import com.ndanh.dto.DepartmentDTO;
import com.ndanh.entity.Department;
import com.ndanh.exception.DuplicateIdException;
import com.ndanh.exception.NotFoundException;
import com.ndanh.repository.DepartmentRepository;
import com.ndanh.service.DeptService;
import jakarta.persistence.EntityNotFoundException;
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
    private Department department;

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

    @Override
    public DepartmentDTO deleteDept(int id) {
        try{
            Department department= departmentRepository.getById(id);
            departmentRepository.delete(department);

            if(department.getUsers().size()>0){
                throw new DuplicateIdException("Khong xoa duoc department nay");
            }

            return deptMapper.toDeptDTO( department);
        }catch (EntityNotFoundException ex){
            throw new NotFoundException("Department khong ton tai");
        }

    }
}
