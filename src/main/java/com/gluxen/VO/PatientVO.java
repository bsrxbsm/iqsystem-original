package com.gluxen.VO;

import com.gluxen.PO.Patient;
import com.gluxen.PO.Question;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Yang Xing Luo on 2018/8/17.
 */
public class PatientVO implements Serializable{
    /**
     * 病人对象
     */
    private Patient patient;

    /**
     * 病人的问题
     */
    private List<Question> questionList;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }
}
