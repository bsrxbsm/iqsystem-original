package com.gluxen.controller;

import com.alibaba.fastjson.JSONObject;
import com.gluxen.PO.MedicineStorageRecord;
import com.gluxen.VO.MedicineStorageRecordVO;
import com.gluxen.service.MedicineStorageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicine")
@Api(value = "药品管理")
public class MedicineStorageController {

    @Autowired
    private MedicineStorageService medicineStorageService;

    @ApiOperation(value = "新建药品入库记录")
    @PostMapping("/newMedicineStorageRecord")
    public JSONObject postMedicineStorageRecord(@ApiParam(value = "入库记录",required = true)
                                               @RequestBody List<MedicineStorageRecord> medicineStorageRecords){
        return medicineStorageService.postMedicineStorageRecord(medicineStorageRecords);
    }

    @ApiOperation(value = "查询药品的库存")
    @GetMapping("/getMedicineStock")
    public JSONObject getMedicineStock(@ApiParam(value = "要查的药品名",required = false)
                                       @RequestParam(required = false) String medicine){
        return medicineStorageService.getMedicineStock(medicine);
    }

    @ApiOperation(value = "查询入库记录")
    @GetMapping("/getMedicineStorageRecords")
    public JSONObject getMedicineStorageRecords(@ApiParam(value = "指定药品",required = false)
                                                @RequestParam(required = false) String medicineName,
                                                @ApiParam(value = "指定起始日期",required = false)
                                                @RequestParam(required = false) String startDate,
                                                @ApiParam(value = "指定结束日期",required = false)
                                                @RequestParam(required = false) String endDate){
        return medicineStorageService.getMedicineStorageRecords(medicineName,startDate,endDate);
    }

}
