package com.imudges.repository;

import com.imudges.model.LessonsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Administrator on 2017/1/15.
 */
public interface LessonsRepository extends JpaRepository<LessonsEntity,Integer> {
    public List<LessonsEntity> findBycourseId(int courseId);
}
