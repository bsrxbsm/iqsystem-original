package com.gluxen.VO;

/**
 * Created by Yang Xing Luo on 2018/8/8.
 */
public class AnswerVO {
    /**
     * 问题label
     */
    private String questionLabel;

    /**
     * 问题答案
     */
    private String answer;

    /**
     * 问题题干
     */
    private String stem;

    /**
     * 问题备注
     */
    private String remark;

    public String getQuestionLabel() {
        return questionLabel;
    }

    public void setQuestionLabel(String questionLabel) {
        this.questionLabel = questionLabel;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getStem() {
        return stem;
    }

    public void setStem(String stem) {
        this.stem = stem;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
