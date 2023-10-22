package com.ndanh.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "department")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Department implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "depId",unique = true,nullable = false)
    private int depId;

    @Column(name = "dept_name")
    private String depName;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "department")
    private List<User> users = new ArrayList<>();

}
