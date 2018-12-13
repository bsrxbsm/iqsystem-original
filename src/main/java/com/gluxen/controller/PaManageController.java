package com.gluxen.controller;

import com.alibaba.fastjson.JSONObject;
import com.gluxen.PO.Patient;
import com.gluxen.service.PatientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Yang Xing Luo on 2018/8/6.
 */
@RestController
@RequestMapping("/patientManage")
@Api(value = "病人管理")
public class PaManageController {
    @Autowired
    private PatientService patientService;

    @ApiOperation(value = "获取病人列表")
    @GetMapping("/getPatientList")
    public JSONObject getPatientList(@ApiParam(value = "病人姓名") @RequestParam(required = false) String pname,
                                     @ApiParam(value = "第几页",required = true) @RequestParam Integer pageNum,
                                     @ApiParam(value = "页面大小",required = true) @RequestParam Integer pageSize){
        return patientService.getPatientList(pname,pageSize,pageNum);
    }

    @ApiOperation(value = "查看病人信息")
    @GetMapping("/getPatientInfo")
    public JSONObject getPatientInfo(@ApiParam(value = "病人ID",required = true) @RequestParam Long pId){
        return patientService.getPatientInfo(pId);
    }

    @ApiOperation(value = "更新病人信息")
    @PutMapping("/updatePatientInfo")
    public JSONObject updatePatientInfo(@ApiParam(value = "病人信息",required = true) @RequestBody Patient patient){
        return patientService.updatePatientInfo(patient);
    }

    @ApiOperation(value = "复诊时有重复病人，获取病人列表")
    @PostMapping("/getRevisitList")
    public JSONObject getRevisitList(@ApiParam(value = "病人信息",required = true)  @RequestBody Patient patient,
                                     @ApiParam(value = "第几页",required = true) @RequestParam Integer pageNum,
                                     @ApiParam(value = "页面大小",required = true) @RequestParam Integer pageSize){
        return patientService.getRevisitList(patient,pageSize,pageNum);
    }
}
