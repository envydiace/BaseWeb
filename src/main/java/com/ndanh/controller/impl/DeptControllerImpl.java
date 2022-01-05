package com.ndanh.controller.impl;

import com.ndanh.controller.DeptController;
import com.ndanh.dto.DepartmentDTO;
import com.ndanh.entity.Department;
import com.ndanh.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Access;
import java.util.List;
@RestController
public class DeptControllerImpl implements DeptController {

    @Autowired
    DeptService deptService;

    @Override
    public ResponseEntity<List<DepartmentDTO>> getAllDept() {
        return ResponseEntity.ok(deptService.getAllDept()) ;
    }

    @Override
    public ResponseEntity<DepartmentDTO> getById(int id) {
        return ResponseEntity.ok(deptService.getById(id));
    }

    @Override
    public ResponseEntity<DepartmentDTO> addDept(Department department) {
        return ResponseEntity.ok(deptService.createDept(department));
    }

    @Override
    public ResponseEntity<DepartmentDTO> deleteDept(int id) {
        return ResponseEntity.ok(deptService.deleteDept(id));
    }
}
