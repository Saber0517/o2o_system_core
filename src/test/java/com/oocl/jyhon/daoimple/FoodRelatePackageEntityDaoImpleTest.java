package com.oocl.jyhon.daoimple;

import com.oocl.jyhon.dao.EntityDao;
import com.oocl.jyhon.entiy.FoodEntity;
import com.oocl.jyhon.entiy.FoodRelatePackageEntity;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by ZHANGJA4 on 8/6/2015.
 */
public class FoodRelatePackageEntityDaoImpleTest {
    private static EntityDao entityDao;
    @Before
    public void  before(){
        entityDao = new FoodRelatePackageEntityDaoImple();
    }

    @Test
    public void testInsert(){
        FoodRelatePackageEntity foodRelatePackageEntity =new FoodRelatePackageEntity();
        foodRelatePackageEntity.setPackageID(1);
        foodRelatePackageEntity.setFoodID(3);
        entityDao.addEntity(foodRelatePackageEntity);
    }
    @Test
    public void testDelete(){
        FoodRelatePackageEntity foodRelatePackageEntity =new FoodRelatePackageEntity();
        foodRelatePackageEntity.setFoodID(2);
        foodRelatePackageEntity.setPackageID(1);
        entityDao.deleteEntity(foodRelatePackageEntity);
    }

    @Test
    public void testFindAll(){
        List<FoodEntity> foodEntityList = entityDao.findAll();
        return;
    }
}
