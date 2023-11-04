package com.ndanh.dto.request.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddUserRequest {
    private String username;
    private String name;
    private Integer age;
    private Boolean gender;
    private Integer departmentId;
}
