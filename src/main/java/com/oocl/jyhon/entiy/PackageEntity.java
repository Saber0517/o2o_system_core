package com.oocl.jyhon.entiy;

import java.io.Serializable;

/**
 * 套餐表对应实体类
 * Created by ZHANGJA4 on 8/5/2015.
 */
public class PackageEntity implements Serializable {

    private Integer packageID;
    private String packageName;
    private Double price;
    private Integer statusID;
    private Integer userID;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PackageEntity that = (PackageEntity) o;

        if (packageID != null ? !packageID.equals(that.packageID) : that.packageID != null) return false;
        if (packageName != null ? !packageName.equals(that.packageName) : that.packageName != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (statusID != null ? !statusID.equals(that.statusID) : that.statusID != null) return false;
        return !(userID != null ? !userID.equals(that.userID) : that.userID != null);

    }

    @Override
    public int hashCode() {
        int result = packageID != null ? packageID.hashCode() : 0;
        result = 31 * result + (packageName != null ? packageName.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (statusID != null ? statusID.hashCode() : 0);
        result = 31 * result + (userID != null ? userID.hashCode() : 0);
        return result;
    }

    public Integer getPackageID() {
        return packageID;
    }

    public void setPackageID(Integer packageID) {
        this.packageID = packageID;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStatusID() {
        return statusID;
    }

    public void setStatusID(Integer statusID) {
        this.statusID = statusID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }
}
