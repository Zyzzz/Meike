package com.imudges.repository;

import com.imudges.model.LandcviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2016/12/20.
 */
@Repository
public interface LandcViewRepository extends JpaRepository<LandcviewEntity,Integer> {
    public List<LandcviewEntity> findBycid(int cid);
}
