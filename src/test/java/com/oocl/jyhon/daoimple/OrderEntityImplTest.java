package com.oocl.jyhon.daoimple;

import com.oocl.jyhon.dao.OrderEntityDao;
import com.oocl.jyhon.entiy.OrderEntity;
import org.junit.Test;

/**
 * Created by WhiteSaber on 15/8/15.
 */
public class OrderEntityImplTest {
    OrderEntityDao orderEntityDao = new OrderEntityDaoImpl();

    @Test
    public void test() {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setStatusId(3);
        orderEntity.setFoodId(1);
        orderEntityDao.addEntity(orderEntity);
    }
}
