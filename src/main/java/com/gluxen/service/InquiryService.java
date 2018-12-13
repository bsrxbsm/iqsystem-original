package com.gluxen.service;

import com.alibaba.fastjson.JSONObject;
import com.gluxen.PO.DiagnoseLabels;
import com.gluxen.VO.AnserListVO;
import com.gluxen.VO.InquiryInfoVO;
import com.gluxen.VO.LabelsVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


/**
 * Created by Yang Xing Luo on 2018/8/7.
 */
public interface InquiryService {
    /**
     * 新建问诊记录
     * @param patientId
     * @return
     */
    JSONObject newInquiry(Long patientId);


    /**
     * 新增问诊信息
     * @param inquiryInfoVO
     * @return
     */
    JSONObject postInquiryInfo(InquiryInfoVO inquiryInfoVO);


    /**
     * 获取问诊信息
     * @param inquiryId
     * @return
     */
    JSONObject getInquiryInfo(Long inquiryId);

    /**
     * 获取某位病人最近一次的问诊信息
     * @param patientId
     * @return
     */
    JSONObject getLatestInquiryInfo(Long patientId);


    /**
     * 提交问诊问题答案
     * @return
     */
    JSONObject postInquiryAnswer(AnserListVO anserListVO);


    /**
     * 获取某次问诊的答案
     * @param inquiryId
     * @return
     */
    JSONObject getInquiryAnswer(Long inquiryId);


    /**
     * 读取文件到对象
     */
    JSONObject getObjFromFile(MultipartFile file);


    /**
     * 提交诊断标签
     * @return
     */
    JSONObject postDiagnoseLabels(LabelsVO labelsVO);


    /**
     * 获取所有病人的诊断标签
     * @return
     */
    JSONObject getDiagnoseLabels();


    /**
     * 获取某个病人的标签
     * @param patientId
     * @return
     */
    JSONObject getOnePatientLabels(Long patientId);


    /**
     * 获取某次问诊的标签
     * @param inquiryId
     * @return
     */
    JSONObject getInquiryLabels(Long inquiryId);

    /**
     * 获取最近一次的诊断标签
     * @param patientId
     * @return
     */
    JSONObject getLatestLabels(Long patientId);

    /**
     * 获取病历信息对象
     * @param inquiryId
     * @return
     */
    InquiryInfoVO getInquiryInfoVO(Long inquiryId);

    void updateAge();

    /**
     * 获取指定问诊所开药方的价格
     * @param inquiryId
     * @return
     */
    JSONObject getRecipesPrice(Long inquiryId);
}
