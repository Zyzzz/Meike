package com.imudges.repository;

import com.imudges.model.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/12/19.
 */
@Repository
public interface CourseRepository extends JpaRepository<CourseEntity,Integer> {
}
