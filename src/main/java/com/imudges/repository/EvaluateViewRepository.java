package com.imudges.repository;

import com.imudges.model.EvaluateviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/1/16.
 */
@Repository
public interface EvaluateViewRepository extends JpaRepository<EvaluateviewEntity,Integer> {
    public List<EvaluateviewEntity> findBycid(int cid);
}
