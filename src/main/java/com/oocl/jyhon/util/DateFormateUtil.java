package com.oocl.jyhon.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 格式化和解析date工具类
 *
 * @author WhiteSaber
 */
public class DateFormateUtil {
    static String DATA_FORMATE = "YYYY-MM-dd-HH-mm-ss";

    public static String simpleFormatTime(Date time) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATA_FORMATE);
        return sdf.format(time);
    }

    public static Date parseDateString(String dateString) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATA_FORMATE);
        Date date = null;
        try {
            date = sdf.parse(dateString);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date;
    }

    //如果日期格式不全，可以自动补全
    public static Date parseDateStringWithFix(String dataString) {
        if (dataString.length() < 11) {
            dataString += "-00-00-00";
        }
        return parseDateString(dataString);
    }
}
