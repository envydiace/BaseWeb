package com.ndanh.repository;

import com.ndanh.dto.UserDTO;
import com.ndanh.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    @Query("select u from User u where u.name like %:name%" )
    List<User> searchByName(@Param(value = "name") String name);

    Page<User> findAllByNameContaining(String name , Pageable pageable);
    Page<User> findAllByAgeContaining(String name , Pageable pageable);


//    @Transactional
//    @Modifying
//    @Query(value = "insert into baseweb.department_users (department_dep_id,users_user_id) values (:did,:uid)",nativeQuery = true)
//    void addRel(@Param(value = "did")int did, @Param(value = "uid") int uid);

}
