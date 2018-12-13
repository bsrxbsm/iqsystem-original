package com.gluxen.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gluxen.PO.DailyPatient;
import com.gluxen.PO.DailyPatientExample;
import com.gluxen.VO.InquiryInfoVO;
import com.gluxen.dao.DailyPatientDAO;
import com.gluxen.dao.DataStatisticsDAO;
import com.gluxen.service.DataStatisticsService;
import com.gluxen.service.InquiryService;
import com.gluxen.util.CommonUtil;
import com.gluxen.util.StringDate;
import com.gluxen.util.constants.ErrorEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.gluxen.util.CommonUtil.printToExcel;

/**
 * Created by Yang Xing Luo on 2018/8/8.
 */
@Service
public class DataStatisticsServiceImpl implements DataStatisticsService {
    @Autowired
    private DataStatisticsDAO dataStatisticsDAO;

    @Autowired
    private InquiryService inquiryService;

    @Autowired
    private DailyPatientDAO dailyPatientDAO;


    /**
     * 获取问诊情况
     * @param startDate
     * @param endDate
     * @return
     */
    @Override
    public JSONObject getInquirySituation(Integer pageNum,Integer pageSize,String startDate,String endDate){
        try{
            PageHelper.startPage(pageNum,pageSize);

            SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            try{
                Date sDate = sDateFormat.parse(startDate+" 00:00:00");
                Date eDate = sDateFormat.parse(endDate+ " 00:00:00");


                Calendar c = Calendar.getInstance();
                c.setTime(eDate);
                c.add(Calendar.DAY_OF_MONTH,1);
                eDate = c.getTime();
                System.out.println(sDate.toString()+" "+ eDate.toString());

                List<JSONObject> inquiryList = dataStatisticsDAO.getInquirySituation(sDateFormat.format(sDate),sDateFormat.format(eDate));
                PageInfo<JSONObject> inquiryPageInfo = new PageInfo<>(inquiryList);


                JSONObject data = new JSONObject();
                data.put("pageInfo",inquiryPageInfo);

                return CommonUtil.successJson(data);
            }catch (ParseException e){
                e.printStackTrace();
                return CommonUtil.errorJson(ErrorEnum.E_90021);
            }




        }catch (RuntimeException e){
            e.printStackTrace();
            return CommonUtil.errorJson(ErrorEnum.E_90021);
        }

    }

    /**
     * 获取用药量
     * @param pageNum
     * @param pageSize
     * @param startDate
     * @param endDate
     * @return
     */
    @Override
    public JSONObject getDrugUse(Integer pageNum,Integer pageSize,String startDate,String endDate,String medicine){
        SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<JSONObject> medicineList;
        try{

            if(startDate != null && endDate != null){
                Date sDate = sDateFormat.parse(startDate+" 00:00:00");
                Date eDate = sDateFormat.parse(endDate+ " 00:00:00");


                Calendar c = Calendar.getInstance();
                c.setTime(eDate);
                c.add(Calendar.DAY_OF_MONTH,1);
                eDate = c.getTime();

                PageHelper.startPage(pageNum,pageSize);
                medicineList = dataStatisticsDAO.drugUse(sDateFormat.format(sDate),sDateFormat.format(eDate),medicine);
            }else{
                PageHelper.startPage(pageNum,pageSize);
                medicineList = dataStatisticsDAO.drugUse(startDate,endDate,medicine);
            }

            PageInfo<JSONObject> drugPageInfo = new PageInfo<>(medicineList);
            List<JSONObject> jsonObjectList = drugPageInfo.getList();
            int i = 1;
            for (JSONObject jsonobject:jsonObjectList){
                jsonobject.put("yindex",i);
                i++;
            }
            drugPageInfo.setList(jsonObjectList);
            JSONObject data = new JSONObject();
            data.put("pageInfo",drugPageInfo);

            return CommonUtil.successJson(data);
        }catch (ParseException e){
            e.printStackTrace();
            return CommonUtil.errorJson(ErrorEnum.E_90021);
        }
        catch (RuntimeException e){
            e.printStackTrace();
            return CommonUtil.errorJson(ErrorEnum.E_90021);
        }
    }

    /**
     *
     * @param inquiryIdList
     * @param all
     * @return
     */
    @Override
    public JSONObject getInquiryInfoList(List<Long> inquiryIdList,boolean all,Long patientId){
        try{
            JSONObject data = new JSONObject();
            ArrayList<InquiryInfoVO> inquiryInfoVOArrayList = new ArrayList<InquiryInfoVO>();
            if(all){
                if(patientId!=null) {
                    inquiryIdList = dataStatisticsDAO.getAllId(patientId);
                }else{
                    inquiryIdList = dataStatisticsDAO.getAllId(null);
                }
            }
            for(int i = 0;i < inquiryIdList.size();i++){
                System.out.println(i);
                inquiryInfoVOArrayList.add(inquiryInfoVOArrayList.size(),inquiryService.getInquiryInfoVO(inquiryIdList.get(i)));
            }
            data.put("inquiryInfo",inquiryInfoVOArrayList);
            return CommonUtil.successJson(data);
        }catch (RuntimeException e){
            e.printStackTrace();
            return CommonUtil.errorJson(ErrorEnum.E_90021);
        }
    }

    /**
     * 获取打印的病历信息
     * @param inquiryIdList
     * @param all
     * @param patientId
     * @return
     */
    @Override
    public JSONObject getInquiryInfoList2(List<Long> inquiryIdList,boolean all,Long patientId){
        JSONObject data = new JSONObject();
        DailyPatientExample dailyPatientExample = new DailyPatientExample();
        dailyPatientExample.createCriteria().andInquiryIdIn(inquiryIdList);
        List<DailyPatient> dailyPatientList = dailyPatientDAO.selectByExample(dailyPatientExample);
        return CommonUtil.successJson();
    }

    /**
     * 将用药情况导出到EXCEL
     *
     * @param pageNum
     * @param pageSize
     * @param startDate
     * @param endDate
     * @param medicine
     * @return
     */
    @Override
    public void getDrugUsetoExcel(Integer pageNum, Integer pageSize, String startDate, String endDate, String medicine, HttpServletResponse response) {
        SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<JSONObject> medicineList = new ArrayList<JSONObject>();

        if(medicine.equals("null")){
            medicine = null;
        }

        try {
            if (startDate != null && endDate != null && !startDate.equals("null") && !endDate.equals("null")) {
                Date sDate = sDateFormat.parse(startDate + " 00:00:00");
                Date eDate = sDateFormat.parse(endDate + " 00:00:00");


                Calendar c = Calendar.getInstance();
                c.setTime(eDate);
                c.add(Calendar.DAY_OF_MONTH, 1);
                eDate = c.getTime();

                PageHelper.startPage(pageNum, pageSize);
                medicineList = dataStatisticsDAO.drugUse(sDateFormat.format(sDate), sDateFormat.format(eDate), medicine);
            } else {
                PageHelper.startPage(pageNum, pageSize);
                medicineList = dataStatisticsDAO.drugUse(startDate, endDate, medicine);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        PageInfo<JSONObject> drugPageInfo = new PageInfo<>(medicineList);
            List<JSONObject> jsonObjectList = drugPageInfo.getList();
            int i = 1;
            for (JSONObject jsonobject : jsonObjectList) {
                jsonobject.put("yindex", i);
                i++;
            }




        String[] lables = {"序号","药名","药量(g)"};

        String path = StringDate.getShortDate(new Date())+".xlsx";

        if(startDate != null && !startDate.equals("null")){
            path = startDate;
        }
        if(endDate != null && !endDate.equals("null")){
            path = endDate;
        }
        if(startDate != null && endDate != null && !endDate.equals("null") && !startDate.equals("null")){
            path = startDate +"-"+ endDate + "用药统计"+".xlsx";
        }

        try {
            printToExcel(lables,path,jsonObjectList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.setHeader("content-type", "application/octet-stream");
        response.setContentType("application/octet-stream");
        try{
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(path, "UTF-8"));
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            os = response.getOutputStream();
            FileInputStream is = new FileInputStream(new File(path));
            bis = new BufferedInputStream(is);
            response.setContentLength(bis.available());
            int j = bis.read(buff);
            while (j != -1) {
                os.write(buff, 0, buff.length);
                os.flush();
                j = bis.read(buff);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            File file = new File(path);
            if (file.exists()&&file.isFile()){
                file.delete();
            }
        }
    }
}
