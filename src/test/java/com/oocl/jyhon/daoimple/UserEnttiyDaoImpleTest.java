package com.oocl.jyhon.daoimple;

import com.oocl.jyhon.dao.UserEntityDao;
import com.oocl.jyhon.entiy.FoodEntity;
import com.oocl.jyhon.entiy.UserEntity;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by ZHANGJA4 on 8/5/2015.
 */
public class UserEnttiyDaoImpleTest {
    private static UserEntityDao userEntityDaoImple;

    @Before
    public void before() {
        userEntityDaoImple = new UserEntityDaoImple();
    }

    @Test
    public void testInsert() {
        UserEntity userEntity = new UserEntity();
        userEntity.setIdCard("");
        userEntity.setLicense("");
        userEntity.setPassword("123");
        userEntity.setRole("admin");
        userEntity.setTel("88888");
        userEntity.setUserName("jason");
        userEntity.setStatusId(1);
        userEntityDaoImple.addEntity(userEntity);
    }

    @Test
    public void testUpdate() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserID(1111);
        userEntity.setIdCard("1");
        userEntity.setLicense("1");
        userEntity.setPassword("321");
        userEntity.setRole("cutsomer");
        userEntity.setTel("777");
        userEntity.setUserName("james");
        userEntity.setStatusId(2);
        userEntityDaoImple.updateEntity(userEntity);
    }

    @Test
    public void testFindAll() {
//        List<FoodEntity> foodEntityList = userEntityDaoImple.
//        return;
    }
}
