package com.gluxen.PO;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PatientExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public PatientExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPatientIdIsNull() {
            addCriterion("patient_id is null");
            return (Criteria) this;
        }

        public Criteria andPatientIdIsNotNull() {
            addCriterion("patient_id is not null");
            return (Criteria) this;
        }

        public Criteria andPatientIdEqualTo(Long value) {
            addCriterion("patient_id =", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdNotEqualTo(Long value) {
            addCriterion("patient_id <>", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdGreaterThan(Long value) {
            addCriterion("patient_id >", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdGreaterThanOrEqualTo(Long value) {
            addCriterion("patient_id >=", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdLessThan(Long value) {
            addCriterion("patient_id <", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdLessThanOrEqualTo(Long value) {
            addCriterion("patient_id <=", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdIn(List<Long> values) {
            addCriterion("patient_id in", values, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdNotIn(List<Long> values) {
            addCriterion("patient_id not in", values, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdBetween(Long value1, Long value2) {
            addCriterion("patient_id between", value1, value2, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdNotBetween(Long value1, Long value2) {
            addCriterion("patient_id not between", value1, value2, "patientId");
            return (Criteria) this;
        }

        public Criteria andCertificatesTypeIsNull() {
            addCriterion("certificates_type is null");
            return (Criteria) this;
        }

        public Criteria andCertificatesTypeIsNotNull() {
            addCriterion("certificates_type is not null");
            return (Criteria) this;
        }

        public Criteria andCertificatesTypeEqualTo(String value) {
            addCriterion("certificates_type =", value, "certificatesType");
            return (Criteria) this;
        }

        public Criteria andCertificatesTypeNotEqualTo(String value) {
            addCriterion("certificates_type <>", value, "certificatesType");
            return (Criteria) this;
        }

        public Criteria andCertificatesTypeGreaterThan(String value) {
            addCriterion("certificates_type >", value, "certificatesType");
            return (Criteria) this;
        }

        public Criteria andCertificatesTypeGreaterThanOrEqualTo(String value) {
            addCriterion("certificates_type >=", value, "certificatesType");
            return (Criteria) this;
        }

        public Criteria andCertificatesTypeLessThan(String value) {
            addCriterion("certificates_type <", value, "certificatesType");
            return (Criteria) this;
        }

        public Criteria andCertificatesTypeLessThanOrEqualTo(String value) {
            addCriterion("certificates_type <=", value, "certificatesType");
            return (Criteria) this;
        }

        public Criteria andCertificatesTypeLike(String value) {
            addCriterion("certificates_type like", value, "certificatesType");
            return (Criteria) this;
        }

        public Criteria andCertificatesTypeNotLike(String value) {
            addCriterion("certificates_type not like", value, "certificatesType");
            return (Criteria) this;
        }

        public Criteria andCertificatesTypeIn(List<String> values) {
            addCriterion("certificates_type in", values, "certificatesType");
            return (Criteria) this;
        }

        public Criteria andCertificatesTypeNotIn(List<String> values) {
            addCriterion("certificates_type not in", values, "certificatesType");
            return (Criteria) this;
        }

        public Criteria andCertificatesTypeBetween(String value1, String value2) {
            addCriterion("certificates_type between", value1, value2, "certificatesType");
            return (Criteria) this;
        }

        public Criteria andCertificatesTypeNotBetween(String value1, String value2) {
            addCriterion("certificates_type not between", value1, value2, "certificatesType");
            return (Criteria) this;
        }

        public Criteria andCertificatesNumberIsNull() {
            addCriterion("certificates_number is null");
            return (Criteria) this;
        }

        public Criteria andCertificatesNumberIsNotNull() {
            addCriterion("certificates_number is not null");
            return (Criteria) this;
        }

        public Criteria andCertificatesNumberEqualTo(String value) {
            addCriterion("certificates_number =", value, "certificatesNumber");
            return (Criteria) this;
        }

        public Criteria andCertificatesNumberNotEqualTo(String value) {
            addCriterion("certificates_number <>", value, "certificatesNumber");
            return (Criteria) this;
        }

        public Criteria andCertificatesNumberGreaterThan(String value) {
            addCriterion("certificates_number >", value, "certificatesNumber");
            return (Criteria) this;
        }

        public Criteria andCertificatesNumberGreaterThanOrEqualTo(String value) {
            addCriterion("certificates_number >=", value, "certificatesNumber");
            return (Criteria) this;
        }

        public Criteria andCertificatesNumberLessThan(String value) {
            addCriterion("certificates_number <", value, "certificatesNumber");
            return (Criteria) this;
        }

        public Criteria andCertificatesNumberLessThanOrEqualTo(String value) {
            addCriterion("certificates_number <=", value, "certificatesNumber");
            return (Criteria) this;
        }

        public Criteria andCertificatesNumberLike(String value) {
            addCriterion("certificates_number like", value, "certificatesNumber");
            return (Criteria) this;
        }

        public Criteria andCertificatesNumberNotLike(String value) {
            addCriterion("certificates_number not like", value, "certificatesNumber");
            return (Criteria) this;
        }

        public Criteria andCertificatesNumberIn(List<String> values) {
            addCriterion("certificates_number in", values, "certificatesNumber");
            return (Criteria) this;
        }

        public Criteria andCertificatesNumberNotIn(List<String> values) {
            addCriterion("certificates_number not in", values, "certificatesNumber");
            return (Criteria) this;
        }

        public Criteria andCertificatesNumberBetween(String value1, String value2) {
            addCriterion("certificates_number between", value1, value2, "certificatesNumber");
            return (Criteria) this;
        }

        public Criteria andCertificatesNumberNotBetween(String value1, String value2) {
            addCriterion("certificates_number not between", value1, value2, "certificatesNumber");
            return (Criteria) this;
        }

        public Criteria andPnameIsNull() {
            addCriterion("pname is null");
            return (Criteria) this;
        }

        public Criteria andPnameIsNotNull() {
            addCriterion("pname is not null");
            return (Criteria) this;
        }

        public Criteria andPnameEqualTo(String value) {
            addCriterion("pname =", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotEqualTo(String value) {
            addCriterion("pname <>", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameGreaterThan(String value) {
            addCriterion("pname >", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameGreaterThanOrEqualTo(String value) {
            addCriterion("pname >=", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameLessThan(String value) {
            addCriterion("pname <", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameLessThanOrEqualTo(String value) {
            addCriterion("pname <=", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameLike(String value) {
            addCriterion("pname like", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotLike(String value) {
            addCriterion("pname not like", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameIn(List<String> values) {
            addCriterion("pname in", values, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotIn(List<String> values) {
            addCriterion("pname not in", values, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameBetween(String value1, String value2) {
            addCriterion("pname between", value1, value2, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotBetween(String value1, String value2) {
            addCriterion("pname not between", value1, value2, "pname");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(String value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(String value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(String value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(String value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(String value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(String value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLike(String value) {
            addCriterion("gender like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotLike(String value) {
            addCriterion("gender not like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<String> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<String> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(String value1, String value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(String value1, String value2) {
            addCriterion("gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andAgeIsNull() {
            addCriterion("age is null");
            return (Criteria) this;
        }

        public Criteria andAgeIsNotNull() {
            addCriterion("age is not null");
            return (Criteria) this;
        }

        public Criteria andAgeEqualTo(Integer value) {
            addCriterion("age =", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(Integer value) {
            addCriterion("age <>", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThan(Integer value) {
            addCriterion("age >", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("age >=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThan(Integer value) {
            addCriterion("age <", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThanOrEqualTo(Integer value) {
            addCriterion("age <=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeIn(List<Integer> values) {
            addCriterion("age in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<Integer> values) {
            addCriterion("age not in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeBetween(Integer value1, Integer value2) {
            addCriterion("age between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("age not between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(Date value) {
            addCriterionForJDBCDate("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(Date value) {
            addCriterionForJDBCDate("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(Date value) {
            addCriterionForJDBCDate("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<Date> values) {
            addCriterionForJDBCDate("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andNationalityIsNull() {
            addCriterion("nationality is null");
            return (Criteria) this;
        }

        public Criteria andNationalityIsNotNull() {
            addCriterion("nationality is not null");
            return (Criteria) this;
        }

        public Criteria andNationalityEqualTo(String value) {
            addCriterion("nationality =", value, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityNotEqualTo(String value) {
            addCriterion("nationality <>", value, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityGreaterThan(String value) {
            addCriterion("nationality >", value, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityGreaterThanOrEqualTo(String value) {
            addCriterion("nationality >=", value, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityLessThan(String value) {
            addCriterion("nationality <", value, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityLessThanOrEqualTo(String value) {
            addCriterion("nationality <=", value, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityLike(String value) {
            addCriterion("nationality like", value, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityNotLike(String value) {
            addCriterion("nationality not like", value, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityIn(List<String> values) {
            addCriterion("nationality in", values, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityNotIn(List<String> values) {
            addCriterion("nationality not in", values, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityBetween(String value1, String value2) {
            addCriterion("nationality between", value1, value2, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityNotBetween(String value1, String value2) {
            addCriterion("nationality not between", value1, value2, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalIsNull() {
            addCriterion("`national` is null");
            return (Criteria) this;
        }

        public Criteria andNationalIsNotNull() {
            addCriterion("`national` is not null");
            return (Criteria) this;
        }

        public Criteria andNationalEqualTo(String value) {
            addCriterion("`national` =", value, "national");
            return (Criteria) this;
        }

        public Criteria andNationalNotEqualTo(String value) {
            addCriterion("`national` <>", value, "national");
            return (Criteria) this;
        }

        public Criteria andNationalGreaterThan(String value) {
            addCriterion("`national` >", value, "national");
            return (Criteria) this;
        }

        public Criteria andNationalGreaterThanOrEqualTo(String value) {
            addCriterion("`national` >=", value, "national");
            return (Criteria) this;
        }

        public Criteria andNationalLessThan(String value) {
            addCriterion("`national` <", value, "national");
            return (Criteria) this;
        }

        public Criteria andNationalLessThanOrEqualTo(String value) {
            addCriterion("`national` <=", value, "national");
            return (Criteria) this;
        }

        public Criteria andNationalLike(String value) {
            addCriterion("`national` like", value, "national");
            return (Criteria) this;
        }

        public Criteria andNationalNotLike(String value) {
            addCriterion("`national` not like", value, "national");
            return (Criteria) this;
        }

        public Criteria andNationalIn(List<String> values) {
            addCriterion("`national` in", values, "national");
            return (Criteria) this;
        }

        public Criteria andNationalNotIn(List<String> values) {
            addCriterion("`national` not in", values, "national");
            return (Criteria) this;
        }

        public Criteria andNationalBetween(String value1, String value2) {
            addCriterion("`national` between", value1, value2, "national");
            return (Criteria) this;
        }

        public Criteria andNationalNotBetween(String value1, String value2) {
            addCriterion("`national` not between", value1, value2, "national");
            return (Criteria) this;
        }

        public Criteria andIncunabulumIsNull() {
            addCriterion("incunabulum is null");
            return (Criteria) this;
        }

        public Criteria andIncunabulumIsNotNull() {
            addCriterion("incunabulum is not null");
            return (Criteria) this;
        }

        public Criteria andIncunabulumEqualTo(String value) {
            addCriterion("incunabulum =", value, "incunabulum");
            return (Criteria) this;
        }

        public Criteria andIncunabulumNotEqualTo(String value) {
            addCriterion("incunabulum <>", value, "incunabulum");
            return (Criteria) this;
        }

        public Criteria andIncunabulumGreaterThan(String value) {
            addCriterion("incunabulum >", value, "incunabulum");
            return (Criteria) this;
        }

        public Criteria andIncunabulumGreaterThanOrEqualTo(String value) {
            addCriterion("incunabulum >=", value, "incunabulum");
            return (Criteria) this;
        }

        public Criteria andIncunabulumLessThan(String value) {
            addCriterion("incunabulum <", value, "incunabulum");
            return (Criteria) this;
        }

        public Criteria andIncunabulumLessThanOrEqualTo(String value) {
            addCriterion("incunabulum <=", value, "incunabulum");
            return (Criteria) this;
        }

        public Criteria andIncunabulumLike(String value) {
            addCriterion("incunabulum like", value, "incunabulum");
            return (Criteria) this;
        }

        public Criteria andIncunabulumNotLike(String value) {
            addCriterion("incunabulum not like", value, "incunabulum");
            return (Criteria) this;
        }

        public Criteria andIncunabulumIn(List<String> values) {
            addCriterion("incunabulum in", values, "incunabulum");
            return (Criteria) this;
        }

        public Criteria andIncunabulumNotIn(List<String> values) {
            addCriterion("incunabulum not in", values, "incunabulum");
            return (Criteria) this;
        }

        public Criteria andIncunabulumBetween(String value1, String value2) {
            addCriterion("incunabulum between", value1, value2, "incunabulum");
            return (Criteria) this;
        }

        public Criteria andIncunabulumNotBetween(String value1, String value2) {
            addCriterion("incunabulum not between", value1, value2, "incunabulum");
            return (Criteria) this;
        }

        public Criteria andResidenceIsNull() {
            addCriterion("residence is null");
            return (Criteria) this;
        }

        public Criteria andResidenceIsNotNull() {
            addCriterion("residence is not null");
            return (Criteria) this;
        }

        public Criteria andResidenceEqualTo(String value) {
            addCriterion("residence =", value, "residence");
            return (Criteria) this;
        }

        public Criteria andResidenceNotEqualTo(String value) {
            addCriterion("residence <>", value, "residence");
            return (Criteria) this;
        }

        public Criteria andResidenceGreaterThan(String value) {
            addCriterion("residence >", value, "residence");
            return (Criteria) this;
        }

        public Criteria andResidenceGreaterThanOrEqualTo(String value) {
            addCriterion("residence >=", value, "residence");
            return (Criteria) this;
        }

        public Criteria andResidenceLessThan(String value) {
            addCriterion("residence <", value, "residence");
            return (Criteria) this;
        }

        public Criteria andResidenceLessThanOrEqualTo(String value) {
            addCriterion("residence <=", value, "residence");
            return (Criteria) this;
        }

        public Criteria andResidenceLike(String value) {
            addCriterion("residence like", value, "residence");
            return (Criteria) this;
        }

        public Criteria andResidenceNotLike(String value) {
            addCriterion("residence not like", value, "residence");
            return (Criteria) this;
        }

        public Criteria andResidenceIn(List<String> values) {
            addCriterion("residence in", values, "residence");
            return (Criteria) this;
        }

        public Criteria andResidenceNotIn(List<String> values) {
            addCriterion("residence not in", values, "residence");
            return (Criteria) this;
        }

        public Criteria andResidenceBetween(String value1, String value2) {
            addCriterion("residence between", value1, value2, "residence");
            return (Criteria) this;
        }

        public Criteria andResidenceNotBetween(String value1, String value2) {
            addCriterion("residence not between", value1, value2, "residence");
            return (Criteria) this;
        }

        public Criteria andHeightIsNull() {
            addCriterion("height is null");
            return (Criteria) this;
        }

        public Criteria andHeightIsNotNull() {
            addCriterion("height is not null");
            return (Criteria) this;
        }

        public Criteria andHeightEqualTo(Integer value) {
            addCriterion("height =", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotEqualTo(Integer value) {
            addCriterion("height <>", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThan(Integer value) {
            addCriterion("height >", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("height >=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThan(Integer value) {
            addCriterion("height <", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThanOrEqualTo(Integer value) {
            addCriterion("height <=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightIn(List<Integer> values) {
            addCriterion("height in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotIn(List<Integer> values) {
            addCriterion("height not in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightBetween(Integer value1, Integer value2) {
            addCriterion("height between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotBetween(Integer value1, Integer value2) {
            addCriterion("height not between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(Integer value) {
            addCriterion("weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(Integer value) {
            addCriterion("weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(Integer value) {
            addCriterion("weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(Integer value) {
            addCriterion("weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(Integer value) {
            addCriterion("weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<Integer> values) {
            addCriterion("weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<Integer> values) {
            addCriterion("weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(Integer value1, Integer value2) {
            addCriterion("weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(Integer value1, Integer value2) {
            addCriterion("weight not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andOccupationIsNull() {
            addCriterion("occupation is null");
            return (Criteria) this;
        }

        public Criteria andOccupationIsNotNull() {
            addCriterion("occupation is not null");
            return (Criteria) this;
        }

        public Criteria andOccupationEqualTo(String value) {
            addCriterion("occupation =", value, "occupation");
            return (Criteria) this;
        }

        public Criteria andOccupationNotEqualTo(String value) {
            addCriterion("occupation <>", value, "occupation");
            return (Criteria) this;
        }

        public Criteria andOccupationGreaterThan(String value) {
            addCriterion("occupation >", value, "occupation");
            return (Criteria) this;
        }

        public Criteria andOccupationGreaterThanOrEqualTo(String value) {
            addCriterion("occupation >=", value, "occupation");
            return (Criteria) this;
        }

        public Criteria andOccupationLessThan(String value) {
            addCriterion("occupation <", value, "occupation");
            return (Criteria) this;
        }

        public Criteria andOccupationLessThanOrEqualTo(String value) {
            addCriterion("occupation <=", value, "occupation");
            return (Criteria) this;
        }

        public Criteria andOccupationLike(String value) {
            addCriterion("occupation like", value, "occupation");
            return (Criteria) this;
        }

        public Criteria andOccupationNotLike(String value) {
            addCriterion("occupation not like", value, "occupation");
            return (Criteria) this;
        }

        public Criteria andOccupationIn(List<String> values) {
            addCriterion("occupation in", values, "occupation");
            return (Criteria) this;
        }

        public Criteria andOccupationNotIn(List<String> values) {
            addCriterion("occupation not in", values, "occupation");
            return (Criteria) this;
        }

        public Criteria andOccupationBetween(String value1, String value2) {
            addCriterion("occupation between", value1, value2, "occupation");
            return (Criteria) this;
        }

        public Criteria andOccupationNotBetween(String value1, String value2) {
            addCriterion("occupation not between", value1, value2, "occupation");
            return (Criteria) this;
        }

        public Criteria andMarriageIsNull() {
            addCriterion("marriage is null");
            return (Criteria) this;
        }

        public Criteria andMarriageIsNotNull() {
            addCriterion("marriage is not null");
            return (Criteria) this;
        }

        public Criteria andMarriageEqualTo(String value) {
            addCriterion("marriage =", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageNotEqualTo(String value) {
            addCriterion("marriage <>", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageGreaterThan(String value) {
            addCriterion("marriage >", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageGreaterThanOrEqualTo(String value) {
            addCriterion("marriage >=", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageLessThan(String value) {
            addCriterion("marriage <", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageLessThanOrEqualTo(String value) {
            addCriterion("marriage <=", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageLike(String value) {
            addCriterion("marriage like", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageNotLike(String value) {
            addCriterion("marriage not like", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageIn(List<String> values) {
            addCriterion("marriage in", values, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageNotIn(List<String> values) {
            addCriterion("marriage not in", values, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageBetween(String value1, String value2) {
            addCriterion("marriage between", value1, value2, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageNotBetween(String value1, String value2) {
            addCriterion("marriage not between", value1, value2, "marriage");
            return (Criteria) this;
        }

        public Criteria andReligiousBeliefIsNull() {
            addCriterion("religious_belief is null");
            return (Criteria) this;
        }

        public Criteria andReligiousBeliefIsNotNull() {
            addCriterion("religious_belief is not null");
            return (Criteria) this;
        }

        public Criteria andReligiousBeliefEqualTo(String value) {
            addCriterion("religious_belief =", value, "religiousBelief");
            return (Criteria) this;
        }

        public Criteria andReligiousBeliefNotEqualTo(String value) {
            addCriterion("religious_belief <>", value, "religiousBelief");
            return (Criteria) this;
        }

        public Criteria andReligiousBeliefGreaterThan(String value) {
            addCriterion("religious_belief >", value, "religiousBelief");
            return (Criteria) this;
        }

        public Criteria andReligiousBeliefGreaterThanOrEqualTo(String value) {
            addCriterion("religious_belief >=", value, "religiousBelief");
            return (Criteria) this;
        }

        public Criteria andReligiousBeliefLessThan(String value) {
            addCriterion("religious_belief <", value, "religiousBelief");
            return (Criteria) this;
        }

        public Criteria andReligiousBeliefLessThanOrEqualTo(String value) {
            addCriterion("religious_belief <=", value, "religiousBelief");
            return (Criteria) this;
        }

        public Criteria andReligiousBeliefLike(String value) {
            addCriterion("religious_belief like", value, "religiousBelief");
            return (Criteria) this;
        }

        public Criteria andReligiousBeliefNotLike(String value) {
            addCriterion("religious_belief not like", value, "religiousBelief");
            return (Criteria) this;
        }

        public Criteria andReligiousBeliefIn(List<String> values) {
            addCriterion("religious_belief in", values, "religiousBelief");
            return (Criteria) this;
        }

        public Criteria andReligiousBeliefNotIn(List<String> values) {
            addCriterion("religious_belief not in", values, "religiousBelief");
            return (Criteria) this;
        }

        public Criteria andReligiousBeliefBetween(String value1, String value2) {
            addCriterion("religious_belief between", value1, value2, "religiousBelief");
            return (Criteria) this;
        }

        public Criteria andReligiousBeliefNotBetween(String value1, String value2) {
            addCriterion("religious_belief not between", value1, value2, "religiousBelief");
            return (Criteria) this;
        }

        public Criteria andEatingHabitsIsNull() {
            addCriterion("eating_habits is null");
            return (Criteria) this;
        }

        public Criteria andEatingHabitsIsNotNull() {
            addCriterion("eating_habits is not null");
            return (Criteria) this;
        }

        public Criteria andEatingHabitsEqualTo(String value) {
            addCriterion("eating_habits =", value, "eatingHabits");
            return (Criteria) this;
        }

        public Criteria andEatingHabitsNotEqualTo(String value) {
            addCriterion("eating_habits <>", value, "eatingHabits");
            return (Criteria) this;
        }

        public Criteria andEatingHabitsGreaterThan(String value) {
            addCriterion("eating_habits >", value, "eatingHabits");
            return (Criteria) this;
        }

        public Criteria andEatingHabitsGreaterThanOrEqualTo(String value) {
            addCriterion("eating_habits >=", value, "eatingHabits");
            return (Criteria) this;
        }

        public Criteria andEatingHabitsLessThan(String value) {
            addCriterion("eating_habits <", value, "eatingHabits");
            return (Criteria) this;
        }

        public Criteria andEatingHabitsLessThanOrEqualTo(String value) {
            addCriterion("eating_habits <=", value, "eatingHabits");
            return (Criteria) this;
        }

        public Criteria andEatingHabitsLike(String value) {
            addCriterion("eating_habits like", value, "eatingHabits");
            return (Criteria) this;
        }

        public Criteria andEatingHabitsNotLike(String value) {
            addCriterion("eating_habits not like", value, "eatingHabits");
            return (Criteria) this;
        }

        public Criteria andEatingHabitsIn(List<String> values) {
            addCriterion("eating_habits in", values, "eatingHabits");
            return (Criteria) this;
        }

        public Criteria andEatingHabitsNotIn(List<String> values) {
            addCriterion("eating_habits not in", values, "eatingHabits");
            return (Criteria) this;
        }

        public Criteria andEatingHabitsBetween(String value1, String value2) {
            addCriterion("eating_habits between", value1, value2, "eatingHabits");
            return (Criteria) this;
        }

        public Criteria andEatingHabitsNotBetween(String value1, String value2) {
            addCriterion("eating_habits not between", value1, value2, "eatingHabits");
            return (Criteria) this;
        }

        public Criteria andEhRemarkIsNull() {
            addCriterion("eh_remark is null");
            return (Criteria) this;
        }

        public Criteria andEhRemarkIsNotNull() {
            addCriterion("eh_remark is not null");
            return (Criteria) this;
        }

        public Criteria andEhRemarkEqualTo(String value) {
            addCriterion("eh_remark =", value, "ehRemark");
            return (Criteria) this;
        }

        public Criteria andEhRemarkNotEqualTo(String value) {
            addCriterion("eh_remark <>", value, "ehRemark");
            return (Criteria) this;
        }

        public Criteria andEhRemarkGreaterThan(String value) {
            addCriterion("eh_remark >", value, "ehRemark");
            return (Criteria) this;
        }

        public Criteria andEhRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("eh_remark >=", value, "ehRemark");
            return (Criteria) this;
        }

        public Criteria andEhRemarkLessThan(String value) {
            addCriterion("eh_remark <", value, "ehRemark");
            return (Criteria) this;
        }

        public Criteria andEhRemarkLessThanOrEqualTo(String value) {
            addCriterion("eh_remark <=", value, "ehRemark");
            return (Criteria) this;
        }

        public Criteria andEhRemarkLike(String value) {
            addCriterion("eh_remark like", value, "ehRemark");
            return (Criteria) this;
        }

        public Criteria andEhRemarkNotLike(String value) {
            addCriterion("eh_remark not like", value, "ehRemark");
            return (Criteria) this;
        }

        public Criteria andEhRemarkIn(List<String> values) {
            addCriterion("eh_remark in", values, "ehRemark");
            return (Criteria) this;
        }

        public Criteria andEhRemarkNotIn(List<String> values) {
            addCriterion("eh_remark not in", values, "ehRemark");
            return (Criteria) this;
        }

        public Criteria andEhRemarkBetween(String value1, String value2) {
            addCriterion("eh_remark between", value1, value2, "ehRemark");
            return (Criteria) this;
        }

        public Criteria andEhRemarkNotBetween(String value1, String value2) {
            addCriterion("eh_remark not between", value1, value2, "ehRemark");
            return (Criteria) this;
        }

        public Criteria andHeredityHistoryIsNull() {
            addCriterion("heredity_history is null");
            return (Criteria) this;
        }

        public Criteria andHeredityHistoryIsNotNull() {
            addCriterion("heredity_history is not null");
            return (Criteria) this;
        }

        public Criteria andHeredityHistoryEqualTo(String value) {
            addCriterion("heredity_history =", value, "heredityHistory");
            return (Criteria) this;
        }

        public Criteria andHeredityHistoryNotEqualTo(String value) {
            addCriterion("heredity_history <>", value, "heredityHistory");
            return (Criteria) this;
        }

        public Criteria andHeredityHistoryGreaterThan(String value) {
            addCriterion("heredity_history >", value, "heredityHistory");
            return (Criteria) this;
        }

        public Criteria andHeredityHistoryGreaterThanOrEqualTo(String value) {
            addCriterion("heredity_history >=", value, "heredityHistory");
            return (Criteria) this;
        }

        public Criteria andHeredityHistoryLessThan(String value) {
            addCriterion("heredity_history <", value, "heredityHistory");
            return (Criteria) this;
        }

        public Criteria andHeredityHistoryLessThanOrEqualTo(String value) {
            addCriterion("heredity_history <=", value, "heredityHistory");
            return (Criteria) this;
        }

        public Criteria andHeredityHistoryLike(String value) {
            addCriterion("heredity_history like", value, "heredityHistory");
            return (Criteria) this;
        }

        public Criteria andHeredityHistoryNotLike(String value) {
            addCriterion("heredity_history not like", value, "heredityHistory");
            return (Criteria) this;
        }

        public Criteria andHeredityHistoryIn(List<String> values) {
            addCriterion("heredity_history in", values, "heredityHistory");
            return (Criteria) this;
        }

        public Criteria andHeredityHistoryNotIn(List<String> values) {
            addCriterion("heredity_history not in", values, "heredityHistory");
            return (Criteria) this;
        }

        public Criteria andHeredityHistoryBetween(String value1, String value2) {
            addCriterion("heredity_history between", value1, value2, "heredityHistory");
            return (Criteria) this;
        }

        public Criteria andHeredityHistoryNotBetween(String value1, String value2) {
            addCriterion("heredity_history not between", value1, value2, "heredityHistory");
            return (Criteria) this;
        }

        public Criteria andHhRemarkIsNull() {
            addCriterion("hh_remark is null");
            return (Criteria) this;
        }

        public Criteria andHhRemarkIsNotNull() {
            addCriterion("hh_remark is not null");
            return (Criteria) this;
        }

        public Criteria andHhRemarkEqualTo(String value) {
            addCriterion("hh_remark =", value, "hhRemark");
            return (Criteria) this;
        }

        public Criteria andHhRemarkNotEqualTo(String value) {
            addCriterion("hh_remark <>", value, "hhRemark");
            return (Criteria) this;
        }

        public Criteria andHhRemarkGreaterThan(String value) {
            addCriterion("hh_remark >", value, "hhRemark");
            return (Criteria) this;
        }

        public Criteria andHhRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("hh_remark >=", value, "hhRemark");
            return (Criteria) this;
        }

        public Criteria andHhRemarkLessThan(String value) {
            addCriterion("hh_remark <", value, "hhRemark");
            return (Criteria) this;
        }

        public Criteria andHhRemarkLessThanOrEqualTo(String value) {
            addCriterion("hh_remark <=", value, "hhRemark");
            return (Criteria) this;
        }

        public Criteria andHhRemarkLike(String value) {
            addCriterion("hh_remark like", value, "hhRemark");
            return (Criteria) this;
        }

        public Criteria andHhRemarkNotLike(String value) {
            addCriterion("hh_remark not like", value, "hhRemark");
            return (Criteria) this;
        }

        public Criteria andHhRemarkIn(List<String> values) {
            addCriterion("hh_remark in", values, "hhRemark");
            return (Criteria) this;
        }

        public Criteria andHhRemarkNotIn(List<String> values) {
            addCriterion("hh_remark not in", values, "hhRemark");
            return (Criteria) this;
        }

        public Criteria andHhRemarkBetween(String value1, String value2) {
            addCriterion("hh_remark between", value1, value2, "hhRemark");
            return (Criteria) this;
        }

        public Criteria andHhRemarkNotBetween(String value1, String value2) {
            addCriterion("hh_remark not between", value1, value2, "hhRemark");
            return (Criteria) this;
        }

        public Criteria andInfectionHistoryIsNull() {
            addCriterion("infection_history is null");
            return (Criteria) this;
        }

        public Criteria andInfectionHistoryIsNotNull() {
            addCriterion("infection_history is not null");
            return (Criteria) this;
        }

        public Criteria andInfectionHistoryEqualTo(String value) {
            addCriterion("infection_history =", value, "infectionHistory");
            return (Criteria) this;
        }

        public Criteria andInfectionHistoryNotEqualTo(String value) {
            addCriterion("infection_history <>", value, "infectionHistory");
            return (Criteria) this;
        }

        public Criteria andInfectionHistoryGreaterThan(String value) {
            addCriterion("infection_history >", value, "infectionHistory");
            return (Criteria) this;
        }

        public Criteria andInfectionHistoryGreaterThanOrEqualTo(String value) {
            addCriterion("infection_history >=", value, "infectionHistory");
            return (Criteria) this;
        }

        public Criteria andInfectionHistoryLessThan(String value) {
            addCriterion("infection_history <", value, "infectionHistory");
            return (Criteria) this;
        }

        public Criteria andInfectionHistoryLessThanOrEqualTo(String value) {
            addCriterion("infection_history <=", value, "infectionHistory");
            return (Criteria) this;
        }

        public Criteria andInfectionHistoryLike(String value) {
            addCriterion("infection_history like", value, "infectionHistory");
            return (Criteria) this;
        }

        public Criteria andInfectionHistoryNotLike(String value) {
            addCriterion("infection_history not like", value, "infectionHistory");
            return (Criteria) this;
        }

        public Criteria andInfectionHistoryIn(List<String> values) {
            addCriterion("infection_history in", values, "infectionHistory");
            return (Criteria) this;
        }

        public Criteria andInfectionHistoryNotIn(List<String> values) {
            addCriterion("infection_history not in", values, "infectionHistory");
            return (Criteria) this;
        }

        public Criteria andInfectionHistoryBetween(String value1, String value2) {
            addCriterion("infection_history between", value1, value2, "infectionHistory");
            return (Criteria) this;
        }

        public Criteria andInfectionHistoryNotBetween(String value1, String value2) {
            addCriterion("infection_history not between", value1, value2, "infectionHistory");
            return (Criteria) this;
        }

        public Criteria andIhRemarkIsNull() {
            addCriterion("ih_remark is null");
            return (Criteria) this;
        }

        public Criteria andIhRemarkIsNotNull() {
            addCriterion("ih_remark is not null");
            return (Criteria) this;
        }

        public Criteria andIhRemarkEqualTo(String value) {
            addCriterion("ih_remark =", value, "ihRemark");
            return (Criteria) this;
        }

        public Criteria andIhRemarkNotEqualTo(String value) {
            addCriterion("ih_remark <>", value, "ihRemark");
            return (Criteria) this;
        }

        public Criteria andIhRemarkGreaterThan(String value) {
            addCriterion("ih_remark >", value, "ihRemark");
            return (Criteria) this;
        }

        public Criteria andIhRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("ih_remark >=", value, "ihRemark");
            return (Criteria) this;
        }

        public Criteria andIhRemarkLessThan(String value) {
            addCriterion("ih_remark <", value, "ihRemark");
            return (Criteria) this;
        }

        public Criteria andIhRemarkLessThanOrEqualTo(String value) {
            addCriterion("ih_remark <=", value, "ihRemark");
            return (Criteria) this;
        }

        public Criteria andIhRemarkLike(String value) {
            addCriterion("ih_remark like", value, "ihRemark");
            return (Criteria) this;
        }

        public Criteria andIhRemarkNotLike(String value) {
            addCriterion("ih_remark not like", value, "ihRemark");
            return (Criteria) this;
        }

        public Criteria andIhRemarkIn(List<String> values) {
            addCriterion("ih_remark in", values, "ihRemark");
            return (Criteria) this;
        }

        public Criteria andIhRemarkNotIn(List<String> values) {
            addCriterion("ih_remark not in", values, "ihRemark");
            return (Criteria) this;
        }

        public Criteria andIhRemarkBetween(String value1, String value2) {
            addCriterion("ih_remark between", value1, value2, "ihRemark");
            return (Criteria) this;
        }

        public Criteria andIhRemarkNotBetween(String value1, String value2) {
            addCriterion("ih_remark not between", value1, value2, "ihRemark");
            return (Criteria) this;
        }

        public Criteria andTraumaHistoryIsNull() {
            addCriterion("trauma_history is null");
            return (Criteria) this;
        }

        public Criteria andTraumaHistoryIsNotNull() {
            addCriterion("trauma_history is not null");
            return (Criteria) this;
        }

        public Criteria andTraumaHistoryEqualTo(String value) {
            addCriterion("trauma_history =", value, "traumaHistory");
            return (Criteria) this;
        }

        public Criteria andTraumaHistoryNotEqualTo(String value) {
            addCriterion("trauma_history <>", value, "traumaHistory");
            return (Criteria) this;
        }

        public Criteria andTraumaHistoryGreaterThan(String value) {
            addCriterion("trauma_history >", value, "traumaHistory");
            return (Criteria) this;
        }

        public Criteria andTraumaHistoryGreaterThanOrEqualTo(String value) {
            addCriterion("trauma_history >=", value, "traumaHistory");
            return (Criteria) this;
        }

        public Criteria andTraumaHistoryLessThan(String value) {
            addCriterion("trauma_history <", value, "traumaHistory");
            return (Criteria) this;
        }

        public Criteria andTraumaHistoryLessThanOrEqualTo(String value) {
            addCriterion("trauma_history <=", value, "traumaHistory");
            return (Criteria) this;
        }

        public Criteria andTraumaHistoryLike(String value) {
            addCriterion("trauma_history like", value, "traumaHistory");
            return (Criteria) this;
        }

        public Criteria andTraumaHistoryNotLike(String value) {
            addCriterion("trauma_history not like", value, "traumaHistory");
            return (Criteria) this;
        }

        public Criteria andTraumaHistoryIn(List<String> values) {
            addCriterion("trauma_history in", values, "traumaHistory");
            return (Criteria) this;
        }

        public Criteria andTraumaHistoryNotIn(List<String> values) {
            addCriterion("trauma_history not in", values, "traumaHistory");
            return (Criteria) this;
        }

        public Criteria andTraumaHistoryBetween(String value1, String value2) {
            addCriterion("trauma_history between", value1, value2, "traumaHistory");
            return (Criteria) this;
        }

        public Criteria andTraumaHistoryNotBetween(String value1, String value2) {
            addCriterion("trauma_history not between", value1, value2, "traumaHistory");
            return (Criteria) this;
        }

        public Criteria andSurgeryHistoryIsNull() {
            addCriterion("surgery_history is null");
            return (Criteria) this;
        }

        public Criteria andSurgeryHistoryIsNotNull() {
            addCriterion("surgery_history is not null");
            return (Criteria) this;
        }

        public Criteria andSurgeryHistoryEqualTo(String value) {
            addCriterion("surgery_history =", value, "surgeryHistory");
            return (Criteria) this;
        }

        public Criteria andSurgeryHistoryNotEqualTo(String value) {
            addCriterion("surgery_history <>", value, "surgeryHistory");
            return (Criteria) this;
        }

        public Criteria andSurgeryHistoryGreaterThan(String value) {
            addCriterion("surgery_history >", value, "surgeryHistory");
            return (Criteria) this;
        }

        public Criteria andSurgeryHistoryGreaterThanOrEqualTo(String value) {
            addCriterion("surgery_history >=", value, "surgeryHistory");
            return (Criteria) this;
        }

        public Criteria andSurgeryHistoryLessThan(String value) {
            addCriterion("surgery_history <", value, "surgeryHistory");
            return (Criteria) this;
        }

        public Criteria andSurgeryHistoryLessThanOrEqualTo(String value) {
            addCriterion("surgery_history <=", value, "surgeryHistory");
            return (Criteria) this;
        }

        public Criteria andSurgeryHistoryLike(String value) {
            addCriterion("surgery_history like", value, "surgeryHistory");
            return (Criteria) this;
        }

        public Criteria andSurgeryHistoryNotLike(String value) {
            addCriterion("surgery_history not like", value, "surgeryHistory");
            return (Criteria) this;
        }

        public Criteria andSurgeryHistoryIn(List<String> values) {
            addCriterion("surgery_history in", values, "surgeryHistory");
            return (Criteria) this;
        }

        public Criteria andSurgeryHistoryNotIn(List<String> values) {
            addCriterion("surgery_history not in", values, "surgeryHistory");
            return (Criteria) this;
        }

        public Criteria andSurgeryHistoryBetween(String value1, String value2) {
            addCriterion("surgery_history between", value1, value2, "surgeryHistory");
            return (Criteria) this;
        }

        public Criteria andSurgeryHistoryNotBetween(String value1, String value2) {
            addCriterion("surgery_history not between", value1, value2, "surgeryHistory");
            return (Criteria) this;
        }

        public Criteria andFamilyHistoryIsNull() {
            addCriterion("family_history is null");
            return (Criteria) this;
        }

        public Criteria andFamilyHistoryIsNotNull() {
            addCriterion("family_history is not null");
            return (Criteria) this;
        }

        public Criteria andFamilyHistoryEqualTo(String value) {
            addCriterion("family_history =", value, "familyHistory");
            return (Criteria) this;
        }

        public Criteria andFamilyHistoryNotEqualTo(String value) {
            addCriterion("family_history <>", value, "familyHistory");
            return (Criteria) this;
        }

        public Criteria andFamilyHistoryGreaterThan(String value) {
            addCriterion("family_history >", value, "familyHistory");
            return (Criteria) this;
        }

        public Criteria andFamilyHistoryGreaterThanOrEqualTo(String value) {
            addCriterion("family_history >=", value, "familyHistory");
            return (Criteria) this;
        }

        public Criteria andFamilyHistoryLessThan(String value) {
            addCriterion("family_history <", value, "familyHistory");
            return (Criteria) this;
        }

        public Criteria andFamilyHistoryLessThanOrEqualTo(String value) {
            addCriterion("family_history <=", value, "familyHistory");
            return (Criteria) this;
        }

        public Criteria andFamilyHistoryLike(String value) {
            addCriterion("family_history like", value, "familyHistory");
            return (Criteria) this;
        }

        public Criteria andFamilyHistoryNotLike(String value) {
            addCriterion("family_history not like", value, "familyHistory");
            return (Criteria) this;
        }

        public Criteria andFamilyHistoryIn(List<String> values) {
            addCriterion("family_history in", values, "familyHistory");
            return (Criteria) this;
        }

        public Criteria andFamilyHistoryNotIn(List<String> values) {
            addCriterion("family_history not in", values, "familyHistory");
            return (Criteria) this;
        }

        public Criteria andFamilyHistoryBetween(String value1, String value2) {
            addCriterion("family_history between", value1, value2, "familyHistory");
            return (Criteria) this;
        }

        public Criteria andFamilyHistoryNotBetween(String value1, String value2) {
            addCriterion("family_history not between", value1, value2, "familyHistory");
            return (Criteria) this;
        }

        public Criteria andContactHistoryIsNull() {
            addCriterion("contact_history is null");
            return (Criteria) this;
        }

        public Criteria andContactHistoryIsNotNull() {
            addCriterion("contact_history is not null");
            return (Criteria) this;
        }

        public Criteria andContactHistoryEqualTo(String value) {
            addCriterion("contact_history =", value, "contactHistory");
            return (Criteria) this;
        }

        public Criteria andContactHistoryNotEqualTo(String value) {
            addCriterion("contact_history <>", value, "contactHistory");
            return (Criteria) this;
        }

        public Criteria andContactHistoryGreaterThan(String value) {
            addCriterion("contact_history >", value, "contactHistory");
            return (Criteria) this;
        }

        public Criteria andContactHistoryGreaterThanOrEqualTo(String value) {
            addCriterion("contact_history >=", value, "contactHistory");
            return (Criteria) this;
        }

        public Criteria andContactHistoryLessThan(String value) {
            addCriterion("contact_history <", value, "contactHistory");
            return (Criteria) this;
        }

        public Criteria andContactHistoryLessThanOrEqualTo(String value) {
            addCriterion("contact_history <=", value, "contactHistory");
            return (Criteria) this;
        }

        public Criteria andContactHistoryLike(String value) {
            addCriterion("contact_history like", value, "contactHistory");
            return (Criteria) this;
        }

        public Criteria andContactHistoryNotLike(String value) {
            addCriterion("contact_history not like", value, "contactHistory");
            return (Criteria) this;
        }

        public Criteria andContactHistoryIn(List<String> values) {
            addCriterion("contact_history in", values, "contactHistory");
            return (Criteria) this;
        }

        public Criteria andContactHistoryNotIn(List<String> values) {
            addCriterion("contact_history not in", values, "contactHistory");
            return (Criteria) this;
        }

        public Criteria andContactHistoryBetween(String value1, String value2) {
            addCriterion("contact_history between", value1, value2, "contactHistory");
            return (Criteria) this;
        }

        public Criteria andContactHistoryNotBetween(String value1, String value2) {
            addCriterion("contact_history not between", value1, value2, "contactHistory");
            return (Criteria) this;
        }

        public Criteria andChRemarkIsNull() {
            addCriterion("ch_remark is null");
            return (Criteria) this;
        }

        public Criteria andChRemarkIsNotNull() {
            addCriterion("ch_remark is not null");
            return (Criteria) this;
        }

        public Criteria andChRemarkEqualTo(String value) {
            addCriterion("ch_remark =", value, "chRemark");
            return (Criteria) this;
        }

        public Criteria andChRemarkNotEqualTo(String value) {
            addCriterion("ch_remark <>", value, "chRemark");
            return (Criteria) this;
        }

        public Criteria andChRemarkGreaterThan(String value) {
            addCriterion("ch_remark >", value, "chRemark");
            return (Criteria) this;
        }

        public Criteria andChRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("ch_remark >=", value, "chRemark");
            return (Criteria) this;
        }

        public Criteria andChRemarkLessThan(String value) {
            addCriterion("ch_remark <", value, "chRemark");
            return (Criteria) this;
        }

        public Criteria andChRemarkLessThanOrEqualTo(String value) {
            addCriterion("ch_remark <=", value, "chRemark");
            return (Criteria) this;
        }

        public Criteria andChRemarkLike(String value) {
            addCriterion("ch_remark like", value, "chRemark");
            return (Criteria) this;
        }

        public Criteria andChRemarkNotLike(String value) {
            addCriterion("ch_remark not like", value, "chRemark");
            return (Criteria) this;
        }

        public Criteria andChRemarkIn(List<String> values) {
            addCriterion("ch_remark in", values, "chRemark");
            return (Criteria) this;
        }

        public Criteria andChRemarkNotIn(List<String> values) {
            addCriterion("ch_remark not in", values, "chRemark");
            return (Criteria) this;
        }

        public Criteria andChRemarkBetween(String value1, String value2) {
            addCriterion("ch_remark between", value1, value2, "chRemark");
            return (Criteria) this;
        }

        public Criteria andChRemarkNotBetween(String value1, String value2) {
            addCriterion("ch_remark not between", value1, value2, "chRemark");
            return (Criteria) this;
        }

        public Criteria andMeAllergyIsNull() {
            addCriterion("me_allergy is null");
            return (Criteria) this;
        }

        public Criteria andMeAllergyIsNotNull() {
            addCriterion("me_allergy is not null");
            return (Criteria) this;
        }

        public Criteria andMeAllergyEqualTo(String value) {
            addCriterion("me_allergy =", value, "meAllergy");
            return (Criteria) this;
        }

        public Criteria andMeAllergyNotEqualTo(String value) {
            addCriterion("me_allergy <>", value, "meAllergy");
            return (Criteria) this;
        }

        public Criteria andMeAllergyGreaterThan(String value) {
            addCriterion("me_allergy >", value, "meAllergy");
            return (Criteria) this;
        }

        public Criteria andMeAllergyGreaterThanOrEqualTo(String value) {
            addCriterion("me_allergy >=", value, "meAllergy");
            return (Criteria) this;
        }

        public Criteria andMeAllergyLessThan(String value) {
            addCriterion("me_allergy <", value, "meAllergy");
            return (Criteria) this;
        }

        public Criteria andMeAllergyLessThanOrEqualTo(String value) {
            addCriterion("me_allergy <=", value, "meAllergy");
            return (Criteria) this;
        }

        public Criteria andMeAllergyLike(String value) {
            addCriterion("me_allergy like", value, "meAllergy");
            return (Criteria) this;
        }

        public Criteria andMeAllergyNotLike(String value) {
            addCriterion("me_allergy not like", value, "meAllergy");
            return (Criteria) this;
        }

        public Criteria andMeAllergyIn(List<String> values) {
            addCriterion("me_allergy in", values, "meAllergy");
            return (Criteria) this;
        }

        public Criteria andMeAllergyNotIn(List<String> values) {
            addCriterion("me_allergy not in", values, "meAllergy");
            return (Criteria) this;
        }

        public Criteria andMeAllergyBetween(String value1, String value2) {
            addCriterion("me_allergy between", value1, value2, "meAllergy");
            return (Criteria) this;
        }

        public Criteria andMeAllergyNotBetween(String value1, String value2) {
            addCriterion("me_allergy not between", value1, value2, "meAllergy");
            return (Criteria) this;
        }

        public Criteria andMeallRemarkIsNull() {
            addCriterion("meall_remark is null");
            return (Criteria) this;
        }

        public Criteria andMeallRemarkIsNotNull() {
            addCriterion("meall_remark is not null");
            return (Criteria) this;
        }

        public Criteria andMeallRemarkEqualTo(String value) {
            addCriterion("meall_remark =", value, "meallRemark");
            return (Criteria) this;
        }

        public Criteria andMeallRemarkNotEqualTo(String value) {
            addCriterion("meall_remark <>", value, "meallRemark");
            return (Criteria) this;
        }

        public Criteria andMeallRemarkGreaterThan(String value) {
            addCriterion("meall_remark >", value, "meallRemark");
            return (Criteria) this;
        }

        public Criteria andMeallRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("meall_remark >=", value, "meallRemark");
            return (Criteria) this;
        }

        public Criteria andMeallRemarkLessThan(String value) {
            addCriterion("meall_remark <", value, "meallRemark");
            return (Criteria) this;
        }

        public Criteria andMeallRemarkLessThanOrEqualTo(String value) {
            addCriterion("meall_remark <=", value, "meallRemark");
            return (Criteria) this;
        }

        public Criteria andMeallRemarkLike(String value) {
            addCriterion("meall_remark like", value, "meallRemark");
            return (Criteria) this;
        }

        public Criteria andMeallRemarkNotLike(String value) {
            addCriterion("meall_remark not like", value, "meallRemark");
            return (Criteria) this;
        }

        public Criteria andMeallRemarkIn(List<String> values) {
            addCriterion("meall_remark in", values, "meallRemark");
            return (Criteria) this;
        }

        public Criteria andMeallRemarkNotIn(List<String> values) {
            addCriterion("meall_remark not in", values, "meallRemark");
            return (Criteria) this;
        }

        public Criteria andMeallRemarkBetween(String value1, String value2) {
            addCriterion("meall_remark between", value1, value2, "meallRemark");
            return (Criteria) this;
        }

        public Criteria andMeallRemarkNotBetween(String value1, String value2) {
            addCriterion("meall_remark not between", value1, value2, "meallRemark");
            return (Criteria) this;
        }

        public Criteria andAllergyIsNull() {
            addCriterion("allergy is null");
            return (Criteria) this;
        }

        public Criteria andAllergyIsNotNull() {
            addCriterion("allergy is not null");
            return (Criteria) this;
        }

        public Criteria andAllergyEqualTo(String value) {
            addCriterion("allergy =", value, "allergy");
            return (Criteria) this;
        }

        public Criteria andAllergyNotEqualTo(String value) {
            addCriterion("allergy <>", value, "allergy");
            return (Criteria) this;
        }

        public Criteria andAllergyGreaterThan(String value) {
            addCriterion("allergy >", value, "allergy");
            return (Criteria) this;
        }

        public Criteria andAllergyGreaterThanOrEqualTo(String value) {
            addCriterion("allergy >=", value, "allergy");
            return (Criteria) this;
        }

        public Criteria andAllergyLessThan(String value) {
            addCriterion("allergy <", value, "allergy");
            return (Criteria) this;
        }

        public Criteria andAllergyLessThanOrEqualTo(String value) {
            addCriterion("allergy <=", value, "allergy");
            return (Criteria) this;
        }

        public Criteria andAllergyLike(String value) {
            addCriterion("allergy like", value, "allergy");
            return (Criteria) this;
        }

        public Criteria andAllergyNotLike(String value) {
            addCriterion("allergy not like", value, "allergy");
            return (Criteria) this;
        }

        public Criteria andAllergyIn(List<String> values) {
            addCriterion("allergy in", values, "allergy");
            return (Criteria) this;
        }

        public Criteria andAllergyNotIn(List<String> values) {
            addCriterion("allergy not in", values, "allergy");
            return (Criteria) this;
        }

        public Criteria andAllergyBetween(String value1, String value2) {
            addCriterion("allergy between", value1, value2, "allergy");
            return (Criteria) this;
        }

        public Criteria andAllergyNotBetween(String value1, String value2) {
            addCriterion("allergy not between", value1, value2, "allergy");
            return (Criteria) this;
        }

        public Criteria andAllRemarkIsNull() {
            addCriterion("all_remark is null");
            return (Criteria) this;
        }

        public Criteria andAllRemarkIsNotNull() {
            addCriterion("all_remark is not null");
            return (Criteria) this;
        }

        public Criteria andAllRemarkEqualTo(String value) {
            addCriterion("all_remark =", value, "allRemark");
            return (Criteria) this;
        }

        public Criteria andAllRemarkNotEqualTo(String value) {
            addCriterion("all_remark <>", value, "allRemark");
            return (Criteria) this;
        }

        public Criteria andAllRemarkGreaterThan(String value) {
            addCriterion("all_remark >", value, "allRemark");
            return (Criteria) this;
        }

        public Criteria andAllRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("all_remark >=", value, "allRemark");
            return (Criteria) this;
        }

        public Criteria andAllRemarkLessThan(String value) {
            addCriterion("all_remark <", value, "allRemark");
            return (Criteria) this;
        }

        public Criteria andAllRemarkLessThanOrEqualTo(String value) {
            addCriterion("all_remark <=", value, "allRemark");
            return (Criteria) this;
        }

        public Criteria andAllRemarkLike(String value) {
            addCriterion("all_remark like", value, "allRemark");
            return (Criteria) this;
        }

        public Criteria andAllRemarkNotLike(String value) {
            addCriterion("all_remark not like", value, "allRemark");
            return (Criteria) this;
        }

        public Criteria andAllRemarkIn(List<String> values) {
            addCriterion("all_remark in", values, "allRemark");
            return (Criteria) this;
        }

        public Criteria andAllRemarkNotIn(List<String> values) {
            addCriterion("all_remark not in", values, "allRemark");
            return (Criteria) this;
        }

        public Criteria andAllRemarkBetween(String value1, String value2) {
            addCriterion("all_remark between", value1, value2, "allRemark");
            return (Criteria) this;
        }

        public Criteria andAllRemarkNotBetween(String value1, String value2) {
            addCriterion("all_remark not between", value1, value2, "allRemark");
            return (Criteria) this;
        }

        public Criteria andBloodTransIsNull() {
            addCriterion("blood_trans is null");
            return (Criteria) this;
        }

        public Criteria andBloodTransIsNotNull() {
            addCriterion("blood_trans is not null");
            return (Criteria) this;
        }

        public Criteria andBloodTransEqualTo(String value) {
            addCriterion("blood_trans =", value, "bloodTrans");
            return (Criteria) this;
        }

        public Criteria andBloodTransNotEqualTo(String value) {
            addCriterion("blood_trans <>", value, "bloodTrans");
            return (Criteria) this;
        }

        public Criteria andBloodTransGreaterThan(String value) {
            addCriterion("blood_trans >", value, "bloodTrans");
            return (Criteria) this;
        }

        public Criteria andBloodTransGreaterThanOrEqualTo(String value) {
            addCriterion("blood_trans >=", value, "bloodTrans");
            return (Criteria) this;
        }

        public Criteria andBloodTransLessThan(String value) {
            addCriterion("blood_trans <", value, "bloodTrans");
            return (Criteria) this;
        }

        public Criteria andBloodTransLessThanOrEqualTo(String value) {
            addCriterion("blood_trans <=", value, "bloodTrans");
            return (Criteria) this;
        }

        public Criteria andBloodTransLike(String value) {
            addCriterion("blood_trans like", value, "bloodTrans");
            return (Criteria) this;
        }

        public Criteria andBloodTransNotLike(String value) {
            addCriterion("blood_trans not like", value, "bloodTrans");
            return (Criteria) this;
        }

        public Criteria andBloodTransIn(List<String> values) {
            addCriterion("blood_trans in", values, "bloodTrans");
            return (Criteria) this;
        }

        public Criteria andBloodTransNotIn(List<String> values) {
            addCriterion("blood_trans not in", values, "bloodTrans");
            return (Criteria) this;
        }

        public Criteria andBloodTransBetween(String value1, String value2) {
            addCriterion("blood_trans between", value1, value2, "bloodTrans");
            return (Criteria) this;
        }

        public Criteria andBloodTransNotBetween(String value1, String value2) {
            addCriterion("blood_trans not between", value1, value2, "bloodTrans");
            return (Criteria) this;
        }

        public Criteria andSmokeIsNull() {
            addCriterion("smoke is null");
            return (Criteria) this;
        }

        public Criteria andSmokeIsNotNull() {
            addCriterion("smoke is not null");
            return (Criteria) this;
        }

        public Criteria andSmokeEqualTo(String value) {
            addCriterion("smoke =", value, "smoke");
            return (Criteria) this;
        }

        public Criteria andSmokeNotEqualTo(String value) {
            addCriterion("smoke <>", value, "smoke");
            return (Criteria) this;
        }

        public Criteria andSmokeGreaterThan(String value) {
            addCriterion("smoke >", value, "smoke");
            return (Criteria) this;
        }

        public Criteria andSmokeGreaterThanOrEqualTo(String value) {
            addCriterion("smoke >=", value, "smoke");
            return (Criteria) this;
        }

        public Criteria andSmokeLessThan(String value) {
            addCriterion("smoke <", value, "smoke");
            return (Criteria) this;
        }

        public Criteria andSmokeLessThanOrEqualTo(String value) {
            addCriterion("smoke <=", value, "smoke");
            return (Criteria) this;
        }

        public Criteria andSmokeLike(String value) {
            addCriterion("smoke like", value, "smoke");
            return (Criteria) this;
        }

        public Criteria andSmokeNotLike(String value) {
            addCriterion("smoke not like", value, "smoke");
            return (Criteria) this;
        }

        public Criteria andSmokeIn(List<String> values) {
            addCriterion("smoke in", values, "smoke");
            return (Criteria) this;
        }

        public Criteria andSmokeNotIn(List<String> values) {
            addCriterion("smoke not in", values, "smoke");
            return (Criteria) this;
        }

        public Criteria andSmokeBetween(String value1, String value2) {
            addCriterion("smoke between", value1, value2, "smoke");
            return (Criteria) this;
        }

        public Criteria andSmokeNotBetween(String value1, String value2) {
            addCriterion("smoke not between", value1, value2, "smoke");
            return (Criteria) this;
        }

        public Criteria andDailySmokeIsNull() {
            addCriterion("daily_smoke is null");
            return (Criteria) this;
        }

        public Criteria andDailySmokeIsNotNull() {
            addCriterion("daily_smoke is not null");
            return (Criteria) this;
        }

        public Criteria andDailySmokeEqualTo(Integer value) {
            addCriterion("daily_smoke =", value, "dailySmoke");
            return (Criteria) this;
        }

        public Criteria andDailySmokeNotEqualTo(Integer value) {
            addCriterion("daily_smoke <>", value, "dailySmoke");
            return (Criteria) this;
        }

        public Criteria andDailySmokeGreaterThan(Integer value) {
            addCriterion("daily_smoke >", value, "dailySmoke");
            return (Criteria) this;
        }

        public Criteria andDailySmokeGreaterThanOrEqualTo(Integer value) {
            addCriterion("daily_smoke >=", value, "dailySmoke");
            return (Criteria) this;
        }

        public Criteria andDailySmokeLessThan(Integer value) {
            addCriterion("daily_smoke <", value, "dailySmoke");
            return (Criteria) this;
        }

        public Criteria andDailySmokeLessThanOrEqualTo(Integer value) {
            addCriterion("daily_smoke <=", value, "dailySmoke");
            return (Criteria) this;
        }

        public Criteria andDailySmokeIn(List<Integer> values) {
            addCriterion("daily_smoke in", values, "dailySmoke");
            return (Criteria) this;
        }

        public Criteria andDailySmokeNotIn(List<Integer> values) {
            addCriterion("daily_smoke not in", values, "dailySmoke");
            return (Criteria) this;
        }

        public Criteria andDailySmokeBetween(Integer value1, Integer value2) {
            addCriterion("daily_smoke between", value1, value2, "dailySmoke");
            return (Criteria) this;
        }

        public Criteria andDailySmokeNotBetween(Integer value1, Integer value2) {
            addCriterion("daily_smoke not between", value1, value2, "dailySmoke");
            return (Criteria) this;
        }

        public Criteria andQuitSmokeIsNull() {
            addCriterion("quit_smoke is null");
            return (Criteria) this;
        }

        public Criteria andQuitSmokeIsNotNull() {
            addCriterion("quit_smoke is not null");
            return (Criteria) this;
        }

        public Criteria andQuitSmokeEqualTo(String value) {
            addCriterion("quit_smoke =", value, "quitSmoke");
            return (Criteria) this;
        }

        public Criteria andQuitSmokeNotEqualTo(String value) {
            addCriterion("quit_smoke <>", value, "quitSmoke");
            return (Criteria) this;
        }

        public Criteria andQuitSmokeGreaterThan(String value) {
            addCriterion("quit_smoke >", value, "quitSmoke");
            return (Criteria) this;
        }

        public Criteria andQuitSmokeGreaterThanOrEqualTo(String value) {
            addCriterion("quit_smoke >=", value, "quitSmoke");
            return (Criteria) this;
        }

        public Criteria andQuitSmokeLessThan(String value) {
            addCriterion("quit_smoke <", value, "quitSmoke");
            return (Criteria) this;
        }

        public Criteria andQuitSmokeLessThanOrEqualTo(String value) {
            addCriterion("quit_smoke <=", value, "quitSmoke");
            return (Criteria) this;
        }

        public Criteria andQuitSmokeLike(String value) {
            addCriterion("quit_smoke like", value, "quitSmoke");
            return (Criteria) this;
        }

        public Criteria andQuitSmokeNotLike(String value) {
            addCriterion("quit_smoke not like", value, "quitSmoke");
            return (Criteria) this;
        }

        public Criteria andQuitSmokeIn(List<String> values) {
            addCriterion("quit_smoke in", values, "quitSmoke");
            return (Criteria) this;
        }

        public Criteria andQuitSmokeNotIn(List<String> values) {
            addCriterion("quit_smoke not in", values, "quitSmoke");
            return (Criteria) this;
        }

        public Criteria andQuitSmokeBetween(String value1, String value2) {
            addCriterion("quit_smoke between", value1, value2, "quitSmoke");
            return (Criteria) this;
        }

        public Criteria andQuitSmokeNotBetween(String value1, String value2) {
            addCriterion("quit_smoke not between", value1, value2, "quitSmoke");
            return (Criteria) this;
        }

        public Criteria andPregnantIsNull() {
            addCriterion("pregnant is null");
            return (Criteria) this;
        }

        public Criteria andPregnantIsNotNull() {
            addCriterion("pregnant is not null");
            return (Criteria) this;
        }

        public Criteria andPregnantEqualTo(Integer value) {
            addCriterion("pregnant =", value, "pregnant");
            return (Criteria) this;
        }

        public Criteria andPregnantNotEqualTo(Integer value) {
            addCriterion("pregnant <>", value, "pregnant");
            return (Criteria) this;
        }

        public Criteria andPregnantGreaterThan(Integer value) {
            addCriterion("pregnant >", value, "pregnant");
            return (Criteria) this;
        }

        public Criteria andPregnantGreaterThanOrEqualTo(Integer value) {
            addCriterion("pregnant >=", value, "pregnant");
            return (Criteria) this;
        }

        public Criteria andPregnantLessThan(Integer value) {
            addCriterion("pregnant <", value, "pregnant");
            return (Criteria) this;
        }

        public Criteria andPregnantLessThanOrEqualTo(Integer value) {
            addCriterion("pregnant <=", value, "pregnant");
            return (Criteria) this;
        }

        public Criteria andPregnantIn(List<Integer> values) {
            addCriterion("pregnant in", values, "pregnant");
            return (Criteria) this;
        }

        public Criteria andPregnantNotIn(List<Integer> values) {
            addCriterion("pregnant not in", values, "pregnant");
            return (Criteria) this;
        }

        public Criteria andPregnantBetween(Integer value1, Integer value2) {
            addCriterion("pregnant between", value1, value2, "pregnant");
            return (Criteria) this;
        }

        public Criteria andPregnantNotBetween(Integer value1, Integer value2) {
            addCriterion("pregnant not between", value1, value2, "pregnant");
            return (Criteria) this;
        }

        public Criteria andBirthIsNull() {
            addCriterion("birth is null");
            return (Criteria) this;
        }

        public Criteria andBirthIsNotNull() {
            addCriterion("birth is not null");
            return (Criteria) this;
        }

        public Criteria andBirthEqualTo(Integer value) {
            addCriterion("birth =", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthNotEqualTo(Integer value) {
            addCriterion("birth <>", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthGreaterThan(Integer value) {
            addCriterion("birth >", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthGreaterThanOrEqualTo(Integer value) {
            addCriterion("birth >=", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthLessThan(Integer value) {
            addCriterion("birth <", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthLessThanOrEqualTo(Integer value) {
            addCriterion("birth <=", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthIn(List<Integer> values) {
            addCriterion("birth in", values, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthNotIn(List<Integer> values) {
            addCriterion("birth not in", values, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthBetween(Integer value1, Integer value2) {
            addCriterion("birth between", value1, value2, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthNotBetween(Integer value1, Integer value2) {
            addCriterion("birth not between", value1, value2, "birth");
            return (Criteria) this;
        }

        public Criteria andPrematureLabourIsNull() {
            addCriterion("premature_labour is null");
            return (Criteria) this;
        }

        public Criteria andPrematureLabourIsNotNull() {
            addCriterion("premature_labour is not null");
            return (Criteria) this;
        }

        public Criteria andPrematureLabourEqualTo(String value) {
            addCriterion("premature_labour =", value, "prematureLabour");
            return (Criteria) this;
        }

        public Criteria andPrematureLabourNotEqualTo(String value) {
            addCriterion("premature_labour <>", value, "prematureLabour");
            return (Criteria) this;
        }

        public Criteria andPrematureLabourGreaterThan(String value) {
            addCriterion("premature_labour >", value, "prematureLabour");
            return (Criteria) this;
        }

        public Criteria andPrematureLabourGreaterThanOrEqualTo(String value) {
            addCriterion("premature_labour >=", value, "prematureLabour");
            return (Criteria) this;
        }

        public Criteria andPrematureLabourLessThan(String value) {
            addCriterion("premature_labour <", value, "prematureLabour");
            return (Criteria) this;
        }

        public Criteria andPrematureLabourLessThanOrEqualTo(String value) {
            addCriterion("premature_labour <=", value, "prematureLabour");
            return (Criteria) this;
        }

        public Criteria andPrematureLabourLike(String value) {
            addCriterion("premature_labour like", value, "prematureLabour");
            return (Criteria) this;
        }

        public Criteria andPrematureLabourNotLike(String value) {
            addCriterion("premature_labour not like", value, "prematureLabour");
            return (Criteria) this;
        }

        public Criteria andPrematureLabourIn(List<String> values) {
            addCriterion("premature_labour in", values, "prematureLabour");
            return (Criteria) this;
        }

        public Criteria andPrematureLabourNotIn(List<String> values) {
            addCriterion("premature_labour not in", values, "prematureLabour");
            return (Criteria) this;
        }

        public Criteria andPrematureLabourBetween(String value1, String value2) {
            addCriterion("premature_labour between", value1, value2, "prematureLabour");
            return (Criteria) this;
        }

        public Criteria andPrematureLabourNotBetween(String value1, String value2) {
            addCriterion("premature_labour not between", value1, value2, "prematureLabour");
            return (Criteria) this;
        }

        public Criteria andAbortionIsNull() {
            addCriterion("abortion is null");
            return (Criteria) this;
        }

        public Criteria andAbortionIsNotNull() {
            addCriterion("abortion is not null");
            return (Criteria) this;
        }

        public Criteria andAbortionEqualTo(String value) {
            addCriterion("abortion =", value, "abortion");
            return (Criteria) this;
        }

        public Criteria andAbortionNotEqualTo(String value) {
            addCriterion("abortion <>", value, "abortion");
            return (Criteria) this;
        }

        public Criteria andAbortionGreaterThan(String value) {
            addCriterion("abortion >", value, "abortion");
            return (Criteria) this;
        }

        public Criteria andAbortionGreaterThanOrEqualTo(String value) {
            addCriterion("abortion >=", value, "abortion");
            return (Criteria) this;
        }

        public Criteria andAbortionLessThan(String value) {
            addCriterion("abortion <", value, "abortion");
            return (Criteria) this;
        }

        public Criteria andAbortionLessThanOrEqualTo(String value) {
            addCriterion("abortion <=", value, "abortion");
            return (Criteria) this;
        }

        public Criteria andAbortionLike(String value) {
            addCriterion("abortion like", value, "abortion");
            return (Criteria) this;
        }

        public Criteria andAbortionNotLike(String value) {
            addCriterion("abortion not like", value, "abortion");
            return (Criteria) this;
        }

        public Criteria andAbortionIn(List<String> values) {
            addCriterion("abortion in", values, "abortion");
            return (Criteria) this;
        }

        public Criteria andAbortionNotIn(List<String> values) {
            addCriterion("abortion not in", values, "abortion");
            return (Criteria) this;
        }

        public Criteria andAbortionBetween(String value1, String value2) {
            addCriterion("abortion between", value1, value2, "abortion");
            return (Criteria) this;
        }

        public Criteria andAbortionNotBetween(String value1, String value2) {
            addCriterion("abortion not between", value1, value2, "abortion");
            return (Criteria) this;
        }

        public Criteria andInsertDateIsNull() {
            addCriterion("insert_date is null");
            return (Criteria) this;
        }

        public Criteria andInsertDateIsNotNull() {
            addCriterion("insert_date is not null");
            return (Criteria) this;
        }

        public Criteria andInsertDateEqualTo(Date value) {
            addCriterionForJDBCDate("insert_date =", value, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("insert_date <>", value, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateGreaterThan(Date value) {
            addCriterionForJDBCDate("insert_date >", value, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("insert_date >=", value, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateLessThan(Date value) {
            addCriterionForJDBCDate("insert_date <", value, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("insert_date <=", value, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateIn(List<Date> values) {
            addCriterionForJDBCDate("insert_date in", values, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("insert_date not in", values, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("insert_date between", value1, value2, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("insert_date not between", value1, value2, "insertDate");
            return (Criteria) this;
        }

        public Criteria andSourceProvinceIsNull() {
            addCriterion("source_province is null");
            return (Criteria) this;
        }

        public Criteria andSourceProvinceIsNotNull() {
            addCriterion("source_province is not null");
            return (Criteria) this;
        }

        public Criteria andSourceProvinceEqualTo(Integer value) {
            addCriterion("source_province =", value, "sourceProvince");
            return (Criteria) this;
        }

        public Criteria andSourceProvinceNotEqualTo(Integer value) {
            addCriterion("source_province <>", value, "sourceProvince");
            return (Criteria) this;
        }

        public Criteria andSourceProvinceGreaterThan(Integer value) {
            addCriterion("source_province >", value, "sourceProvince");
            return (Criteria) this;
        }

        public Criteria andSourceProvinceGreaterThanOrEqualTo(Integer value) {
            addCriterion("source_province >=", value, "sourceProvince");
            return (Criteria) this;
        }

        public Criteria andSourceProvinceLessThan(Integer value) {
            addCriterion("source_province <", value, "sourceProvince");
            return (Criteria) this;
        }

        public Criteria andSourceProvinceLessThanOrEqualTo(Integer value) {
            addCriterion("source_province <=", value, "sourceProvince");
            return (Criteria) this;
        }

        public Criteria andSourceProvinceIn(List<Integer> values) {
            addCriterion("source_province in", values, "sourceProvince");
            return (Criteria) this;
        }

        public Criteria andSourceProvinceNotIn(List<Integer> values) {
            addCriterion("source_province not in", values, "sourceProvince");
            return (Criteria) this;
        }

        public Criteria andSourceProvinceBetween(Integer value1, Integer value2) {
            addCriterion("source_province between", value1, value2, "sourceProvince");
            return (Criteria) this;
        }

        public Criteria andSourceProvinceNotBetween(Integer value1, Integer value2) {
            addCriterion("source_province not between", value1, value2, "sourceProvince");
            return (Criteria) this;
        }

        public Criteria andSourceCityIsNull() {
            addCriterion("source_city is null");
            return (Criteria) this;
        }

        public Criteria andSourceCityIsNotNull() {
            addCriterion("source_city is not null");
            return (Criteria) this;
        }

        public Criteria andSourceCityEqualTo(Integer value) {
            addCriterion("source_city =", value, "sourceCity");
            return (Criteria) this;
        }

        public Criteria andSourceCityNotEqualTo(Integer value) {
            addCriterion("source_city <>", value, "sourceCity");
            return (Criteria) this;
        }

        public Criteria andSourceCityGreaterThan(Integer value) {
            addCriterion("source_city >", value, "sourceCity");
            return (Criteria) this;
        }

        public Criteria andSourceCityGreaterThanOrEqualTo(Integer value) {
            addCriterion("source_city >=", value, "sourceCity");
            return (Criteria) this;
        }

        public Criteria andSourceCityLessThan(Integer value) {
            addCriterion("source_city <", value, "sourceCity");
            return (Criteria) this;
        }

        public Criteria andSourceCityLessThanOrEqualTo(Integer value) {
            addCriterion("source_city <=", value, "sourceCity");
            return (Criteria) this;
        }

        public Criteria andSourceCityIn(List<Integer> values) {
            addCriterion("source_city in", values, "sourceCity");
            return (Criteria) this;
        }

        public Criteria andSourceCityNotIn(List<Integer> values) {
            addCriterion("source_city not in", values, "sourceCity");
            return (Criteria) this;
        }

        public Criteria andSourceCityBetween(Integer value1, Integer value2) {
            addCriterion("source_city between", value1, value2, "sourceCity");
            return (Criteria) this;
        }

        public Criteria andSourceCityNotBetween(Integer value1, Integer value2) {
            addCriterion("source_city not between", value1, value2, "sourceCity");
            return (Criteria) this;
        }

        public Criteria andIncuProvinceIsNull() {
            addCriterion("incu_province is null");
            return (Criteria) this;
        }

        public Criteria andIncuProvinceIsNotNull() {
            addCriterion("incu_province is not null");
            return (Criteria) this;
        }

        public Criteria andIncuProvinceEqualTo(Integer value) {
            addCriterion("incu_province =", value, "incuProvince");
            return (Criteria) this;
        }

        public Criteria andIncuProvinceNotEqualTo(Integer value) {
            addCriterion("incu_province <>", value, "incuProvince");
            return (Criteria) this;
        }

        public Criteria andIncuProvinceGreaterThan(Integer value) {
            addCriterion("incu_province >", value, "incuProvince");
            return (Criteria) this;
        }

        public Criteria andIncuProvinceGreaterThanOrEqualTo(Integer value) {
            addCriterion("incu_province >=", value, "incuProvince");
            return (Criteria) this;
        }

        public Criteria andIncuProvinceLessThan(Integer value) {
            addCriterion("incu_province <", value, "incuProvince");
            return (Criteria) this;
        }

        public Criteria andIncuProvinceLessThanOrEqualTo(Integer value) {
            addCriterion("incu_province <=", value, "incuProvince");
            return (Criteria) this;
        }

        public Criteria andIncuProvinceIn(List<Integer> values) {
            addCriterion("incu_province in", values, "incuProvince");
            return (Criteria) this;
        }

        public Criteria andIncuProvinceNotIn(List<Integer> values) {
            addCriterion("incu_province not in", values, "incuProvince");
            return (Criteria) this;
        }

        public Criteria andIncuProvinceBetween(Integer value1, Integer value2) {
            addCriterion("incu_province between", value1, value2, "incuProvince");
            return (Criteria) this;
        }

        public Criteria andIncuProvinceNotBetween(Integer value1, Integer value2) {
            addCriterion("incu_province not between", value1, value2, "incuProvince");
            return (Criteria) this;
        }

        public Criteria andIncuCityIsNull() {
            addCriterion("incu_city is null");
            return (Criteria) this;
        }

        public Criteria andIncuCityIsNotNull() {
            addCriterion("incu_city is not null");
            return (Criteria) this;
        }

        public Criteria andIncuCityEqualTo(Integer value) {
            addCriterion("incu_city =", value, "incuCity");
            return (Criteria) this;
        }

        public Criteria andIncuCityNotEqualTo(Integer value) {
            addCriterion("incu_city <>", value, "incuCity");
            return (Criteria) this;
        }

        public Criteria andIncuCityGreaterThan(Integer value) {
            addCriterion("incu_city >", value, "incuCity");
            return (Criteria) this;
        }

        public Criteria andIncuCityGreaterThanOrEqualTo(Integer value) {
            addCriterion("incu_city >=", value, "incuCity");
            return (Criteria) this;
        }

        public Criteria andIncuCityLessThan(Integer value) {
            addCriterion("incu_city <", value, "incuCity");
            return (Criteria) this;
        }

        public Criteria andIncuCityLessThanOrEqualTo(Integer value) {
            addCriterion("incu_city <=", value, "incuCity");
            return (Criteria) this;
        }

        public Criteria andIncuCityIn(List<Integer> values) {
            addCriterion("incu_city in", values, "incuCity");
            return (Criteria) this;
        }

        public Criteria andIncuCityNotIn(List<Integer> values) {
            addCriterion("incu_city not in", values, "incuCity");
            return (Criteria) this;
        }

        public Criteria andIncuCityBetween(Integer value1, Integer value2) {
            addCriterion("incu_city between", value1, value2, "incuCity");
            return (Criteria) this;
        }

        public Criteria andIncuCityNotBetween(Integer value1, Integer value2) {
            addCriterion("incu_city not between", value1, value2, "incuCity");
            return (Criteria) this;
        }

        public Criteria andQuitSmokeTimeIsNull() {
            addCriterion("quit_smoke_time is null");
            return (Criteria) this;
        }

        public Criteria andQuitSmokeTimeIsNotNull() {
            addCriterion("quit_smoke_time is not null");
            return (Criteria) this;
        }

        public Criteria andQuitSmokeTimeEqualTo(String value) {
            addCriterion("quit_smoke_time =", value, "quitSmokeTime");
            return (Criteria) this;
        }

        public Criteria andQuitSmokeTimeNotEqualTo(String value) {
            addCriterion("quit_smoke_time <>", value, "quitSmokeTime");
            return (Criteria) this;
        }

        public Criteria andQuitSmokeTimeGreaterThan(String value) {
            addCriterion("quit_smoke_time >", value, "quitSmokeTime");
            return (Criteria) this;
        }

        public Criteria andQuitSmokeTimeGreaterThanOrEqualTo(String value) {
            addCriterion("quit_smoke_time >=", value, "quitSmokeTime");
            return (Criteria) this;
        }

        public Criteria andQuitSmokeTimeLessThan(String value) {
            addCriterion("quit_smoke_time <", value, "quitSmokeTime");
            return (Criteria) this;
        }

        public Criteria andQuitSmokeTimeLessThanOrEqualTo(String value) {
            addCriterion("quit_smoke_time <=", value, "quitSmokeTime");
            return (Criteria) this;
        }

        public Criteria andQuitSmokeTimeLike(String value) {
            addCriterion("quit_smoke_time like", value, "quitSmokeTime");
            return (Criteria) this;
        }

        public Criteria andQuitSmokeTimeNotLike(String value) {
            addCriterion("quit_smoke_time not like", value, "quitSmokeTime");
            return (Criteria) this;
        }

        public Criteria andQuitSmokeTimeIn(List<String> values) {
            addCriterion("quit_smoke_time in", values, "quitSmokeTime");
            return (Criteria) this;
        }

        public Criteria andQuitSmokeTimeNotIn(List<String> values) {
            addCriterion("quit_smoke_time not in", values, "quitSmokeTime");
            return (Criteria) this;
        }

        public Criteria andQuitSmokeTimeBetween(String value1, String value2) {
            addCriterion("quit_smoke_time between", value1, value2, "quitSmokeTime");
            return (Criteria) this;
        }

        public Criteria andQuitSmokeTimeNotBetween(String value1, String value2) {
            addCriterion("quit_smoke_time not between", value1, value2, "quitSmokeTime");
            return (Criteria) this;
        }

        public Criteria andContraceptionIsNull() {
            addCriterion("contraception is null");
            return (Criteria) this;
        }

        public Criteria andContraceptionIsNotNull() {
            addCriterion("contraception is not null");
            return (Criteria) this;
        }

        public Criteria andContraceptionEqualTo(String value) {
            addCriterion("contraception =", value, "contraception");
            return (Criteria) this;
        }

        public Criteria andContraceptionNotEqualTo(String value) {
            addCriterion("contraception <>", value, "contraception");
            return (Criteria) this;
        }

        public Criteria andContraceptionGreaterThan(String value) {
            addCriterion("contraception >", value, "contraception");
            return (Criteria) this;
        }

        public Criteria andContraceptionGreaterThanOrEqualTo(String value) {
            addCriterion("contraception >=", value, "contraception");
            return (Criteria) this;
        }

        public Criteria andContraceptionLessThan(String value) {
            addCriterion("contraception <", value, "contraception");
            return (Criteria) this;
        }

        public Criteria andContraceptionLessThanOrEqualTo(String value) {
            addCriterion("contraception <=", value, "contraception");
            return (Criteria) this;
        }

        public Criteria andContraceptionLike(String value) {
            addCriterion("contraception like", value, "contraception");
            return (Criteria) this;
        }

        public Criteria andContraceptionNotLike(String value) {
            addCriterion("contraception not like", value, "contraception");
            return (Criteria) this;
        }

        public Criteria andContraceptionIn(List<String> values) {
            addCriterion("contraception in", values, "contraception");
            return (Criteria) this;
        }

        public Criteria andContraceptionNotIn(List<String> values) {
            addCriterion("contraception not in", values, "contraception");
            return (Criteria) this;
        }

        public Criteria andContraceptionBetween(String value1, String value2) {
            addCriterion("contraception between", value1, value2, "contraception");
            return (Criteria) this;
        }

        public Criteria andContraceptionNotBetween(String value1, String value2) {
            addCriterion("contraception not between", value1, value2, "contraception");
            return (Criteria) this;
        }

        public Criteria andDrinkIsNull() {
            addCriterion("drink is null");
            return (Criteria) this;
        }

        public Criteria andDrinkIsNotNull() {
            addCriterion("drink is not null");
            return (Criteria) this;
        }

        public Criteria andDrinkEqualTo(String value) {
            addCriterion("drink =", value, "drink");
            return (Criteria) this;
        }

        public Criteria andDrinkNotEqualTo(String value) {
            addCriterion("drink <>", value, "drink");
            return (Criteria) this;
        }

        public Criteria andDrinkGreaterThan(String value) {
            addCriterion("drink >", value, "drink");
            return (Criteria) this;
        }

        public Criteria andDrinkGreaterThanOrEqualTo(String value) {
            addCriterion("drink >=", value, "drink");
            return (Criteria) this;
        }

        public Criteria andDrinkLessThan(String value) {
            addCriterion("drink <", value, "drink");
            return (Criteria) this;
        }

        public Criteria andDrinkLessThanOrEqualTo(String value) {
            addCriterion("drink <=", value, "drink");
            return (Criteria) this;
        }

        public Criteria andDrinkLike(String value) {
            addCriterion("drink like", value, "drink");
            return (Criteria) this;
        }

        public Criteria andDrinkNotLike(String value) {
            addCriterion("drink not like", value, "drink");
            return (Criteria) this;
        }

        public Criteria andDrinkIn(List<String> values) {
            addCriterion("drink in", values, "drink");
            return (Criteria) this;
        }

        public Criteria andDrinkNotIn(List<String> values) {
            addCriterion("drink not in", values, "drink");
            return (Criteria) this;
        }

        public Criteria andDrinkBetween(String value1, String value2) {
            addCriterion("drink between", value1, value2, "drink");
            return (Criteria) this;
        }

        public Criteria andDrinkNotBetween(String value1, String value2) {
            addCriterion("drink not between", value1, value2, "drink");
            return (Criteria) this;
        }

        public Criteria andDailyDrinkIsNull() {
            addCriterion("daily_drink is null");
            return (Criteria) this;
        }

        public Criteria andDailyDrinkIsNotNull() {
            addCriterion("daily_drink is not null");
            return (Criteria) this;
        }

        public Criteria andDailyDrinkEqualTo(Integer value) {
            addCriterion("daily_drink =", value, "dailyDrink");
            return (Criteria) this;
        }

        public Criteria andDailyDrinkNotEqualTo(Integer value) {
            addCriterion("daily_drink <>", value, "dailyDrink");
            return (Criteria) this;
        }

        public Criteria andDailyDrinkGreaterThan(Integer value) {
            addCriterion("daily_drink >", value, "dailyDrink");
            return (Criteria) this;
        }

        public Criteria andDailyDrinkGreaterThanOrEqualTo(Integer value) {
            addCriterion("daily_drink >=", value, "dailyDrink");
            return (Criteria) this;
        }

        public Criteria andDailyDrinkLessThan(Integer value) {
            addCriterion("daily_drink <", value, "dailyDrink");
            return (Criteria) this;
        }

        public Criteria andDailyDrinkLessThanOrEqualTo(Integer value) {
            addCriterion("daily_drink <=", value, "dailyDrink");
            return (Criteria) this;
        }

        public Criteria andDailyDrinkIn(List<Integer> values) {
            addCriterion("daily_drink in", values, "dailyDrink");
            return (Criteria) this;
        }

        public Criteria andDailyDrinkNotIn(List<Integer> values) {
            addCriterion("daily_drink not in", values, "dailyDrink");
            return (Criteria) this;
        }

        public Criteria andDailyDrinkBetween(Integer value1, Integer value2) {
            addCriterion("daily_drink between", value1, value2, "dailyDrink");
            return (Criteria) this;
        }

        public Criteria andDailyDrinkNotBetween(Integer value1, Integer value2) {
            addCriterion("daily_drink not between", value1, value2, "dailyDrink");
            return (Criteria) this;
        }

        public Criteria andQuitDrinkIsNull() {
            addCriterion("quit_drink is null");
            return (Criteria) this;
        }

        public Criteria andQuitDrinkIsNotNull() {
            addCriterion("quit_drink is not null");
            return (Criteria) this;
        }

        public Criteria andQuitDrinkEqualTo(String value) {
            addCriterion("quit_drink =", value, "quitDrink");
            return (Criteria) this;
        }

        public Criteria andQuitDrinkNotEqualTo(String value) {
            addCriterion("quit_drink <>", value, "quitDrink");
            return (Criteria) this;
        }

        public Criteria andQuitDrinkGreaterThan(String value) {
            addCriterion("quit_drink >", value, "quitDrink");
            return (Criteria) this;
        }

        public Criteria andQuitDrinkGreaterThanOrEqualTo(String value) {
            addCriterion("quit_drink >=", value, "quitDrink");
            return (Criteria) this;
        }

        public Criteria andQuitDrinkLessThan(String value) {
            addCriterion("quit_drink <", value, "quitDrink");
            return (Criteria) this;
        }

        public Criteria andQuitDrinkLessThanOrEqualTo(String value) {
            addCriterion("quit_drink <=", value, "quitDrink");
            return (Criteria) this;
        }

        public Criteria andQuitDrinkLike(String value) {
            addCriterion("quit_drink like", value, "quitDrink");
            return (Criteria) this;
        }

        public Criteria andQuitDrinkNotLike(String value) {
            addCriterion("quit_drink not like", value, "quitDrink");
            return (Criteria) this;
        }

        public Criteria andQuitDrinkIn(List<String> values) {
            addCriterion("quit_drink in", values, "quitDrink");
            return (Criteria) this;
        }

        public Criteria andQuitDrinkNotIn(List<String> values) {
            addCriterion("quit_drink not in", values, "quitDrink");
            return (Criteria) this;
        }

        public Criteria andQuitDrinkBetween(String value1, String value2) {
            addCriterion("quit_drink between", value1, value2, "quitDrink");
            return (Criteria) this;
        }

        public Criteria andQuitDrinkNotBetween(String value1, String value2) {
            addCriterion("quit_drink not between", value1, value2, "quitDrink");
            return (Criteria) this;
        }

        public Criteria andQuitDrinkTimeIsNull() {
            addCriterion("quit_drink_time is null");
            return (Criteria) this;
        }

        public Criteria andQuitDrinkTimeIsNotNull() {
            addCriterion("quit_drink_time is not null");
            return (Criteria) this;
        }

        public Criteria andQuitDrinkTimeEqualTo(String value) {
            addCriterion("quit_drink_time =", value, "quitDrinkTime");
            return (Criteria) this;
        }

        public Criteria andQuitDrinkTimeNotEqualTo(String value) {
            addCriterion("quit_drink_time <>", value, "quitDrinkTime");
            return (Criteria) this;
        }

        public Criteria andQuitDrinkTimeGreaterThan(String value) {
            addCriterion("quit_drink_time >", value, "quitDrinkTime");
            return (Criteria) this;
        }

        public Criteria andQuitDrinkTimeGreaterThanOrEqualTo(String value) {
            addCriterion("quit_drink_time >=", value, "quitDrinkTime");
            return (Criteria) this;
        }

        public Criteria andQuitDrinkTimeLessThan(String value) {
            addCriterion("quit_drink_time <", value, "quitDrinkTime");
            return (Criteria) this;
        }

        public Criteria andQuitDrinkTimeLessThanOrEqualTo(String value) {
            addCriterion("quit_drink_time <=", value, "quitDrinkTime");
            return (Criteria) this;
        }

        public Criteria andQuitDrinkTimeLike(String value) {
            addCriterion("quit_drink_time like", value, "quitDrinkTime");
            return (Criteria) this;
        }

        public Criteria andQuitDrinkTimeNotLike(String value) {
            addCriterion("quit_drink_time not like", value, "quitDrinkTime");
            return (Criteria) this;
        }

        public Criteria andQuitDrinkTimeIn(List<String> values) {
            addCriterion("quit_drink_time in", values, "quitDrinkTime");
            return (Criteria) this;
        }

        public Criteria andQuitDrinkTimeNotIn(List<String> values) {
            addCriterion("quit_drink_time not in", values, "quitDrinkTime");
            return (Criteria) this;
        }

        public Criteria andQuitDrinkTimeBetween(String value1, String value2) {
            addCriterion("quit_drink_time between", value1, value2, "quitDrinkTime");
            return (Criteria) this;
        }

        public Criteria andQuitDrinkTimeNotBetween(String value1, String value2) {
            addCriterion("quit_drink_time not between", value1, value2, "quitDrinkTime");
            return (Criteria) this;
        }

        public Criteria andIqDateIsNull() {
            addCriterion("iq_date is null");
            return (Criteria) this;
        }

        public Criteria andIqDateIsNotNull() {
            addCriterion("iq_date is not null");
            return (Criteria) this;
        }

        public Criteria andIqDateEqualTo(Date value) {
            addCriterionForJDBCDate("iq_date =", value, "iqDate");
            return (Criteria) this;
        }

        public Criteria andIqDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("iq_date <>", value, "iqDate");
            return (Criteria) this;
        }

        public Criteria andIqDateGreaterThan(Date value) {
            addCriterionForJDBCDate("iq_date >", value, "iqDate");
            return (Criteria) this;
        }

        public Criteria andIqDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("iq_date >=", value, "iqDate");
            return (Criteria) this;
        }

        public Criteria andIqDateLessThan(Date value) {
            addCriterionForJDBCDate("iq_date <", value, "iqDate");
            return (Criteria) this;
        }

        public Criteria andIqDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("iq_date <=", value, "iqDate");
            return (Criteria) this;
        }

        public Criteria andIqDateIn(List<Date> values) {
            addCriterionForJDBCDate("iq_date in", values, "iqDate");
            return (Criteria) this;
        }

        public Criteria andIqDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("iq_date not in", values, "iqDate");
            return (Criteria) this;
        }

        public Criteria andIqDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("iq_date between", value1, value2, "iqDate");
            return (Criteria) this;
        }

        public Criteria andIqDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("iq_date not between", value1, value2, "iqDate");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNull() {
            addCriterion("delete_flag is null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNotNull() {
            addCriterion("delete_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagEqualTo(Integer value) {
            addCriterion("delete_flag =", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotEqualTo(Integer value) {
            addCriterion("delete_flag <>", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThan(Integer value) {
            addCriterion("delete_flag >", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("delete_flag >=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThan(Integer value) {
            addCriterion("delete_flag <", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThanOrEqualTo(Integer value) {
            addCriterion("delete_flag <=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIn(List<Integer> values) {
            addCriterion("delete_flag in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotIn(List<Integer> values) {
            addCriterion("delete_flag not in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagBetween(Integer value1, Integer value2) {
            addCriterion("delete_flag between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("delete_flag not between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}