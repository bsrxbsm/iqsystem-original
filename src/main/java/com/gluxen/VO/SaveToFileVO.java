package com.gluxen.VO;

import com.gluxen.PO.Patient;
import com.gluxen.PO.Question;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Yang Xing Luo on 2018/8/17.
 */
public class SaveToFileVO implements Serializable {
    /**
     * 病人信息列表
     */

    private List<PatientVO> patientVOList;


    public List<PatientVO> getPatientVOList() {
        return patientVOList;
    }

    public void setPatientVOList(List<PatientVO> patientVOList) {
        this.patientVOList = patientVOList;
    }
}
