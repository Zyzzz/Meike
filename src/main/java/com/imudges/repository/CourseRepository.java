package com.imudges.repository;

import com.imudges.model.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2016/12/19.
 */
@Repository
public interface CourseRepository extends JpaRepository<CourseEntity,Integer> {
    List<CourseEntity> findByOrganizationid(int organization);
    @Query("select id,name,type,lessonNumber,organizationid,description from CourseEntity where name like ?1")
    List<CourseEntity> findByName(String name);
    @Query("select distinct type from CourseEntity where organizationid=?1")
    List<String> findTypeByOrgaizationid(int organizationid);
}
