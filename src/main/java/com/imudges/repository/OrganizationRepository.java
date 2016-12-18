package com.imudges.repository;

import com.imudges.model.OrganizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/12/10.
 */
@Repository
public interface OrganizationRepository  extends JpaRepository<OrganizationEntity,Integer> {
    public OrganizationEntity findByEmail(String email);
    public OrganizationEntity findByCookie(String cookie);
}
