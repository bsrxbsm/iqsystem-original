package com.gluxen.dao;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Yang Xing Luo on 2018/8/5.
 */
@Repository
public interface PlaceDAO {
    /**
     * 同时获取城市和省份
     * @return
     */
    List<JSONObject> getPlace();

    /**
     * 获取城市名字
     * @param cityId
     * @return
     */
    String getCityName(String cityId);

    /**
     * 获取省份名字
     * @param provId
     * @return
     */
    String getProvName(String provId);
}
