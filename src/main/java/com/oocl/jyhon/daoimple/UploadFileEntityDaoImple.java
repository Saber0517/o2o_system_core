package com.oocl.jyhon.daoimple;

import com.oocl.jyhon.dao.UploadFileEntityDao;
import com.oocl.jyhon.entiy.FoodEntity;
import com.oocl.jyhon.util.DBConnectUtil;
import com.oocl.jyhon.util.DBTableNameUtil;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by WhiteSaber on 15/8/9.
 */
public class UploadFileEntityDaoImple implements UploadFileEntityDao {
    private final static String tableName = (DBTableNameUtil.getTableNameMap()).get("PICTURE");
    private Connection con = null;
    private PreparedStatement pst = null;

    public int insert(InputStream inputStream, String filename) {
        String sql = "INSERT INTO " + tableName + "(PICTURE_FILENAME,DATA) VALUES (?,?)";
        ResultSet rs = null;
        int result = 0;

        try {
            if (con.isClosed()) {
                con = DBConnectUtil.getConnection();
            }
            pst = con.prepareStatement(sql);

            pst.setString(1, filename);
            pst.setBlob(2, inputStream);
            result = pst.executeUpdate();
            con.commit();
            inputStream.close();
        } catch (SQLException e) {
            DBConnectUtil.free(con, pst, rs);
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public InputStream getFile(String fileName) {
//        File file = null;
        InputStream inputStream = null;
        String sql = "select DATA from " + tableName + " WHERE PICTURE_FILENAME=?";
        ResultSet rs = null;
        try {
            if (con.isClosed()) {
                con = DBConnectUtil.getConnection();
            }
            pst = con.prepareStatement(sql);
            pst.setString(1, fileName);
            rs = pst.executeQuery();

            while (rs.next()) {
                inputStream = rs.getBinaryStream("DATA");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnectUtil.free(con, pst, rs);
        }
        return inputStream;
    }

    public byte[] getFileByByte(String fileName) {

        byte[] bytes = new byte[0];

        String sql = "select DATA from " + tableName + " WHERE PICTURE_FILENAME=?";
        ResultSet rs = null;
        try {
            if (null == con || con.isClosed()) {
                con = DBConnectUtil.getConnection();
            }
            pst = con.prepareStatement(sql);
            pst.setString(1, fileName);
            rs = pst.executeQuery();

            while (rs.next()) {
                // inputStream =  rs.getBinaryStream("DATA");
                java.sql.Blob blob = rs.getBlob("DATA");
                InputStream inputStream = null;
                inputStream = blob.getBinaryStream();
                //inputStream = rs.getBinaryStream("DATA");
                bytes = new byte[(int) blob.length()];
                inputStream.read(bytes);
                inputStream.close();
                System.out.printf(bytes.toString());
                return bytes;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            DBConnectUtil.free(con, pst, rs);
        }
        System.out.printf(bytes.toString());
        return bytes;
    }
}
