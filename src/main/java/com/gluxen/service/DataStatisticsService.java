package com.gluxen.service;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Yang Xing Luo on 2018/8/8.
 */
public interface DataStatisticsService {


    /**
     * 获取问诊情况
     * @param startDate
     * @param endDate
     * @return
     */
    JSONObject getInquirySituation(Integer pageNum,Integer pageSize,String startDate,String endDate);


    /**
     * 获取用药量
     * @param pageNum
     * @param pageSize
     * @param startDate
     * @param endDate
     * @return
     */
    JSONObject getDrugUse(Integer pageNum,Integer pageSize,String startDate,String endDate,String medicine);

    /**
     * 将用药情况导出到EXCEL
     * @param pageNum
     * @param pageSize
     * @param startDate
     * @param endDate
     * @return
     */
     void getDrugUsetoExcel(Integer pageNum, Integer pageSize, String startDate, String endDate, String medicine, HttpServletResponse response);
    /**
     * 导出病历信息
     * @param inquiryIdList
     * @param all
     * @return
     */
    JSONObject getInquiryInfoList(List<Long> inquiryIdList,boolean all,Long patientId);

    /**
     * 导出病历信息
     * @param inquiryIdList
     * @param all
     * @param patientId
     * @return
     */
    JSONObject getInquiryInfoList2(List<Long> inquiryIdList,boolean all,Long patientId);
}
