package com.gluxen.PO;

import java.io.Serializable;
import java.util.Date;

/**
 * patient
 * @author 
 */
public class Patient implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 病人Id
     */
    private Long patientId;

    /**
     * 证件类型
     */
    private String certificatesType;

    /**
     * 证件编号
     */
    private String certificatesNumber;

    /**
     * 姓名
     */
    private String pname;

    /**
     * 性别
     */
    private String gender;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 国籍
     */
    private String nationality;

    /**
     * 民族
     */
    private String national;

    /**
     * 出生地点
     */
    private String incunabulum;

    /**
     * 来源地
     */
    private String residence;

    /**
     * 身高
     */
    private Integer height;

    /**
     * 体重
     */
    private Integer weight;

    /**
     * 职业
     */
    private String occupation;

    /**
     * 婚姻史
     */
    private String marriage;

    /**
     * 宗教信仰
     */
    private String religiousBelief;

    /**
     * 饮食习惯
     */
    private String eatingHabits;

    /**
     * 饮食习惯备注
     */
    private String ehRemark;

    /**
     * 遗传病史
     */
    private String heredityHistory;

    /**
     * 遗传病史备注
     */
    private String hhRemark;

    /**
     * 传染病史
     */
    private String infectionHistory;

    /**
     * 传染病史备注
     */
    private String ihRemark;

    /**
     * 外伤史
     */
    private String traumaHistory;

    /**
     * 手术史
     */
    private String surgeryHistory;

    /**
     * 家人病史
     */
    private String familyHistory;

    /**
     * 接触史
     */
    private String contactHistory;

    /**
     * 接触史备注
     */
    private String chRemark;

    /**
     * 药物过敏
     */
    private String meAllergy;

    /**
     * 药物过敏备注
     */
    private String meallRemark;

    /**
     * 过敏物
     */
    private String allergy;

    /**
     * 过敏物备注
     */
    private String allRemark;

    /**
     * 输血史
     */
    private String bloodTrans;

    /**
     * 吸烟史
     */
    private String smoke;

    /**
     * 每日吸烟
     */
    private Integer dailySmoke;

    /**
     * 戒烟否
     */
    private String quitSmoke;

    /**
     * 怀孕
     */
    private Integer pregnant;

    /**
     * 生育
     */
    private Integer birth;

    /**
     * 早产
     */
    private String prematureLabour;

    /**
     * 流产
     */
    private String abortion;

    /**
     * 建档日期
     */
    private Date insertDate;

    /**
     * 来源省份
     */
    private Integer sourceProvince;

    /**
     * 来源城市
     */
    private Integer sourceCity;

    /**
     * 出生省份
     */
    private Integer incuProvince;

    /**
     * 出生城市
     */
    private Integer incuCity;

    /**
     * 戒烟时长
     */
    private String quitSmokeTime;

    /**
     * 避孕
     */
    private String contraception;

    /**
     * 饮酒史
     */
    private String drink;

    /**
     * 每日饮酒
     */
    private Integer dailyDrink;

    /**
     * 戒酒
     */
    private String quitDrink;

    /**
     * 戒酒时长
     */
    private String quitDrinkTime;

    /**
     * 问诊日期
     */
    private Date iqDate;

    /**
     * 是否删除
     */
    private Integer deleteFlag;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getCertificatesType() {
        return certificatesType;
    }

    public void setCertificatesType(String certificatesType) {
        this.certificatesType = certificatesType;
    }

    public String getCertificatesNumber() {
        return certificatesNumber;
    }

    public void setCertificatesNumber(String certificatesNumber) {
        this.certificatesNumber = certificatesNumber;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public String getIncunabulum() {
        return incunabulum;
    }

    public void setIncunabulum(String incunabulum) {
        this.incunabulum = incunabulum;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public String getReligiousBelief() {
        return religiousBelief;
    }

    public void setReligiousBelief(String religiousBelief) {
        this.religiousBelief = religiousBelief;
    }

    public String getEatingHabits() {
        return eatingHabits;
    }

    public void setEatingHabits(String eatingHabits) {
        this.eatingHabits = eatingHabits;
    }

    public String getEhRemark() {
        return ehRemark;
    }

    public void setEhRemark(String ehRemark) {
        this.ehRemark = ehRemark;
    }

    public String getHeredityHistory() {
        return heredityHistory;
    }

    public void setHeredityHistory(String heredityHistory) {
        this.heredityHistory = heredityHistory;
    }

    public String getHhRemark() {
        return hhRemark;
    }

    public void setHhRemark(String hhRemark) {
        this.hhRemark = hhRemark;
    }

    public String getInfectionHistory() {
        return infectionHistory;
    }

    public void setInfectionHistory(String infectionHistory) {
        this.infectionHistory = infectionHistory;
    }

    public String getIhRemark() {
        return ihRemark;
    }

    public void setIhRemark(String ihRemark) {
        this.ihRemark = ihRemark;
    }

    public String getTraumaHistory() {
        return traumaHistory;
    }

    public void setTraumaHistory(String traumaHistory) {
        this.traumaHistory = traumaHistory;
    }

    public String getSurgeryHistory() {
        return surgeryHistory;
    }

    public void setSurgeryHistory(String surgeryHistory) {
        this.surgeryHistory = surgeryHistory;
    }

    public String getFamilyHistory() {
        return familyHistory;
    }

    public void setFamilyHistory(String familyHistory) {
        this.familyHistory = familyHistory;
    }

    public String getContactHistory() {
        return contactHistory;
    }

    public void setContactHistory(String contactHistory) {
        this.contactHistory = contactHistory;
    }

    public String getChRemark() {
        return chRemark;
    }

    public void setChRemark(String chRemark) {
        this.chRemark = chRemark;
    }

    public String getMeAllergy() {
        return meAllergy;
    }

    public void setMeAllergy(String meAllergy) {
        this.meAllergy = meAllergy;
    }

    public String getMeallRemark() {
        return meallRemark;
    }

    public void setMeallRemark(String meallRemark) {
        this.meallRemark = meallRemark;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    public String getAllRemark() {
        return allRemark;
    }

    public void setAllRemark(String allRemark) {
        this.allRemark = allRemark;
    }

    public String getBloodTrans() {
        return bloodTrans;
    }

    public void setBloodTrans(String bloodTrans) {
        this.bloodTrans = bloodTrans;
    }

    public String getSmoke() {
        return smoke;
    }

    public void setSmoke(String smoke) {
        this.smoke = smoke;
    }

    public Integer getDailySmoke() {
        return dailySmoke;
    }

    public void setDailySmoke(Integer dailySmoke) {
        this.dailySmoke = dailySmoke;
    }

    public String getQuitSmoke() {
        return quitSmoke;
    }

    public void setQuitSmoke(String quitSmoke) {
        this.quitSmoke = quitSmoke;
    }

    public Integer getPregnant() {
        return pregnant;
    }

    public void setPregnant(Integer pregnant) {
        this.pregnant = pregnant;
    }

    public Integer getBirth() {
        return birth;
    }

    public void setBirth(Integer birth) {
        this.birth = birth;
    }

    public String getPrematureLabour() {
        return prematureLabour;
    }

    public void setPrematureLabour(String prematureLabour) {
        this.prematureLabour = prematureLabour;
    }

    public String getAbortion() {
        return abortion;
    }

    public void setAbortion(String abortion) {
        this.abortion = abortion;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public Integer getSourceProvince() {
        return sourceProvince;
    }

    public void setSourceProvince(Integer sourceProvince) {
        this.sourceProvince = sourceProvince;
    }

    public Integer getSourceCity() {
        return sourceCity;
    }

    public void setSourceCity(Integer sourceCity) {
        this.sourceCity = sourceCity;
    }

    public Integer getIncuProvince() {
        return incuProvince;
    }

    public void setIncuProvince(Integer incuProvince) {
        this.incuProvince = incuProvince;
    }

    public Integer getIncuCity() {
        return incuCity;
    }

    public void setIncuCity(Integer incuCity) {
        this.incuCity = incuCity;
    }

    public String getQuitSmokeTime() {
        return quitSmokeTime;
    }

    public void setQuitSmokeTime(String quitSmokeTime) {
        this.quitSmokeTime = quitSmokeTime;
    }

    public String getContraception() {
        return contraception;
    }

    public void setContraception(String contraception) {
        this.contraception = contraception;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public Integer getDailyDrink() {
        return dailyDrink;
    }

    public void setDailyDrink(Integer dailyDrink) {
        this.dailyDrink = dailyDrink;
    }

    public String getQuitDrink() {
        return quitDrink;
    }

    public void setQuitDrink(String quitDrink) {
        this.quitDrink = quitDrink;
    }

    public String getQuitDrinkTime() {
        return quitDrinkTime;
    }

    public void setQuitDrinkTime(String quitDrinkTime) {
        this.quitDrinkTime = quitDrinkTime;
    }

    public Date getIqDate() {
        return iqDate;
    }

    public void setIqDate(Date iqDate) {
        this.iqDate = iqDate;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Patient other = (Patient) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPatientId() == null ? other.getPatientId() == null : this.getPatientId().equals(other.getPatientId()))
            && (this.getCertificatesType() == null ? other.getCertificatesType() == null : this.getCertificatesType().equals(other.getCertificatesType()))
            && (this.getCertificatesNumber() == null ? other.getCertificatesNumber() == null : this.getCertificatesNumber().equals(other.getCertificatesNumber()))
            && (this.getPname() == null ? other.getPname() == null : this.getPname().equals(other.getPname()))
            && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()))
            && (this.getAge() == null ? other.getAge() == null : this.getAge().equals(other.getAge()))
            && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
            && (this.getNationality() == null ? other.getNationality() == null : this.getNationality().equals(other.getNationality()))
            && (this.getNational() == null ? other.getNational() == null : this.getNational().equals(other.getNational()))
            && (this.getIncunabulum() == null ? other.getIncunabulum() == null : this.getIncunabulum().equals(other.getIncunabulum()))
            && (this.getResidence() == null ? other.getResidence() == null : this.getResidence().equals(other.getResidence()))
            && (this.getHeight() == null ? other.getHeight() == null : this.getHeight().equals(other.getHeight()))
            && (this.getWeight() == null ? other.getWeight() == null : this.getWeight().equals(other.getWeight()))
            && (this.getOccupation() == null ? other.getOccupation() == null : this.getOccupation().equals(other.getOccupation()))
            && (this.getMarriage() == null ? other.getMarriage() == null : this.getMarriage().equals(other.getMarriage()))
            && (this.getReligiousBelief() == null ? other.getReligiousBelief() == null : this.getReligiousBelief().equals(other.getReligiousBelief()))
            && (this.getEatingHabits() == null ? other.getEatingHabits() == null : this.getEatingHabits().equals(other.getEatingHabits()))
            && (this.getEhRemark() == null ? other.getEhRemark() == null : this.getEhRemark().equals(other.getEhRemark()))
            && (this.getHeredityHistory() == null ? other.getHeredityHistory() == null : this.getHeredityHistory().equals(other.getHeredityHistory()))
            && (this.getHhRemark() == null ? other.getHhRemark() == null : this.getHhRemark().equals(other.getHhRemark()))
            && (this.getInfectionHistory() == null ? other.getInfectionHistory() == null : this.getInfectionHistory().equals(other.getInfectionHistory()))
            && (this.getIhRemark() == null ? other.getIhRemark() == null : this.getIhRemark().equals(other.getIhRemark()))
            && (this.getTraumaHistory() == null ? other.getTraumaHistory() == null : this.getTraumaHistory().equals(other.getTraumaHistory()))
            && (this.getSurgeryHistory() == null ? other.getSurgeryHistory() == null : this.getSurgeryHistory().equals(other.getSurgeryHistory()))
            && (this.getFamilyHistory() == null ? other.getFamilyHistory() == null : this.getFamilyHistory().equals(other.getFamilyHistory()))
            && (this.getContactHistory() == null ? other.getContactHistory() == null : this.getContactHistory().equals(other.getContactHistory()))
            && (this.getChRemark() == null ? other.getChRemark() == null : this.getChRemark().equals(other.getChRemark()))
            && (this.getMeAllergy() == null ? other.getMeAllergy() == null : this.getMeAllergy().equals(other.getMeAllergy()))
            && (this.getMeallRemark() == null ? other.getMeallRemark() == null : this.getMeallRemark().equals(other.getMeallRemark()))
            && (this.getAllergy() == null ? other.getAllergy() == null : this.getAllergy().equals(other.getAllergy()))
            && (this.getAllRemark() == null ? other.getAllRemark() == null : this.getAllRemark().equals(other.getAllRemark()))
            && (this.getBloodTrans() == null ? other.getBloodTrans() == null : this.getBloodTrans().equals(other.getBloodTrans()))
            && (this.getSmoke() == null ? other.getSmoke() == null : this.getSmoke().equals(other.getSmoke()))
            && (this.getDailySmoke() == null ? other.getDailySmoke() == null : this.getDailySmoke().equals(other.getDailySmoke()))
            && (this.getQuitSmoke() == null ? other.getQuitSmoke() == null : this.getQuitSmoke().equals(other.getQuitSmoke()))
            && (this.getPregnant() == null ? other.getPregnant() == null : this.getPregnant().equals(other.getPregnant()))
            && (this.getBirth() == null ? other.getBirth() == null : this.getBirth().equals(other.getBirth()))
            && (this.getPrematureLabour() == null ? other.getPrematureLabour() == null : this.getPrematureLabour().equals(other.getPrematureLabour()))
            && (this.getAbortion() == null ? other.getAbortion() == null : this.getAbortion().equals(other.getAbortion()))
            && (this.getInsertDate() == null ? other.getInsertDate() == null : this.getInsertDate().equals(other.getInsertDate()))
            && (this.getSourceProvince() == null ? other.getSourceProvince() == null : this.getSourceProvince().equals(other.getSourceProvince()))
            && (this.getSourceCity() == null ? other.getSourceCity() == null : this.getSourceCity().equals(other.getSourceCity()))
            && (this.getIncuProvince() == null ? other.getIncuProvince() == null : this.getIncuProvince().equals(other.getIncuProvince()))
            && (this.getIncuCity() == null ? other.getIncuCity() == null : this.getIncuCity().equals(other.getIncuCity()))
            && (this.getQuitSmokeTime() == null ? other.getQuitSmokeTime() == null : this.getQuitSmokeTime().equals(other.getQuitSmokeTime()))
            && (this.getContraception() == null ? other.getContraception() == null : this.getContraception().equals(other.getContraception()))
            && (this.getDrink() == null ? other.getDrink() == null : this.getDrink().equals(other.getDrink()))
            && (this.getDailyDrink() == null ? other.getDailyDrink() == null : this.getDailyDrink().equals(other.getDailyDrink()))
            && (this.getQuitDrink() == null ? other.getQuitDrink() == null : this.getQuitDrink().equals(other.getQuitDrink()))
            && (this.getQuitDrinkTime() == null ? other.getQuitDrinkTime() == null : this.getQuitDrinkTime().equals(other.getQuitDrinkTime()))
            && (this.getIqDate() == null ? other.getIqDate() == null : this.getIqDate().equals(other.getIqDate()))
            && (this.getDeleteFlag() == null ? other.getDeleteFlag() == null : this.getDeleteFlag().equals(other.getDeleteFlag()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPatientId() == null) ? 0 : getPatientId().hashCode());
        result = prime * result + ((getCertificatesType() == null) ? 0 : getCertificatesType().hashCode());
        result = prime * result + ((getCertificatesNumber() == null) ? 0 : getCertificatesNumber().hashCode());
        result = prime * result + ((getPname() == null) ? 0 : getPname().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        result = prime * result + ((getAge() == null) ? 0 : getAge().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getNationality() == null) ? 0 : getNationality().hashCode());
        result = prime * result + ((getNational() == null) ? 0 : getNational().hashCode());
        result = prime * result + ((getIncunabulum() == null) ? 0 : getIncunabulum().hashCode());
        result = prime * result + ((getResidence() == null) ? 0 : getResidence().hashCode());
        result = prime * result + ((getHeight() == null) ? 0 : getHeight().hashCode());
        result = prime * result + ((getWeight() == null) ? 0 : getWeight().hashCode());
        result = prime * result + ((getOccupation() == null) ? 0 : getOccupation().hashCode());
        result = prime * result + ((getMarriage() == null) ? 0 : getMarriage().hashCode());
        result = prime * result + ((getReligiousBelief() == null) ? 0 : getReligiousBelief().hashCode());
        result = prime * result + ((getEatingHabits() == null) ? 0 : getEatingHabits().hashCode());
        result = prime * result + ((getEhRemark() == null) ? 0 : getEhRemark().hashCode());
        result = prime * result + ((getHeredityHistory() == null) ? 0 : getHeredityHistory().hashCode());
        result = prime * result + ((getHhRemark() == null) ? 0 : getHhRemark().hashCode());
        result = prime * result + ((getInfectionHistory() == null) ? 0 : getInfectionHistory().hashCode());
        result = prime * result + ((getIhRemark() == null) ? 0 : getIhRemark().hashCode());
        result = prime * result + ((getTraumaHistory() == null) ? 0 : getTraumaHistory().hashCode());
        result = prime * result + ((getSurgeryHistory() == null) ? 0 : getSurgeryHistory().hashCode());
        result = prime * result + ((getFamilyHistory() == null) ? 0 : getFamilyHistory().hashCode());
        result = prime * result + ((getContactHistory() == null) ? 0 : getContactHistory().hashCode());
        result = prime * result + ((getChRemark() == null) ? 0 : getChRemark().hashCode());
        result = prime * result + ((getMeAllergy() == null) ? 0 : getMeAllergy().hashCode());
        result = prime * result + ((getMeallRemark() == null) ? 0 : getMeallRemark().hashCode());
        result = prime * result + ((getAllergy() == null) ? 0 : getAllergy().hashCode());
        result = prime * result + ((getAllRemark() == null) ? 0 : getAllRemark().hashCode());
        result = prime * result + ((getBloodTrans() == null) ? 0 : getBloodTrans().hashCode());
        result = prime * result + ((getSmoke() == null) ? 0 : getSmoke().hashCode());
        result = prime * result + ((getDailySmoke() == null) ? 0 : getDailySmoke().hashCode());
        result = prime * result + ((getQuitSmoke() == null) ? 0 : getQuitSmoke().hashCode());
        result = prime * result + ((getPregnant() == null) ? 0 : getPregnant().hashCode());
        result = prime * result + ((getBirth() == null) ? 0 : getBirth().hashCode());
        result = prime * result + ((getPrematureLabour() == null) ? 0 : getPrematureLabour().hashCode());
        result = prime * result + ((getAbortion() == null) ? 0 : getAbortion().hashCode());
        result = prime * result + ((getInsertDate() == null) ? 0 : getInsertDate().hashCode());
        result = prime * result + ((getSourceProvince() == null) ? 0 : getSourceProvince().hashCode());
        result = prime * result + ((getSourceCity() == null) ? 0 : getSourceCity().hashCode());
        result = prime * result + ((getIncuProvince() == null) ? 0 : getIncuProvince().hashCode());
        result = prime * result + ((getIncuCity() == null) ? 0 : getIncuCity().hashCode());
        result = prime * result + ((getQuitSmokeTime() == null) ? 0 : getQuitSmokeTime().hashCode());
        result = prime * result + ((getContraception() == null) ? 0 : getContraception().hashCode());
        result = prime * result + ((getDrink() == null) ? 0 : getDrink().hashCode());
        result = prime * result + ((getDailyDrink() == null) ? 0 : getDailyDrink().hashCode());
        result = prime * result + ((getQuitDrink() == null) ? 0 : getQuitDrink().hashCode());
        result = prime * result + ((getQuitDrinkTime() == null) ? 0 : getQuitDrinkTime().hashCode());
        result = prime * result + ((getIqDate() == null) ? 0 : getIqDate().hashCode());
        result = prime * result + ((getDeleteFlag() == null) ? 0 : getDeleteFlag().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", patientId=").append(patientId);
        sb.append(", certificatesType=").append(certificatesType);
        sb.append(", certificatesNumber=").append(certificatesNumber);
        sb.append(", pname=").append(pname);
        sb.append(", gender=").append(gender);
        sb.append(", age=").append(age);
        sb.append(", birthday=").append(birthday);
        sb.append(", nationality=").append(nationality);
        sb.append(", national=").append(national);
        sb.append(", incunabulum=").append(incunabulum);
        sb.append(", residence=").append(residence);
        sb.append(", height=").append(height);
        sb.append(", weight=").append(weight);
        sb.append(", occupation=").append(occupation);
        sb.append(", marriage=").append(marriage);
        sb.append(", religiousBelief=").append(religiousBelief);
        sb.append(", eatingHabits=").append(eatingHabits);
        sb.append(", ehRemark=").append(ehRemark);
        sb.append(", heredityHistory=").append(heredityHistory);
        sb.append(", hhRemark=").append(hhRemark);
        sb.append(", infectionHistory=").append(infectionHistory);
        sb.append(", ihRemark=").append(ihRemark);
        sb.append(", traumaHistory=").append(traumaHistory);
        sb.append(", surgeryHistory=").append(surgeryHistory);
        sb.append(", familyHistory=").append(familyHistory);
        sb.append(", contactHistory=").append(contactHistory);
        sb.append(", chRemark=").append(chRemark);
        sb.append(", meAllergy=").append(meAllergy);
        sb.append(", meallRemark=").append(meallRemark);
        sb.append(", allergy=").append(allergy);
        sb.append(", allRemark=").append(allRemark);
        sb.append(", bloodTrans=").append(bloodTrans);
        sb.append(", smoke=").append(smoke);
        sb.append(", dailySmoke=").append(dailySmoke);
        sb.append(", quitSmoke=").append(quitSmoke);
        sb.append(", pregnant=").append(pregnant);
        sb.append(", birth=").append(birth);
        sb.append(", prematureLabour=").append(prematureLabour);
        sb.append(", abortion=").append(abortion);
        sb.append(", insertDate=").append(insertDate);
        sb.append(", sourceProvince=").append(sourceProvince);
        sb.append(", sourceCity=").append(sourceCity);
        sb.append(", incuProvince=").append(incuProvince);
        sb.append(", incuCity=").append(incuCity);
        sb.append(", quitSmokeTime=").append(quitSmokeTime);
        sb.append(", contraception=").append(contraception);
        sb.append(", drink=").append(drink);
        sb.append(", dailyDrink=").append(dailyDrink);
        sb.append(", quitDrink=").append(quitDrink);
        sb.append(", quitDrinkTime=").append(quitDrinkTime);
        sb.append(", iqDate=").append(iqDate);
        sb.append(", deleteFlag=").append(deleteFlag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}