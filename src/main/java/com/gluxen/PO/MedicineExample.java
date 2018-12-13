package com.gluxen.PO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MedicineExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MedicineExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMedicineNameIsNull() {
            addCriterion("medicine_name is null");
            return (Criteria) this;
        }

        public Criteria andMedicineNameIsNotNull() {
            addCriterion("medicine_name is not null");
            return (Criteria) this;
        }

        public Criteria andMedicineNameEqualTo(String value) {
            addCriterion("medicine_name =", value, "medicineName");
            return (Criteria) this;
        }

        public Criteria andMedicineNameNotEqualTo(String value) {
            addCriterion("medicine_name <>", value, "medicineName");
            return (Criteria) this;
        }

        public Criteria andMedicineNameGreaterThan(String value) {
            addCriterion("medicine_name >", value, "medicineName");
            return (Criteria) this;
        }

        public Criteria andMedicineNameGreaterThanOrEqualTo(String value) {
            addCriterion("medicine_name >=", value, "medicineName");
            return (Criteria) this;
        }

        public Criteria andMedicineNameLessThan(String value) {
            addCriterion("medicine_name <", value, "medicineName");
            return (Criteria) this;
        }

        public Criteria andMedicineNameLessThanOrEqualTo(String value) {
            addCriterion("medicine_name <=", value, "medicineName");
            return (Criteria) this;
        }

        public Criteria andMedicineNameLike(String value) {
            addCriterion("medicine_name like", value, "medicineName");
            return (Criteria) this;
        }

        public Criteria andMedicineNameNotLike(String value) {
            addCriterion("medicine_name not like", value, "medicineName");
            return (Criteria) this;
        }

        public Criteria andMedicineNameIn(List<String> values) {
            addCriterion("medicine_name in", values, "medicineName");
            return (Criteria) this;
        }

        public Criteria andMedicineNameNotIn(List<String> values) {
            addCriterion("medicine_name not in", values, "medicineName");
            return (Criteria) this;
        }

        public Criteria andMedicineNameBetween(String value1, String value2) {
            addCriterion("medicine_name between", value1, value2, "medicineName");
            return (Criteria) this;
        }

        public Criteria andMedicineNameNotBetween(String value1, String value2) {
            addCriterion("medicine_name not between", value1, value2, "medicineName");
            return (Criteria) this;
        }

        public Criteria andMedicinePriceIsNull() {
            addCriterion("medicine_price is null");
            return (Criteria) this;
        }

        public Criteria andMedicinePriceIsNotNull() {
            addCriterion("medicine_price is not null");
            return (Criteria) this;
        }

        public Criteria andMedicinePriceEqualTo(BigDecimal value) {
            addCriterion("medicine_price =", value, "medicinePrice");
            return (Criteria) this;
        }

        public Criteria andMedicinePriceNotEqualTo(BigDecimal value) {
            addCriterion("medicine_price <>", value, "medicinePrice");
            return (Criteria) this;
        }

        public Criteria andMedicinePriceGreaterThan(BigDecimal value) {
            addCriterion("medicine_price >", value, "medicinePrice");
            return (Criteria) this;
        }

        public Criteria andMedicinePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("medicine_price >=", value, "medicinePrice");
            return (Criteria) this;
        }

        public Criteria andMedicinePriceLessThan(BigDecimal value) {
            addCriterion("medicine_price <", value, "medicinePrice");
            return (Criteria) this;
        }

        public Criteria andMedicinePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("medicine_price <=", value, "medicinePrice");
            return (Criteria) this;
        }

        public Criteria andMedicinePriceIn(List<BigDecimal> values) {
            addCriterion("medicine_price in", values, "medicinePrice");
            return (Criteria) this;
        }

        public Criteria andMedicinePriceNotIn(List<BigDecimal> values) {
            addCriterion("medicine_price not in", values, "medicinePrice");
            return (Criteria) this;
        }

        public Criteria andMedicinePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("medicine_price between", value1, value2, "medicinePrice");
            return (Criteria) this;
        }

        public Criteria andMedicinePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("medicine_price not between", value1, value2, "medicinePrice");
            return (Criteria) this;
        }

        public Criteria andMedicineStockIsNull() {
            addCriterion("medicine_stock is null");
            return (Criteria) this;
        }

        public Criteria andMedicineStockIsNotNull() {
            addCriterion("medicine_stock is not null");
            return (Criteria) this;
        }

        public Criteria andMedicineStockEqualTo(Integer value) {
            addCriterion("medicine_stock =", value, "medicineStock");
            return (Criteria) this;
        }

        public Criteria andMedicineStockNotEqualTo(Integer value) {
            addCriterion("medicine_stock <>", value, "medicineStock");
            return (Criteria) this;
        }

        public Criteria andMedicineStockGreaterThan(Integer value) {
            addCriterion("medicine_stock >", value, "medicineStock");
            return (Criteria) this;
        }

        public Criteria andMedicineStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("medicine_stock >=", value, "medicineStock");
            return (Criteria) this;
        }

        public Criteria andMedicineStockLessThan(Integer value) {
            addCriterion("medicine_stock <", value, "medicineStock");
            return (Criteria) this;
        }

        public Criteria andMedicineStockLessThanOrEqualTo(Integer value) {
            addCriterion("medicine_stock <=", value, "medicineStock");
            return (Criteria) this;
        }

        public Criteria andMedicineStockIn(List<Integer> values) {
            addCriterion("medicine_stock in", values, "medicineStock");
            return (Criteria) this;
        }

        public Criteria andMedicineStockNotIn(List<Integer> values) {
            addCriterion("medicine_stock not in", values, "medicineStock");
            return (Criteria) this;
        }

        public Criteria andMedicineStockBetween(Integer value1, Integer value2) {
            addCriterion("medicine_stock between", value1, value2, "medicineStock");
            return (Criteria) this;
        }

        public Criteria andMedicineStockNotBetween(Integer value1, Integer value2) {
            addCriterion("medicine_stock not between", value1, value2, "medicineStock");
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