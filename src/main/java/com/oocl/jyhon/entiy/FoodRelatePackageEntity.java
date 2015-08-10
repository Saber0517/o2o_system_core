package com.oocl.jyhon.entiy;

import java.io.Serializable;

/**
 * 套餐-菜名关联表
 * Created by ZHANGJA4 on 8/5/2015.
 */
public class FoodRelatePackageEntity implements Serializable {
    private Integer packageID;
    private Integer foodID;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FoodRelatePackageEntity that = (FoodRelatePackageEntity) o;

        if (packageID != null ? !packageID.equals(that.packageID) : that.packageID != null) return false;
        return !(foodID != null ? !foodID.equals(that.foodID) : that.foodID != null);

    }

    @Override
    public int hashCode() {
        int result = packageID != null ? packageID.hashCode() : 0;
        result = 31 * result + (foodID != null ? foodID.hashCode() : 0);
        return result;
    }

    public Integer getPackageID() {
        return packageID;
    }

    public void setPackageID(Integer packageID) {
        this.packageID = packageID;
    }

    public Integer getFoodID() {
        return foodID;
    }

    public void setFoodID(Integer foodID) {
        this.foodID = foodID;
    }
}
