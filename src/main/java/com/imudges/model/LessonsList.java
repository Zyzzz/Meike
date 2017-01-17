package com.imudges.model;

import java.util.List;

/**
 * Created by Administrator on 2017/1/15.
 */
public class LessonsList extends BaseEntity{
    private List<LandcviewEntity> landcviewEntities;
    private PictureEntity pictureEntity;
    private OrganizationEntity organizationEntity;
    private PictureEntity oPictureEntity;

    public OrganizationEntity getOrganizationEntity() {
        return organizationEntity;
    }

    public void setOrganizationEntity(OrganizationEntity organizationEntity) {
        this.organizationEntity = organizationEntity;
    }

    public PictureEntity getoPictureEntity() {
        return oPictureEntity;
    }

    public void setoPictureEntity(PictureEntity oPictureEntity) {
        this.oPictureEntity = oPictureEntity;
    }

    public List<LandcviewEntity> getLandcviewEntities() {
        return landcviewEntities;
    }

    public void setLandcviewEntities(List<LandcviewEntity> landcviewEntities) {
        this.landcviewEntities = landcviewEntities;
    }



    public PictureEntity getPictureEntity() {
        return pictureEntity;
    }

    public void setPictureEntity(PictureEntity pictureEntity) {
        this.pictureEntity = pictureEntity;
    }

}
