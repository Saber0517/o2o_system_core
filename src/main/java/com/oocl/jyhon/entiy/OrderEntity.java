package com.oocl.jyhon.entiy;

import com.sun.tools.corba.se.idl.InterfaceGen;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by WhiteSaber on 15/8/15.
 */
public class OrderEntity implements Serializable {
    Integer OrderId;
    Integer FoodId;
    Integer StatusId;
    Date date;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderEntity that = (OrderEntity) o;

        if (OrderId != null ? !OrderId.equals(that.OrderId) : that.OrderId != null) return false;
        if (FoodId != null ? !FoodId.equals(that.FoodId) : that.FoodId != null) return false;
        if (StatusId != null ? !StatusId.equals(that.StatusId) : that.StatusId != null) return false;
        return !(date != null ? !date.equals(that.date) : that.date != null);

    }

    @Override
    public int hashCode() {
        int result = OrderId != null ? OrderId.hashCode() : 0;
        result = 31 * result + (FoodId != null ? FoodId.hashCode() : 0);
        result = 31 * result + (StatusId != null ? StatusId.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    public Integer getOrderId() {
        return OrderId;
    }

    public void setOrderId(Integer orderId) {
        OrderId = orderId;
    }

    public Integer getFoodId() {
        return FoodId;
    }

    public void setFoodId(Integer foodId) {
        FoodId = foodId;
    }

    public Integer getStatusId() {
        return StatusId;
    }

    public void setStatusId(Integer statusId) {
        StatusId = statusId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
