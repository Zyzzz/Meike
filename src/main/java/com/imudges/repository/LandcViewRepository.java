package com.imudges.repository;

import com.imudges.model.LandcviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Administrator on 2016/12/20.
 */
public interface LandcViewRepository extends JpaRepository<LandcviewEntity,Integer> {
    public List<LandcviewEntity> findBycid(int cid);
}
