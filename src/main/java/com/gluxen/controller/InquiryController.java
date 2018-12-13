package com.gluxen.controller;

import com.alibaba.fastjson.JSONObject;
import com.gluxen.VO.AnserListVO;
import com.gluxen.VO.InquiryInfoVO;
import com.gluxen.VO.LabelsVO;
import com.gluxen.service.InquiryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Yang Xing Luo on 2018/8/7.
 */
@RestController
@RequestMapping("/inquiry")
@Api(value = "问诊")
public class InquiryController {
    @Autowired
    private InquiryService inquiryService;

    @ApiOperation(value = "新建问诊")
    @PostMapping("/newInquiry")
    public JSONObject newInquiry(@ApiParam(value = "病人ID",required = true) @RequestParam Long patientId){
        return inquiryService.newInquiry(patientId);
    }


    @ApiOperation(value= "新增/修改问诊信息")
    @PostMapping("/postInquiryInfo")
    public JSONObject postInquiryInfo(@ApiParam(value = "问诊信息",required = true) @RequestBody InquiryInfoVO inquiryInfoVO){
        return inquiryService.postInquiryInfo(inquiryInfoVO);
    }

    @ApiOperation(value = "获取某次问诊信息")
    @GetMapping("/getInquiryInfo")
    public JSONObject getInquiryInfo(@ApiParam(value = "问诊ID",required = true) @RequestParam Long inquiryId){
        return  inquiryService.getInquiryInfo(inquiryId);
    }

    @ApiOperation(value = "获取最近一次的问诊信息")
    @GetMapping("/getLatestInquiryInfo")
    public JSONObject getLatestInquiryInfo(@ApiParam(value = "病人ID",required = true) @RequestParam Long patientId){
        return inquiryService.getLatestInquiryInfo(patientId);
    }

    @ApiOperation(value = "新增/修改问诊问题")
    @PostMapping("/postInquiryAnswer")
    public JSONObject postInquiryAnswer(@ApiParam(value = "问题信息",required = true) @RequestBody AnserListVO anserListVO){
        return inquiryService.postInquiryAnswer(anserListVO);
    }

    @ApiOperation(value = "获取问诊问题")
    @GetMapping("/getInquiryAnswer")
    public JSONObject getInquiryAnswer(@ApiParam(value = "问诊ID",required = true) @RequestParam Long inquryId){
        return inquiryService.getInquiryAnswer(inquryId);
    }

    @ApiOperation(value = "读取文件")
    @PostMapping("/getObjFromFile")
    public JSONObject getObjFromFile(@RequestPart(value = "file") MultipartFile file){
        return inquiryService.getObjFromFile(file);
    }

    @ApiOperation(value = "提交诊断标签")
    @PostMapping("/postDiagnoseLabels")
    public JSONObject postDiagnoseLabels(@ApiParam(value = "诊断标签",required = true) @RequestBody LabelsVO labelsVO){
        return inquiryService.postDiagnoseLabels(labelsVO);
    }

    @ApiOperation(value = "获取所有诊断标签")
    @GetMapping("/getDiagnoseLabels")
    public JSONObject getDiagnoseLabels(){
        return inquiryService.getDiagnoseLabels();
    }

    @ApiOperation(value = "获取某个病人所有的诊断标签")
    @GetMapping("/getOnePatientLabels")
    public JSONObject getOnePatientLabels(@ApiParam(value = "病人ID",required = true) @RequestParam Long patientId){
        return inquiryService.getOnePatientLabels(patientId);
    }

    @ApiOperation(value = "获取某次诊断的诊断标签")
    @GetMapping("/getInquiryLabels")
    public JSONObject getInquiryLabels(@ApiParam(value = "问诊ID",required = true) @RequestParam Long inquiryId){
        return inquiryService.getInquiryLabels(inquiryId);
    }

    @ApiOperation(value = "获取最近一次的诊断标签")
    @GetMapping("/getLatestLabels")
    public JSONObject getLatestLabels(@ApiParam(value = "病人ID",required = true) @RequestParam Long patientId){
        return inquiryService.getLatestLabels(patientId);
    }

    @ApiOperation(value = "更新病历的年龄")
    @GetMapping("/updatePatientAge")
    public  void updatePatientAge(){
        inquiryService.updateAge();
    }

    @ApiOperation(value = "药方的划价")
    @GetMapping("/getRecipesPrice")
    public JSONObject getRecipesPrice(@ApiParam(value = "问诊ID",required = true) @RequestParam Long inquiryId){
        return inquiryService.getRecipesPrice(inquiryId);
    }
}
