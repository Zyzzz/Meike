package com.imudges.repository;

import com.imudges.model.PictureEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Administrator on 2016/12/19.
 */
public interface PictureRepository  extends JpaRepository<PictureEntity,Integer> {
    public List<PictureEntity> findByPattern(int pattern);
    public PictureEntity findByPatternAndOtherid(int pattern,int otherid);
}
