package com.imudges.model;

import com.imudges.utils.Information;

/**
 * Created by Administrator on 2016/12/10.
 */
public class BaseEntity {
    protected String result;
    protected int status;
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
        setResult(Information.getInstance().getErrorInfo(status));
    }
}
