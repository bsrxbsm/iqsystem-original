package com.gluxen.VO;

import com.gluxen.PO.Question;

import java.util.List;

/**
 * Created by Yang Xing Luo on 2018/8/8.
 */
public class AnserListVO {
    /**
     * 答案列表
     */
    private List<AnswerVO> answerVOList;

    /**
     * 问诊ID
     */
    private Long InquiryId;

    public List<AnswerVO> getAnswerVOList() {
        return answerVOList;
    }

    public void setAnswerVOList(List<AnswerVO> answerVOList) {
        this.answerVOList = answerVOList;
    }

    public Long getInquiryId() {
        return InquiryId;
    }

    public void setInquiryId(Long inquiryId) {
        InquiryId = inquiryId;
    }
}
