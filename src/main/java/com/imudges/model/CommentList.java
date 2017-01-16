package com.imudges.model;

import java.util.List;

/**
 * Created by cyy on 2017/1/16.
 */
public class CommentList extends BaseEntity {
    private List<EandsviewEntity> eandsviewEntities;

    public List<EandsviewEntity> getEandsviewEntities() {
        return eandsviewEntities;
    }

    public void setEandsviewEntities(List<EandsviewEntity> eandsviewEntities) {
        this.eandsviewEntities = eandsviewEntities;
    }
}
