package com.oocl.jyhon.entiy;

import java.io.Serializable;

/**
 * Created by ZHANGJA4 on 8/5/2015.
 */
public class StatusEntity implements Serializable {
    private Integer statusID;
    private String statusName;

    @Override
    public boolean equals(Object o) {
        
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StatusEntity that = (StatusEntity) o;

        if (statusID != null ? !statusID.equals(that.statusID) : that.statusID != null) return false;
        return !(statusName != null ? !statusName.equals(that.statusName) : that.statusName != null);

    }

    @Override
    public int hashCode() {
        int result = statusID != null ? statusID.hashCode() : 0;
        result = 31 * result + (statusName != null ? statusName.hashCode() : 0);
        return result;
    }

    public Integer getStatusID() {

        return statusID;
    }

    public void setStatusID(Integer statusID) {
        this.statusID = statusID;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}
