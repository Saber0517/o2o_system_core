package com.oocl.jyhon.daoimple;

import com.oocl.jyhon.dao.EntityDao;
import com.oocl.jyhon.dao.FoodEntityDao;
import com.oocl.jyhon.entiy.FoodEntity;
import com.oocl.jyhon.entiy.UserEntity;
import com.oocl.jyhon.util.DBConnectUtil;
import com.oocl.jyhon.util.DBTableNameUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ZHANGJA4 on 8/5/2015.
 */
public class FoodEntityDaoImple implements FoodEntityDao {
    private final static String tableName = (DBTableNameUtil.getTableNameMap()).get("FoodEntity");
    private final static String foodIDSequence = "seq_foodId";
    private Connection con = null;
    private PreparedStatement pst = null;

    @Override
    public int addEntity(FoodEntity foodEntity) {
        String sql = "INSERT INTO " + tableName + "(FOODID,FOODNAME,PRICE,PICTURE_URL,TYPEID,USERID,STATUSID) VALUES (" + foodIDSequence + ".nextval" + ",?,?,?,?,?,?)";
        ResultSet rs = null;
        int result = 0;
        con = DBConnectUtil.getConnection();
        try {
            pst = con.prepareStatement(sql,new String[]{"FOODID"});
            pst.setString(1, foodEntity.getFoodName());
            pst.setDouble(2, foodEntity.getPrice());
            pst.setString(3, foodEntity.getPictureURL());
            pst.setInt(4, foodEntity.getTypeID());
            pst.setInt(5, foodEntity.getUserID());
            pst.setInt(6, foodEntity.getStatusID());
            result = pst.executeUpdate();
            rs = pst.getGeneratedKeys();
            if (rs.next()){
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
    public int updateEntity(FoodEntity foodEntity) {
        String sql = "UPDATE " + tableName + " SET FOODNAME=?,PRICE=?,PICTURE_URL=?,STATUSID=?,TYPEID=?,USERID=? WHERE FOODID=" + foodEntity.getFoodID();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int result = 0;
        try {
            con = DBConnectUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, foodEntity.getFoodName());
            pst.setDouble(2, foodEntity.getPrice());
            pst.setString(3, foodEntity.getPictureURL());
            pst.setInt(4, foodEntity.getStatusID());
            pst.setInt(5, foodEntity.getTypeID());
            pst.setInt(6, foodEntity.getUserID());
            result = pst.executeUpdate();
        } catch (SQLException e) {
            DBConnectUtil.free(con, pst, rs);
            e.printStackTrace();
        }

        return result;
    }

    public int updateFoodEntityPrice(Integer id, Double price) {
        String sql = "UPDATE " + tableName + " SET PRICE=?,STATUSID=3 WHERE FOODID=?";
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int result = 0;
        try {
            con = DBConnectUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setDouble(1, price);
            pst.setInt(2, id);
            result = pst.executeUpdate();
        } catch (SQLException e) {
            DBConnectUtil.free(con, pst, rs);
            e.printStackTrace();
        }
        return result;
    }




    @Override
    public int deleteEntity(FoodEntity foodEntity) {
        return 0;
    }

    @Override
    public FoodEntity loadEntity(int id) {
        return null;
    }

    @Override
    public List<FoodEntity> findAll() {
        List<FoodEntity> foodEntityList = new LinkedList<FoodEntity>();
        String sql = "select * from " + tableName;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = DBConnectUtil.getConnection();
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                FoodEntity foodEntity = new FoodEntity();
                foodEntity.setFoodID(rs.getInt("FOODID"));
                foodEntity.setFoodName(rs.getString("FOODNAME"));
                foodEntity.setUserID(rs.getInt("USERID"));
                foodEntity.setStatusID(rs.getInt("STATUSID"));
                foodEntity.setTypeID(rs.getInt("TYPEID"));
                foodEntity.setPrice(rs.getDouble("PRICE"));
                foodEntity.setPictureURL(rs.getString("PICTURE_URL"));
                foodEntityList.add(foodEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnectUtil.free(con, pst, rs);
        }

        return foodEntityList;
    }

    @Override
    public List<FoodEntity> findAll(int start, int len) {
        return null;
    }

    public List<FoodEntity> groupByTypeId(int typeId) {
        List<FoodEntity> foodEntityList = new LinkedList<FoodEntity>();
        String sql = "select * from " + tableName + " WHERE TYPEID=?";
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = DBConnectUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, typeId);
            rs = pst.executeQuery();
            while (rs.next()) {
                FoodEntity foodEntity = new FoodEntity();
                foodEntity.setFoodID(rs.getInt("FOODID"));
                foodEntity.setFoodName(rs.getString("FOODNAME"));
                foodEntity.setUserID(rs.getInt("USERID"));
                foodEntity.setStatusID(rs.getInt("STATUSID"));
                foodEntity.setTypeID(rs.getInt("TYPEID"));
                foodEntity.setPrice(rs.getDouble("PRICE"));
                foodEntity.setPictureURL(rs.getString("PICTURE_URL"));
                foodEntityList.add(foodEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnectUtil.free(con, pst, rs);
        }

        return foodEntityList;
    }

    @Override
    public int[] addEntitys(List<FoodEntity> FoodEntitys) {
        return new int[0];
    }

    public int deleteEntityByFoodId(Integer foodId, Integer userId) {
        String sql = "DELETE FROM " + tableName + " WHERE FOODID=? AND USERID=?";
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int result = 0;
        try {
            con = DBConnectUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, foodId);
            pst.setInt(2, userId);
            result = pst.executeUpdate();
            con.commit();
        } catch (SQLException e) {
            DBConnectUtil.free(con, pst, rs);
            e.printStackTrace();
        }
        return result;
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
    public FoodEntity verify(FoodEntity c) {
        return null;
    }

    @Override
    public int updateEntityStatus(FoodEntity foodEntity) {
        String sql = "UPDATE " + tableName + " SET STATUSID=? WHERE FOODID=?";
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int result = 0;
        try {
            con = DBConnectUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setDouble(1, foodEntity.getStatusID());
            pst.setInt(2, foodEntity.getFoodID());
            result = pst.executeUpdate();
        } catch (SQLException e) {
            DBConnectUtil.free(con, pst, rs);
            e.printStackTrace();
        }
        return result;
    }


}
