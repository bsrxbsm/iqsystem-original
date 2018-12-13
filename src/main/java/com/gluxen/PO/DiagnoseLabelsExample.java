package com.gluxen.PO;

import java.util.ArrayList;
import java.util.List;

public class DiagnoseLabelsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public DiagnoseLabelsExample() {
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

        public Criteria andDiagnoseLabelsIsNull() {
            addCriterion("diagnose_labels is null");
            return (Criteria) this;
        }

        public Criteria andDiagnoseLabelsIsNotNull() {
            addCriterion("diagnose_labels is not null");
            return (Criteria) this;
        }

        public Criteria andDiagnoseLabelsEqualTo(String value) {
            addCriterion("diagnose_labels =", value, "diagnoseLabels");
            return (Criteria) this;
        }

        public Criteria andDiagnoseLabelsNotEqualTo(String value) {
            addCriterion("diagnose_labels <>", value, "diagnoseLabels");
            return (Criteria) this;
        }

        public Criteria andDiagnoseLabelsGreaterThan(String value) {
            addCriterion("diagnose_labels >", value, "diagnoseLabels");
            return (Criteria) this;
        }

        public Criteria andDiagnoseLabelsGreaterThanOrEqualTo(String value) {
            addCriterion("diagnose_labels >=", value, "diagnoseLabels");
            return (Criteria) this;
        }

        public Criteria andDiagnoseLabelsLessThan(String value) {
            addCriterion("diagnose_labels <", value, "diagnoseLabels");
            return (Criteria) this;
        }

        public Criteria andDiagnoseLabelsLessThanOrEqualTo(String value) {
            addCriterion("diagnose_labels <=", value, "diagnoseLabels");
            return (Criteria) this;
        }

        public Criteria andDiagnoseLabelsLike(String value) {
            addCriterion("diagnose_labels like", value, "diagnoseLabels");
            return (Criteria) this;
        }

        public Criteria andDiagnoseLabelsNotLike(String value) {
            addCriterion("diagnose_labels not like", value, "diagnoseLabels");
            return (Criteria) this;
        }

        public Criteria andDiagnoseLabelsIn(List<String> values) {
            addCriterion("diagnose_labels in", values, "diagnoseLabels");
            return (Criteria) this;
        }

        public Criteria andDiagnoseLabelsNotIn(List<String> values) {
            addCriterion("diagnose_labels not in", values, "diagnoseLabels");
            return (Criteria) this;
        }

        public Criteria andDiagnoseLabelsBetween(String value1, String value2) {
            addCriterion("diagnose_labels between", value1, value2, "diagnoseLabels");
            return (Criteria) this;
        }

        public Criteria andDiagnoseLabelsNotBetween(String value1, String value2) {
            addCriterion("diagnose_labels not between", value1, value2, "diagnoseLabels");
            return (Criteria) this;
        }

        public Criteria andInquiryIdIsNull() {
            addCriterion("inquiry_id is null");
            return (Criteria) this;
        }

        public Criteria andInquiryIdIsNotNull() {
            addCriterion("inquiry_id is not null");
            return (Criteria) this;
        }

        public Criteria andInquiryIdEqualTo(Long value) {
            addCriterion("inquiry_id =", value, "inquiryId");
            return (Criteria) this;
        }

        public Criteria andInquiryIdNotEqualTo(Long value) {
            addCriterion("inquiry_id <>", value, "inquiryId");
            return (Criteria) this;
        }

        public Criteria andInquiryIdGreaterThan(Long value) {
            addCriterion("inquiry_id >", value, "inquiryId");
            return (Criteria) this;
        }

        public Criteria andInquiryIdGreaterThanOrEqualTo(Long value) {
            addCriterion("inquiry_id >=", value, "inquiryId");
            return (Criteria) this;
        }

        public Criteria andInquiryIdLessThan(Long value) {
            addCriterion("inquiry_id <", value, "inquiryId");
            return (Criteria) this;
        }

        public Criteria andInquiryIdLessThanOrEqualTo(Long value) {
            addCriterion("inquiry_id <=", value, "inquiryId");
            return (Criteria) this;
        }

        public Criteria andInquiryIdIn(List<Long> values) {
            addCriterion("inquiry_id in", values, "inquiryId");
            return (Criteria) this;
        }

        public Criteria andInquiryIdNotIn(List<Long> values) {
            addCriterion("inquiry_id not in", values, "inquiryId");
            return (Criteria) this;
        }

        public Criteria andInquiryIdBetween(Long value1, Long value2) {
            addCriterion("inquiry_id between", value1, value2, "inquiryId");
            return (Criteria) this;
        }

        public Criteria andInquiryIdNotBetween(Long value1, Long value2) {
            addCriterion("inquiry_id not between", value1, value2, "inquiryId");
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