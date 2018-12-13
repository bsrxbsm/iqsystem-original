package com.gluxen.VO;

import com.gluxen.PO.City;

import java.util.List;

/**
 * Created by Yang Xing Luo on 2018/8/5.
 */
public class Place{
    private Integer id;

    private String provName;

    private List<City> cityList;


    /**
     * 1 - 直辖市
     2 - 行政省
     3 - 自治区
     4 - 特别行政区
     5 - 其他国家
     见全局数据字典[省份类型]

     */


    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }




    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getProvName() {
        return provName;
    }

    public void setProvName(String provName) {
        this.provName = provName;
    }



}
