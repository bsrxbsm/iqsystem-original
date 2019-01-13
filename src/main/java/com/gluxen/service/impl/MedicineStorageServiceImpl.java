package com.gluxen.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.gluxen.PO.Medicine;
import com.gluxen.PO.MedicineExample;
import com.gluxen.PO.MedicineStorageRecord;
import com.gluxen.PO.MedicineStorageRecordExample;
import com.gluxen.VO.MedicineStorageRecordVO;
import com.gluxen.dao.MedicineDAO;
import com.gluxen.dao.MedicineStorageRecordDAO;
import com.gluxen.service.MedicineStorageService;
import com.gluxen.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
@Service
public class MedicineStorageServiceImpl implements MedicineStorageService {
    @Autowired
    private MedicineStorageRecordDAO medicineStorageRecordDAO;

    @Autowired
    private MedicineDAO medicineDAO;
    /**
     * 多个药品入库记录
     *
     * @param medicineStorageRecordS
     */
    @Override
    public JSONObject postMedicineStorageRecord(List<MedicineStorageRecord> medicineStorageRecordS) {
        JSONObject error = new JSONObject();
        List<MedicineStorageRecord> errorRecords = new ArrayList<MedicineStorageRecord>();
        for (MedicineStorageRecord record:medicineStorageRecordS){
            int i = updateAndInsertMedicine(record);
            if (i == 0)
                errorRecords.add(record);
        }
        if (errorRecords.size() == 0)
            return CommonUtil.successJson();
        else{
            error.put("failRecords",errorRecords);
            return CommonUtil.successJson(error);
        }
    }

    @Transactional
    public int updateAndInsertMedicine(MedicineStorageRecord record){
        Medicine medicine = medicineDAO.selectByPrimaryKey(record.getMedicineId());
        if (medicine == null)
            return 0;
        medicine.setMedicineStock(medicine.getMedicineStock()+record.getStock());
        int i = medicineDAO.updateByPrimaryKey(medicine);
        if (i != 0){
            int j = medicineStorageRecordDAO.insert(record);
            return j;
        }
        return i;
    }


    /**
     * 获取多个药品的库存数量
     *
     * @param medicineName
     */
    @Override
    public JSONObject getMedicineStock(String medicineName) {
        List<Medicine> medicines = new ArrayList<Medicine>();
        MedicineExample example = new MedicineExample();
        if (medicineName==null){
            example.createCriteria().andIdIsNotNull();
            medicines = medicineDAO.selectByExample(example);
        }else {
            example.createCriteria().andMedicineNameEqualTo(medicineName);
            medicines = medicineDAO.selectByExample(example);
        }
        JSONObject data = new JSONObject();
        data.put("medicines",medicines);
        return CommonUtil.successJson(data);
    }

    /**
     * 查询入库的记录
     *
     * @param medicineName
     * @param startDate
     * @param endDate
     */
    @Override
    public JSONObject getMedicineStorageRecords(String medicineName, String startDate,String endDate) {

        MedicineStorageRecordExample example = new MedicineStorageRecordExample();
        MedicineStorageRecordExample.Criteria criteria= example.createCriteria();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if ((medicineName == null)&&(startDate == null)&&(endDate == null)){
            criteria.andIdIsNotNull();
        }
        if (medicineName != null){
            MedicineExample medicineExample = new MedicineExample();
            medicineExample.createCriteria().andMedicineNameEqualTo(medicineName);
            int medicineId = medicineDAO.selectByExample(medicineExample).get(0).getId();
            criteria.andMedicineIdEqualTo(medicineId);
        }
        if (startDate != null){
            try {
                criteria.andDateGreaterThanOrEqualTo(sdf.parse(startDate));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (endDate != null) {
            try {
                criteria.andDateLessThanOrEqualTo(sdf.parse(endDate));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        List<MedicineStorageRecord> medicineStorageRecords = medicineStorageRecordDAO.selectByExample(example);
        System.out.println(medicineStorageRecords);
        JSONObject data = new JSONObject();
        data.put("records",medicineStorageRecords);
        return CommonUtil.successJson(data);
    }
}

