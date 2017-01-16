package com.imudges.repository;

import com.imudges.model.EvaluateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by cyy on 2017/1/15.
 */
@Repository
public interface EvaluateRepository extends JpaRepository<EvaluateEntity,Integer> {
}
