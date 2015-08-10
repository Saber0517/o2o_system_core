package com.oocl.jyhon.daoimple;

import com.oocl.jyhon.dao.FoodRelatePackageEntityDao;
import com.oocl.jyhon.entiy.FoodRelatePackageEntity;
import com.oocl.jyhon.entiy.UserEntity;
import com.oocl.jyhon.util.DBConnectUtil;
import com.oocl.jyhon.util.DBTableNameUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by ZHANGJA4 on 8/6/2015.
 */
public class FoodRelatePackageEntityDaoImple implements FoodRelatePackageEntityDao {
    private final static String tableName = (DBTableNameUtil.getTableNameMap()).get("FoodRealatePackageEntity");
    private final static String packageIDSequence = "seq_packageId";
    private Connection con = null;
    private PreparedStatement pst = null;

    @Override
    public int addEntity(FoodRelatePackageEntity Entity) {
        String sql = "INSERT INTO " + tableName + "(FOODID,PACKAGEID) VALUES (?,?)";
        ResultSet rs = null;
        int result = 0;
        try {
            con = DBConnectUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, Entity.getFoodID());
            pst.setInt(2, Entity.getPackageID());
            result = pst.executeUpdate();
            con.commit();
        } catch (SQLException e) {
            DBConnectUtil.free(con, pst, rs);
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int updateEntity(FoodRelatePackageEntity entity) {
        return 0;
    }



    @Override
    public int deleteEntity(FoodRelatePackageEntity entity) {
        String sql = "DELETE FROM " + tableName + " WHERE FOODID=? AND PACKAGEID=?";
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int result = 0;
        try {
            con = DBConnectUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, entity.getFoodID());
            pst.setInt(2, entity.getPackageID());
            result = pst.executeUpdate();

        } catch (SQLException e) {
            DBConnectUtil.free(con, pst, rs);
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public FoodRelatePackageEntity loadEntity(int id) {
        return null;
    }

    @Override
    public List<FoodRelatePackageEntity> findAll() {
        return null;
    }

    @Override
    public List<FoodRelatePackageEntity> findAll(int start, int len) {
        return null;
    }

    @Override
    public int[] addEntitys(List<FoodRelatePackageEntity> entitys) {
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
    public FoodRelatePackageEntity verify(FoodRelatePackageEntity c) {
        return null;
    }


}
