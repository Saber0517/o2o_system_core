package com.oocl.jyhon.util;

import org.junit.Test;

import java.util.Map;
import java.util.Set;

/**
 * Created by ZHANGJA4 on 8/5/2015.
 */
public class DBTableNameUtilTest {
    @Test
    public void test(){
        Map<String, String> tableNameMap = DBTableNameUtil.getTableNameMap();
        for (String tableName:tableNameMap.keySet()){
            System.out.print(tableName);
            System.out.print("=");
            System.out.println(tableNameMap.get(tableName));
        }
    }
}
