package com.gluxen.PO;

import java.io.Serializable;

/**
 * patient
 * @author 
 */
public class PatientWithBLOBs extends Patient implements Serializable {
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

    private static final long serialVersionUID = 1L;

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
        PatientWithBLOBs other = (PatientWithBLOBs) that;
        return (this.getPatientId() == null ? other.getPatientId() == null : this.getPatientId().equals(other.getPatientId()))
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
            && (this.getContactHistory() == null ? other.getContactHistory() == null : this.getContactHistory().equals(other.getContactHistory()))
            && (this.getChRemark() == null ? other.getChRemark() == null : this.getChRemark().equals(other.getChRemark()))
            && (this.getMeAllergy() == null ? other.getMeAllergy() == null : this.getMeAllergy().equals(other.getMeAllergy()))
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
            && (this.getTraumaHistory() == null ? other.getTraumaHistory() == null : this.getTraumaHistory().equals(other.getTraumaHistory()))
            && (this.getSurgeryHistory() == null ? other.getSurgeryHistory() == null : this.getSurgeryHistory().equals(other.getSurgeryHistory()))
            && (this.getFamilyHistory() == null ? other.getFamilyHistory() == null : this.getFamilyHistory().equals(other.getFamilyHistory()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
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
        result = prime * result + ((getContactHistory() == null) ? 0 : getContactHistory().hashCode());
        result = prime * result + ((getChRemark() == null) ? 0 : getChRemark().hashCode());
        result = prime * result + ((getMeAllergy() == null) ? 0 : getMeAllergy().hashCode());
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
        result = prime * result + ((getTraumaHistory() == null) ? 0 : getTraumaHistory().hashCode());
        result = prime * result + ((getSurgeryHistory() == null) ? 0 : getSurgeryHistory().hashCode());
        result = prime * result + ((getFamilyHistory() == null) ? 0 : getFamilyHistory().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", traumaHistory=").append(traumaHistory);
        sb.append(", surgeryHistory=").append(surgeryHistory);
        sb.append(", familyHistory=").append(familyHistory);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}