package com.imudges.repository;

import com.imudges.model.LessonsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/1/15.
 */
@Repository
public interface LessonsRepository extends JpaRepository<LessonsEntity,Integer> {
    public List<LessonsEntity> findBycourseId(int courseId);
}
