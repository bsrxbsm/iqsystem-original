package com.gluxen.PO;

import java.io.Serializable;

/**
 * city
 * @author 
 */
public class City implements Serializable {

    private Integer cityId;

    private String cityName;

    private static final long serialVersionUID = 1L;



    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }





    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());

        sb.append(", cityId=").append(cityId);
        sb.append(", cityName=").append(cityName);

        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}