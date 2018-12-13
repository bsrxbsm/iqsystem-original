package com.gluxen.controller;

import com.alibaba.fastjson.JSONObject;
import com.gluxen.PO.Patient;
import com.gluxen.service.PatientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Yang Xing Luo on 2018/8/5.
 */
@RestController
@RequestMapping("/index")
@Api(value = "病人")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @ApiOperation(value = "初诊新增病人")
    @PostMapping("/firstDiag")
    public JSONObject newPatient(@ApiParam(value = "病人信息",required = true) @RequestBody Patient patient){
        return patientService.newPatient(patient);
    }

    @ApiOperation(value = "获取地址列表")
    @GetMapping("/getPlace")
    public JSONObject getPlace(){
        return patientService.getPlace();
    }

    @ApiOperation(value = "复诊")
    @PostMapping("/revisit")
    public JSONObject revisit(@ApiParam(value = "病人信息",required = true) @RequestBody Patient patient){
        return patientService.revisit(patient);
    }

    @ApiOperation(value = "删除病人")
    @DeleteMapping("/deletePatient")
    public JSONObject deletePatient(@ApiParam(value = "病人ID",required = true) @RequestParam Long patientId){
        return patientService.deletePatient(patientId);
    }

    @ApiOperation(value = "下载信息文件")
    @PostMapping("/getPatientInfoWord")
    public void getPatientInfoFile(@ApiParam(value = "问诊ID列表") @RequestParam(required = false) List<Long> inquiryIdList,
                                   @ApiParam(value = "是否全选",required = true) @RequestParam boolean all,
                                   @ApiParam(value = "病人ID") @RequestParam(required = false) Long patientId,
                                   HttpServletResponse response){
        patientService.saveObjToWord(inquiryIdList,all,patientId,response);
    }




}
