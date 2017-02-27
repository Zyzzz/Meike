package com.imudges.repository;

import com.imudges.model.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2016/12/19.
 */
@Repository
public interface TeacherRepository extends JpaRepository<TeacherEntity,Integer> {
    public List<TeacherEntity> findByOrganizationid(int organizationid);
}
