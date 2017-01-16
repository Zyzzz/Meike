package com.imudges.repository;

import com.imudges.model.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by zhangshuang on 2017/1/14.
 */
@Repository
public interface AdminRepository extends JpaRepository<AdminEntity,Integer> {
    public AdminEntity findByEmail(String email);
}
