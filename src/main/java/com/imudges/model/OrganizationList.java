package com.imudges.model;

import java.util.List;

/**
 * Created by zhangshuang on 2017/1/14.
 */
public class OrganizationList extends BaseEntity {

    private List<OrganizationEntity> organizationEntityList;

    public List<OrganizationEntity> getOrganizationEntityList() {
        return organizationEntityList;
    }

    public void setOrganizationEntityList(List<OrganizationEntity> organizationEntityList) {
        this.organizationEntityList = organizationEntityList;
    }
}
