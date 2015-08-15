package com.oocl.jyhon.daoimple;

import com.oocl.jyhon.dao.OrderEntityDao;
import com.oocl.jyhon.entiy.OrderEntity;
import com.oocl.jyhon.util.DBConnectUtil;
import com.oocl.jyhon.util.DBTableNameUtil;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by WhiteSaber on 15/8/15.
 */
public class OrderEntityDaoImpl implements OrderEntityDao {
    private final static String tableName = (DBTableNameUtil.getTableNameMap()).get("ORDER");
    private final static String orderIDSequence = "seq_orderID";
    private Connection con = null;
    private PreparedStatement pst = null;


    @Override
    public int addEntity(OrderEntity orderEntity) {
        String sql = "INSERT INTO " + tableName + "(ORDERID,FOODID,STATUSID,ORDERTIME) VALUES (" + orderIDSequence + ".nextval" + ",?,?,?)";
        ResultSet rs = null;
        int result = 0;
        con = DBConnectUtil.getConnection();
        try {
            pst = con.prepareStatement(sql, new String[]{"ORDERID"});
            pst.setInt(1, orderEntity.getFoodId());
            pst.setInt(2, orderEntity.getStatusId());
            pst.setDate(3, new java.sql.Date(new Date().getTime()));
            result = pst.executeUpdate();
            rs = pst.getGeneratedKeys();
            if (rs.next()) {
                result = rs.getInt(1);
            }
            con.commit();
        } catch (SQLException e) {
            DBConnectUtil.free(con, pst, rs);
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int updateEntity(OrderEntity entity) {
        return 0;
    }

    @Override
    public int deleteEntity(OrderEntity entity) {
        return 0;
    }

    @Override
    public OrderEntity loadEntity(int id) {
        return null;
    }

    @Override
    public List<OrderEntity> findAll() {
        return null;
    }

    @Override
    public List<OrderEntity> findAll(int start, int len) {
        return null;
    }

    @Override
    public int[] addEntitys(List<OrderEntity> entitys) {
        return new int[0];
    }

    @Override
    public int deleteEntityByIndex(int i) {
        return 0;
    }

    @Override
    public int[] deleteEntityByIndexArray(int[] i) {
        return new int[0];
    }

    @Override
    public OrderEntity verify(OrderEntity c) {
        return null;
    }
}
