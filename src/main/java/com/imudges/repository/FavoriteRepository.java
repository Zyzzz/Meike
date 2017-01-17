package com.imudges.repository;

import com.imudges.model.FavoriteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by cyy on 2017/1/16.
 */
@Repository
public interface FavoriteRepository extends JpaRepository<FavoriteEntity,Integer>{
    public FavoriteEntity findByCourseidAndStudentid(int courseid,int studentid);
}
