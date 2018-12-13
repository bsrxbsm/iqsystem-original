package com.gluxen.controller;

import com.alibaba.fastjson.JSONObject;
import com.gluxen.service.DailyPatientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Yang Xing Luo on 2018/8/7.
 */
@RestController
@RequestMapping("/MrManage")
@Api(value = "病历管理")
public class DailyPatientController {
    @Autowired
    private DailyPatientService dailyPatientService;


    @ApiOperation(value = "查询获取病历列表")
    @GetMapping("/getMrList")
    public JSONObject getMrList(@ApiParam(value = "病人姓名") @RequestParam(required = false) String pname,
                                @ApiParam(value = "开始日期") @RequestParam(required = false) String startDate,
                                @ApiParam(value = "结束日期") @RequestParam(required = false) String endDate,
                                @ApiParam(value = "关键字") @RequestParam(required = false) String keyWords,
                                @ApiParam(value = "病人Id") @RequestParam(required = false) Long patientId,
                                @ApiParam(value = "年龄下界") @RequestParam(required = false) String startAge,
                                @ApiParam(value = "年龄上界") @RequestParam(required = false) String endAge,
                                @ApiParam(value = "来源地") @RequestParam(required = false) String residence,
                                @ApiParam(value = "性别")@RequestParam(required = false) String gender,
                                @ApiParam(value = "第几页",required = true) @RequestParam Integer pageNum,
                                @ApiParam(value = "页面大小",required = true) @RequestParam Integer pageSize){
        return dailyPatientService.getDailyPatientList(pname,startDate,endDate,keyWords,pageNum,pageSize,patientId,startAge,endAge,residence,gender);
    }

    @ApiOperation(value = "获取需要填写问诊问题的病历列表")
    @GetMapping("/getToCompleteList")
    public JSONObject getToCompleteList(@ApiParam(value = "第几页",required = true) @RequestParam Integer pageNum,
                                        @ApiParam(value = "页面大小",required = true) @RequestParam Integer pageSize
    ){
        return dailyPatientService.getQuestionPatientList(pageNum,pageSize);
    }

    @ApiOperation(value = "删除病历")
    @DeleteMapping("/deleteDailyPatient")
    public JSONObject deleteDailyPatient(@ApiParam(value = "问诊Id",required = true) @RequestParam Long inquiryid
    ){
        return dailyPatientService.deleteDailyPatient(inquiryid);
    }



}
