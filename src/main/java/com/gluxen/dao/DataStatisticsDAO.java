package com.gluxen.dao;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by Yang Xing Luo on 2018/8/8.
 */
public interface DataStatisticsDAO {
    /**
     * 获取问诊情况列表
     * @param startDate
     * @param endDate
     * @return
     */
    List<JSONObject> getInquirySituation(@Param(value = "startDate") String startDate,
                                         @Param(value = "endDate") String endDate);


    /**
     * 获取主方用药量
     * @param startDate
     * @param endDate
     * @return
     */
    List<JSONObject> mainDrugUse(@Param(value = "startDate") String startDate,
                                         @Param(value = "endDate") String endDate);

    /**
     * 获取副方用药量
     * @param startDate
     * @param endDate
     * @return
     */
    List<JSONObject> viceDrugUse(@Param(value = "startDate") String startDate,
                                 @Param(value = "endDate") String endDate);

    /**
     * 获取所有药方的用药量
     * @param startDate
     * @param endDate
     * @return
     */
    List<JSONObject> drugUse(@Param(value = "startDate") String startDate,
                             @Param(value = "endDate") String endDate,
                             @Param(value = "medicine") String medicine);

    /**
     * 获取全部ID
     * @return
     */
    List<Long> getAllId(@Param(value="patientId") Long patientId);
}
