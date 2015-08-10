package com.oocl.jyhon.daoimple;

import com.oocl.jyhon.dao.EntityDao;
import com.oocl.jyhon.entiy.PackageEntity;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by ZHANGJA4 on 8/6/2015.
 */
public class PackageEntityDaoImpleTest {

    private static EntityDao EntityDaoImple;
    @Before
    public void  before(){
        EntityDaoImple  = new PackageEntityDaoImple();
    }

    @Test
    public void testInsert(){
        PackageEntity packageEntity =new PackageEntity();
        packageEntity.setPackageName("testPackaneme");
        packageEntity.setPrice(123.2);
        packageEntity.setStatusID(1);
        packageEntity.setUserID(1);
        EntityDaoImple.addEntity(packageEntity);
    }
    @Test
    public void testUpdate(){
        PackageEntity packageEntity =new PackageEntity();
        packageEntity.setPackageID(1);
        packageEntity.setPackageName("testAgain");
        packageEntity.setPrice(200.0);
        packageEntity.setStatusID(5);
        packageEntity.setUserID(5);
        EntityDaoImple.updateEntity(packageEntity);
    }

    @Test
    public void testFindAll(){
        List<PackageEntity> packageEntityList = EntityDaoImple.findAll();
        return;
    }
}
