package com.imudges.repository;

import com.imudges.model.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zhangshuang on 2017/1/14.
 */
public interface AdminRepository extends JpaRepository<AdminEntity,Integer> {
    public AdminEntity findByEmail(String email);
}
