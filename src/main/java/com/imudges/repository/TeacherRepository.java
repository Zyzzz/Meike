package com.imudges.repository;

import com.imudges.model.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2016/12/19.
 */
public interface TeacherRepository extends JpaRepository<TeacherEntity,Integer> {
}
