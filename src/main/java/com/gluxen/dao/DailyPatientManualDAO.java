package com.gluxen.dao;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by Yang Xing Luo on 2018/8/7.
 */
public interface DailyPatientManualDAO {
    /**
     * 获取每日病人列表
     * @param pName
     * @param startDate
     * @param endDate
     * @param keyWords
     * @param pId
     * @return
     */
    List<JSONObject> getDailyPatientList(@Param(value="pName") String pName,
                                         @Param(value="startDate") String startDate,
                                         @Param(value="endDate") String endDate,
                                         @Param(value="keyWords") String keyWords,
                                         @Param(value="pId") Long pId,
                                         @Param(value = "startYear") Integer startYear,
                                         @Param(value = "startMonth") Integer startMonth,
                                         @Param(value = "startDay") Integer startDay,
                                         @Param(value = "endYear") Integer endYear,
                                         @Param(value = "endMonth") Integer endMonth,
                                         @Param(value = "endDay") Integer endDay,
                                         @Param(value = "residence") String residence,
                                         @Param(value = "gender") String gender);

    /**
     * 获取当日需要填写问题的病人
     * @param iqDate
     * @return
     */
    List<JSONObject> getQuestionPatientList(@Param(value="iqDate") String iqDate);



}
