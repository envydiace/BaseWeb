package com.ndanh.dto;

import com.ndanh.entity.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private int id;
    private String username;
    private String name;
    private int age;
    private boolean gender;
    private int departmentId;
    private String departmentName;
}
