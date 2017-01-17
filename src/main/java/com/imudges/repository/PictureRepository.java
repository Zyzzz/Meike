package com.imudges.repository;

import com.imudges.model.PictureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2016/12/19.
 */
@Repository
public interface PictureRepository  extends JpaRepository<PictureEntity,Integer> {
    public List<PictureEntity> findByPattern(int pattern);
    public PictureEntity findByPatternAndOtherid(int pattern,int otherid);
}
