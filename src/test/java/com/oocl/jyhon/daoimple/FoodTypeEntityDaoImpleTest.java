package com.oocl.jyhon.daoimple;

import com.oocl.jyhon.dao.EntityDao;
import com.oocl.jyhon.entiy.FoodTypeEntity;
import org.junit.Before;
import org.junit.Test;


import java.util.List;

/**
 * Created by ZHANGJA4 on 8/5/2015.
 */
public class FoodTypeEntityDaoImpleTest {
    private static EntityDao entityDao;

    @Before
    public void before() {
        entityDao = new FoodTypeEntityDaoImple();
    }


    @Test
    public void testFindAll() {
        List<FoodTypeEntity> foodTypeEntityList = entityDao.findAll();
        return;
    }
}
