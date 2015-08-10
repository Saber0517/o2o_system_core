package com.oocl.jyhon.entiy;

import java.io.Serializable;

/**
 * ????????????????
 * Created by ZHANGJA4 on 8/5/2015.
 */
public class FoodEntity implements Serializable {

    private Integer foodID;
    private String foodName;
    private Double price;
    private String pictureURL;//???????????
    private Integer statusID;//???Status?
    private Integer typeID;//???? ????
    private Integer userID;//???? ???

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FoodEntity that = (FoodEntity) o;

        if (foodID != null ? !foodID.equals(that.foodID) : that.foodID != null) return false;
        if (foodName != null ? !foodName.equals(that.foodName) : that.foodName != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (pictureURL != null ? !pictureURL.equals(that.pictureURL) : that.pictureURL != null) return false;
        if (statusID != null ? !statusID.equals(that.statusID) : that.statusID != null) return false;
        if (typeID != null ? !typeID.equals(that.typeID) : that.typeID != null) return false;
        return !(userID != null ? !userID.equals(that.userID) : that.userID != null);

    }

    @Override
    public int hashCode() {
        int result = foodID != null ? foodID.hashCode() : 0;
        result = 31 * result + (foodName != null ? foodName.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (pictureURL != null ? pictureURL.hashCode() : 0);
        result = 31 * result + (statusID != null ? statusID.hashCode() : 0);
        result = 31 * result + (typeID != null ? typeID.hashCode() : 0);
        result = 31 * result + (userID != null ? userID.hashCode() : 0);
        return result;
    }

    public Integer getFoodID() {
        return foodID;
    }

    public void setFoodID(Integer foodID) {
        this.foodID = foodID;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public Integer getStatusID() {
        return statusID;
    }

    public void setStatusID(Integer statusID) {
        this.statusID = statusID;
    }

    public Integer getTypeID() {
        return typeID;
    }

    public void setTypeID(Integer typeID) {
        this.typeID = typeID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }
}
