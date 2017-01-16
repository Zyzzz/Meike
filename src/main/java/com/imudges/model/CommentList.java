package com.imudges.model;

import java.util.List;

/**
 * Created by cyy on 2017/1/16.
 */
public class CommentList extends BaseEntity {
    private List<EvaluateviewEntity> evaluateviewEntities;

    public List<EvaluateviewEntity> getEvaluateviewEntities() {
        return evaluateviewEntities;
    }

    public void setEvaluateviewEntities(List<EvaluateviewEntity> evaluateviewEntities) {
        this.evaluateviewEntities = evaluateviewEntities;
    }
}
