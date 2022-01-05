package com.ndanh.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="userId",unique = true,nullable = false)
    private int id;

    @Column(name="username",unique = true,nullable = false)
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="name")
    private String name;

    @Column(name="age")
    private int age;

    @Column(name="gender")
    private boolean gender;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department department;

}
