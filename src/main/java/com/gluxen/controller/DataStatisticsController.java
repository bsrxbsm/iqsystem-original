package com.gluxen.controller;

import com.alibaba.fastjson.JSONObject;
import com.gluxen.service.DataStatisticsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Yang Xing Luo on 2018/8/8.
 */
@RestController
@RequestMapping("/dataStatistics")
@Api(value = "数据统计")
public class DataStatisticsController {
    @Autowired
    private DataStatisticsService dataStatisticsService;



    @ApiOperation(value = "获取问诊情况")
    @GetMapping("/getInquirySituation")
    public JSONObject getInquirySituation(@ApiParam(value = "开始日期") @RequestParam(required = false) String startDate,
                                          @ApiParam(value = "结束日期") @RequestParam(required = false) String endDate,
                                          @ApiParam(value = "第几页",required = true) @RequestParam Integer pageNum,
                                          @ApiParam(value = "页面大小",required = true) @RequestParam Integer pageSize){
        return dataStatisticsService.getInquirySituation(pageNum,pageSize,startDate,endDate);
    }

    @ApiOperation(value = "获取用药情况")
    @GetMapping("/drugUse")
    public JSONObject getDrugUse(@ApiParam(value = "开始日期") @RequestParam(required = false) String startDate,
                                          @ApiParam(value = "结束日期") @RequestParam(required = false) String endDate,
                                          @ApiParam(value = "药名") @RequestParam(required = false) String medicine,
                                          @ApiParam(value = "第几页",required = true) @RequestParam Integer pageNum,
                                          @ApiParam(value = "页面大小",required = true) @RequestParam Integer pageSize){
        return dataStatisticsService.getDrugUse(pageNum, pageSize, startDate, endDate,medicine);
    }
    @ApiOperation(value = "将用药情况导出到EXCEL")
    @GetMapping("/drugUseToExcel")
    public void getDrugUseToExcel(@ApiParam(value = "开始日期") @RequestParam(required = false) String startDate,
                                 @ApiParam(value = "结束日期") @RequestParam(required = false) String endDate,
                                 @ApiParam(value = "药名") @RequestParam(required = false) String medicine,
                                 @ApiParam(value = "第几页",required = true) @RequestParam Integer pageNum,
                                 @ApiParam(value = "页面大小",required = true) @RequestParam Integer pageSize,
                                  HttpServletResponse response){
            dataStatisticsService.getDrugUsetoExcel(pageNum, pageSize, startDate, endDate,medicine,response);
    }

    @ApiOperation(value = "获取打印的病历列表")
    @PostMapping("/getInquiryInfoList")
    public JSONObject getInquiryInfoList(@ApiParam(value = "问诊ID列表") @RequestParam(required = false) List<Long> inquiryIdList,
                                         @ApiParam(value = "是否全选",required = true) @RequestParam boolean all,
                                         @ApiParam(value = "病人ID") @RequestParam(required = false) Long patientId
                                         ) {
        return dataStatisticsService.getInquiryInfoList(inquiryIdList, all, patientId);
    }
}
