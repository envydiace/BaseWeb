package com.ndanh.controller;

import com.ndanh.dto.DepartmentDTO;
import com.ndanh.entity.Department;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/department")
public interface DeptController {
    @GetMapping("")
    ResponseEntity<List<DepartmentDTO>> getAllDept();

    @GetMapping("/{id}")
    ResponseEntity<DepartmentDTO> getById(@PathVariable int id);

    @PostMapping("")
    ResponseEntity<DepartmentDTO> addDept(@RequestBody Department department);

    @DeleteMapping("/{id}")
    ResponseEntity<DepartmentDTO> deleteDept(@PathVariable int id);
}
