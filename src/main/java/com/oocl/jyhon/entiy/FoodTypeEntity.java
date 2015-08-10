package com.oocl.jyhon.entiy;

import java.io.Serializable;

/**
 * Created by ZHANGJA4 on 8/6/2015.
 */
public class FoodTypeEntity implements Serializable {
    private Integer foodTypeID;
    private String foodTypeName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodTypeEntity that = (FoodTypeEntity) o;
        if (foodTypeID != null ? !foodTypeID.equals(that.foodTypeID) : that.foodTypeID != null) return false;
        return !(foodTypeName != null ? !foodTypeName.equals(that.foodTypeName) : that.foodTypeName != null);

    }

    @Override
    public int hashCode() {
        int result = foodTypeID != null ? foodTypeID.hashCode() : 0;
        result = 31 * result + (foodTypeName != null ? foodTypeName.hashCode() : 0);
        return result;
    }

    public Integer getFoodTypeID() {
        return foodTypeID;
    }

    public void setFoodTypeID(Integer foodTypeID) {
        this.foodTypeID = foodTypeID;
    }

    public String getFoodTypeName() {
        return foodTypeName;
    }

    public void setFoodTypeName(String foodTypeName) {
        this.foodTypeName = foodTypeName;
    }
}
