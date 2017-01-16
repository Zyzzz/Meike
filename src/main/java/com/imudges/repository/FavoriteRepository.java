package com.imudges.repository;

import com.imudges.model.FavoriteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by cyy on 2017/1/16.
 */
public interface FavoriteRepository extends JpaRepository<FavoriteEntity,Integer>{
}
