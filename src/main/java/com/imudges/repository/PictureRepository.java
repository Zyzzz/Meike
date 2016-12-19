package com.imudges.repository;

import com.imudges.model.PictureEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2016/12/19.
 */
public interface PictureRepository  extends JpaRepository<PictureEntity,Integer> {
}
