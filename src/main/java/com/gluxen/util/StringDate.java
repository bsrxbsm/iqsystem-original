package com.gluxen.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Yang Xing Luo on 2018/8/5.
 */
public class StringDate {
    public static  String getDate(){
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
        return df.format(new Date());// new Date()为获取当前系统时间
    }

    public static Date praseLongDate(String longDate){
        Date date = null;

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try{
            date = df.parse(longDate);
        }catch (ParseException e){
            e.printStackTrace();
        }
        return date;
    }

    public static String getShortDate(Date date){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(date);
    }

    public static String getLongDate(Date date){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return df.format(date);
    }


}
