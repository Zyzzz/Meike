package com.imudges.repository;

import com.imudges.model.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/12/9.
 */
@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Integer> {
    public StudentEntity findByEmail(String email);
    public StudentEntity findByCookie(String cookie);
}
