package com.imudges.repository;

import com.imudges.model.VideoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/1/15.
 */
@Repository
public interface VideoRepository extends JpaRepository<VideoEntity,Integer> {
    public VideoEntity findByUrl(String url);
}
