package com.oocl.jyhon.daoimple;

import com.oocl.jyhon.entiy.FoodEntity;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by ZHANGJA4 on 8/5/2015.
 */
public class FoodEntityDaoImpleTest {
    private static FoodEntityDaoImple foodEntityDaoImple;
    @Before
    public void  before(){
        foodEntityDaoImple  = new FoodEntityDaoImple();
    }

    @Test
        public void testInsert(){
        FoodEntity foodEntity =new FoodEntity();
        foodEntity.setFoodName("child");
        foodEntity.setPictureURL("");
        foodEntity.setPrice(123.2);
        foodEntity.setStatusID(1);
        foodEntity.setUserID(5);
        foodEntity.setTypeID(1);
        foodEntityDaoImple.addEntity(foodEntity);
    }
    @Test
    public void testUpdate(){
        FoodEntity foodEntity =new FoodEntity();
        foodEntity.setFoodID(46);
        foodEntity.setFoodName("sea");
        foodEntity.setPictureURL("");
        foodEntity.setPrice(200.0);
        foodEntity.setStatusID(5);
        foodEntity.setUserID(5);
        foodEntity.setTypeID(5);
        foodEntityDaoImple.updateEntity(foodEntity);
    }

    @Test
    public void testFindAll(){
        List<FoodEntity> foodEntityList = foodEntityDaoImple.findAll();
        return;
    }
}
