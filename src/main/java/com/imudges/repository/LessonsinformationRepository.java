package com.imudges.repository;

import com.imudges.model.LessonsinformationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/1/14.
 */
@Repository
public interface LessonsinformationRepository  extends JpaRepository<LessonsinformationEntity,Integer> {
}
