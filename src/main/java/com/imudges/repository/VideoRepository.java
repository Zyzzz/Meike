package com.imudges.repository;

import com.imudges.model.VideoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2017/1/15.
 */
public interface VideoRepository extends JpaRepository<VideoEntity,Integer> {
    public VideoEntity findByUrl(String url);
}
