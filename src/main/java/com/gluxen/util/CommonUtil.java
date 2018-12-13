package com.gluxen.util;

import com.alibaba.fastjson.JSONObject;
import com.gluxen.PO.RecipeDetail;
import com.gluxen.PO.ViceRecipeDetail;
import com.gluxen.VO.InquiryInfoVO;
import com.gluxen.VO.MainRecipeVO;
import com.gluxen.VO.ViceRecipeVO;
import com.gluxen.util.constants.Constants;
import com.gluxen.util.constants.ErrorEnum;
import com.gluxen.config.exception.CommonJsonException;
import com.lowagie.text.*;
import com.lowagie.text.rtf.RtfWriter2;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletRequest;
import java.io.FileOutputStream;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by Yang Xing Luo on 2017/12/31.
 */
public class CommonUtil {

    /**
     * 返回一个returnData为空对象的成功消息的json
     *
     * @return
     */
    public static JSONObject successJson() {
        return successJson(new JSONObject());
    }

    /**
     * 返回一个返回码为200的json
     *
     * @param returnData json里的主要内容
     * @return
     */
    public static JSONObject successJson(Object returnData) {
        JSONObject resultJson = new JSONObject();
        resultJson.put("code", Constants.SUCCESS_CODE);
        resultJson.put("msg", Constants.SUCCESS_MSG);
        resultJson.put("data", returnData);
        return resultJson;
    }

    /**
     * 返回错误信息JSON
     *
     * @param errorEnum 错误码的errorEnum
     * @return
     */
    public static JSONObject errorJson(ErrorEnum errorEnum) {
        JSONObject resultJson = new JSONObject();
        resultJson.put("code", errorEnum.getErrorCode());
        resultJson.put("msg", errorEnum.getErrorMsg());
        resultJson.put("data", new JSONObject());
        return resultJson;
    }



    /**
     * 将request参数值转为json
     *
     * @param request
     * @return
     */
    public static JSONObject request2Json(HttpServletRequest request) {
        JSONObject requestJson = new JSONObject();
        Enumeration paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = (String) paramNames.nextElement();
            String[] pv = request.getParameterValues(paramName);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < pv.length; i++) {
                if (pv[i].length() > 0) {
                    if (i > 0) {
                        sb.append(",");
                    }
                    sb.append(pv[i]);
                }
            }
            requestJson.put(paramName, sb.toString());
        }
        return requestJson;
    }

    /**
     * 将request转JSON
     * 并且验证非空字段
     *
     * @param request
     * @param requiredColumns
     * @return
     */
    public static JSONObject convert2JsonAndCheckRequiredColumns(HttpServletRequest request, String requiredColumns) {
        JSONObject jsonObject = request2Json(request);
        hasAllRequired(jsonObject, requiredColumns);
        return jsonObject;
    }

    /**
     * 验证是否含有全部必填字段
     *
     * @param requiredColumns 必填的参数字段名称 逗号隔开 比如"userId,name,telephone"
     * @param jsonObject
     * @return
     */
    public static void hasAllRequired(final JSONObject jsonObject, String requiredColumns) {
        if (!StringTools.isNullOrEmpty(requiredColumns)) {
            //验证字段非空
            String[] columns = requiredColumns.split(",");
            String missCol = "";
            for (String column : columns) {
                Object val = jsonObject.get(column.trim());
                if (StringTools.isNullOrEmpty(val)) {
                    missCol += column + "  ";
                }
            }
            if (!StringTools.isNullOrEmpty(missCol)) {
                jsonObject.clear();
                jsonObject.put("code", ErrorEnum.E_90003.getErrorCode());
                jsonObject.put("msg", "缺少必填参数:" + missCol.trim());
                jsonObject.put("data", new JSONObject());
                throw new CommonJsonException(jsonObject);
            }
        }
    }

    /**
     * 将数据统计中的用药数据导出到EXCEL
     * @param lables
     * @param path
     * @param drugList
     * @throws Exception
     */
    public static void printToExcel(String[] lables, String path, List<JSONObject> drugList)throws Exception{
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("sheet1");
        XSSFRow labelRow = sheet.createRow(0);
        for (int i = 0; i < lables.length; i++) {
            labelRow.createCell(i).setCellValue(lables[i]);
        }//设置第一行的标签行
        for (int i = 0; i <drugList.size() ; i++) {
            XSSFRow row = sheet.createRow(i+1);
            row.createCell(0).setCellValue(drugList.get(i).getIntValue("yindex"));
            row.createCell(1).setCellValue(drugList.get(i).getString("medicine"));
            row.createCell(2).setCellValue(drugList.get(i).getIntValue("dose"));
        }
        FileOutputStream os = new FileOutputStream(path);
        workbook.write(os);
        os.close();
    }
    /**
     * 将问诊信息导出到Word文档
     * @param path
     * @param inquiryInfoVOArrayList
     * @throws Exception
     */
    public static void printToWord(String path, List<InquiryInfoVO> inquiryInfoVOArrayList) throws Exception {
        /** 创建Document对象（word文档） author:yyli Sep 15, 2010 */
        com.lowagie.text.Document doc = new Document();
        /** 新建字节数组输出流 author:yyli Sep 15, 2010 */
        RtfWriter2.getInstance(doc, new FileOutputStream(path));
        doc.open();
        //每个问诊在word中创建一个页面

        for (int i = 0; i <inquiryInfoVOArrayList.size() ; i++) {
            addPage(doc,inquiryInfoVOArrayList.get(i),i);
        }
        doc.close();
    }
    public static void addPage(Document doc, InquiryInfoVO infoVO, int index) throws Exception {
        if (index>0){
            doc.newPage();
        }
        String name = "姓名:"+infoVO.getpName();
        String gender = "性别:"+infoVO.getGender();
        String age = "年龄:"+infoVO.getAge();
        String residence = "来源地:"+infoVO.getResisdence();
        String date = "就诊时间:"+infoVO.getDate();
        String baseContent = name+"   "+gender+"   "+age+"   "+residence+"   "+date;
        doc.add(newTable("基本信息","",baseContent));

        String diagnose = infoVO.getDiagnoseLabel();
        doc.add(newTable("诊断标签","",diagnose));

        String description = infoVO.getDescription();
        doc.add(newTable("病情描述","",description));

        List<MainRecipeVO> mainRecipeVOList = infoVO.getMainReList();
        //如果存在主方
        if (mainRecipeVOList.size()>0){
            //遍历生成主方表格
            for (int i = 0; i <mainRecipeVOList.size() ; i++) {
                MainRecipeVO mainRecipeVO = mainRecipeVOList.get(i);
                //主方表格
                String lable0 = "主方"+(i+1);
                if (!mainRecipeVO.getRemarks().equals("")){
                    lable0 = lable0 + "(" + mainRecipeVO.getRemarks()+")";
                }
                List<RecipeDetail> recipeDetailList = mainRecipeVO.getRecipeDetailList();
                Paragraph paragraph = new Paragraph();

                doc.add(newTableForRecipe(lable0,mainRecipeVO.getAmount()+"付",recipeDetailList));

                //获取该主方的副方并生成其表格
                List<ViceRecipeVO> viceRecipeVOList = mainRecipeVO.getViceReList();
                if (viceRecipeVOList.size()>0){
                    //遍历生成副方表格
                    for (int j = 0; j < viceRecipeVOList.size(); j++) {
                        ViceRecipeVO viceRecipeVO = viceRecipeVOList.get(j);
                        lable0 = "副方"+(j+1);
                        if (!viceRecipeVO.getRemarks().equals("")){
                            lable0 = lable0 + "(" + viceRecipeVO.getRemarks()+")";
                        }
                        List<ViceRecipeDetail> viceRecipeDetailList = viceRecipeVO.getViceRecipeDetailList();
                        doc.add(newTableForViceRecipe(lable0,viceRecipeVO.getAmount()+"付",viceRecipeDetailList));
                    }
                }
            }
        }
    }
    public static Table newTable(String lable0, String lable1, String content) throws Exception {
        Table table = new Table(1);
        //int width[]={9,1};
        //table.setWidths(width);
        table.setWidth(100);
        table.setAutoFillEmptyCells(true);
        table.getDefaultCell().setBorder(Cell.BOTTOM);
        Cell cellLable0 = new Cell(lable0);
        table.addCell(cellLable0);
        /*Cell cellLable1 = new Cell(lable1);
        cellLable1.setHorizontalAlignment(Element.ALIGN_RIGHT);
        table.addCell(cellLable1);*/

        Cell contentCell = new Cell(content);
        contentCell.setBorder(Cell.NO_BORDER);
        table.addCell(contentCell);

        /*Cell emptyCell = new Cell("");
        emptyCell.setBorder(Cell.NO_BORDER);
        table.addCell(emptyCell);*/
        return table;
    }
    public static Table newTableForRecipe(String lable0, String lable1,List<RecipeDetail> recipeDetailList) throws Exception {
        Table table = new Table(4);
        int width[]={1,1,1,1};
        table.setWidths(width);
        table.setWidth(100);
        table.getDefaultCell().setBorder(Cell.NO_BORDER);
        String[] lables = {lable0,"",lable1};
        for (int i = 0; i <3 ; i++) {
            Cell cell = new Cell(lables[i]);
            cell.setBorder(Cell.BOTTOM);
            if (i == 2){
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            }
            if (i == 0){
                cell.setRowspan(1);
                cell.setColspan(2);
            }
            table.addCell(cell);
        }

        //将药方中的药依次放入表格中
        for (int i = 0; i < recipeDetailList.size(); i++) {
            RecipeDetail recipeDetail = recipeDetailList.get(i);
            String medicine = "";
            medicine = recipeDetail.getMedicine();
            if (!(recipeDetail.getRemark()==null)){
                medicine = medicine +'\n'+"("+recipeDetail.getRemark()+")";
            }
            Cell cell = new Cell(medicine);

            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
        }
        if (recipeDetailList.size()%4!=0){
            for (int i = 0; i <4-recipeDetailList.size()%4 ; i++) {
                Cell cell = new Cell("");
                cell.setBorder(cell.NO_BORDER);
                table.addCell(cell);
            }
        }
        return table;
    }
    public static Table newTableForViceRecipe(String lable0, String lable1,List<ViceRecipeDetail> recipeDetailList) throws Exception {
        Table table = new Table(4);
        int width[]={1,1,1,1};
        table.setWidths(width);
        table.setWidth(100);
        table.getDefaultCell().setBorder(Cell.NO_BORDER);
        String[] lables = {lable0,"",lable1};
        for (int i = 0; i <3 ; i++) {
            Cell cell = new Cell(lables[i]);
            cell.setBorder(Cell.BOTTOM);
            if (i==2){
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);;
            }
            if (i == 0){
                cell.setRowspan(1);
                cell.setColspan(2);
            }
            table.addCell(cell);
        }
        //将药方中的药依次放入表格中
        for (int i = 0; i < recipeDetailList.size(); i++) {
            ViceRecipeDetail recipeDetail = recipeDetailList.get(i);
            String medicine = "";
            medicine = recipeDetail.getMedicine();
            if (!(recipeDetail.getRemark()==null)){
                medicine = medicine +'\n'+"("+recipeDetail.getRemark()+")";
            }
            Cell cell = new Cell(medicine);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

        }
        if (recipeDetailList.size()%4!=0){
            for (int i = 0; i <4-recipeDetailList.size()%4 ; i++) {
                Cell cell = new Cell("");
                cell.setBorder(cell.NO_BORDER);
                table.addCell(cell);
            }
        }
        return table;
    }

}
