package com.oocl.jyhon.daoimple;

import com.oocl.jyhon.dao.FoodTypeEntityDao;
import com.oocl.jyhon.dao.StatusEntityDao;
import com.oocl.jyhon.entiy.FoodEntity;
import com.oocl.jyhon.entiy.FoodTypeEntity;
import com.oocl.jyhon.entiy.StatusEntity;
import com.oocl.jyhon.entiy.UserEntity;
import com.oocl.jyhon.util.DBConnectUtil;
import com.oocl.jyhon.util.DBTableNameUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ZHANGJA4 on 8/5/2015.
 */
public class FoodTypeEntityDaoImple implements FoodTypeEntityDao {
    private final static String tableName = (DBTableNameUtil.getTableNameMap()).get("FoodTypeEntity");
    private Connection con = null;
    private PreparedStatement pst = null;


    @Override
    public int addEntity(FoodTypeEntity Entity) {
        return 0;
    }

    @Override
    public int updateEntity(FoodTypeEntity entity) {
        return 0;
    }

    @Override
    public int deleteEntity(FoodTypeEntity entity) {
        return 0;
    }


    @Override
    public List<FoodTypeEntity> findAll() {
        List<FoodTypeEntity> foodTypeEntityList = new LinkedList<FoodTypeEntity>();
        String sql = "select * from " + tableName;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = DBConnectUtil.getConnection();
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                FoodTypeEntity foodTypeEntity = new FoodTypeEntity();
                foodTypeEntity.setFoodTypeID(rs.getInt("FOODTYPEID"));
                foodTypeEntity.setFoodTypeName(rs.getString("FOODTYPENAME"));
                foodTypeEntityList.add(foodTypeEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnectUtil.free(con, pst, rs);
        }
        return foodTypeEntityList;
    }

    @Override
    public FoodTypeEntity loadEntity(int id) {
        return null;
    }

    @Override
    public List<FoodTypeEntity> findAll(int start, int len) {
        return null;
    }

    @Override
    public int[] addEntitys(List<FoodTypeEntity> entitys) {
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
    public FoodTypeEntity verify(FoodTypeEntity c) {
        return null;
    }


}
