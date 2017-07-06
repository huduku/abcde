package com.abcde.validate;


import java.math.BigDecimal;
import java.util.List;

public class ValidateModel {

    private String fieldName;
    private Boolean required;
    private String[] alias;
    private Integer[] length;
    private BigDecimal[] range;
    private String[] dateRange;
    private String regex;
    private List<String> optItems;
    private Integer dictLevel;
    private String dictParentId;
    private String validateMethod;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public String[] getAlias() {
        return alias;
    }

    public void setAlias(String[] alias) {
        this.alias = alias;
    }

    public Integer[] getLength() {
        return length;
    }

    public void setLength(Integer[] length) {
        this.length = length;
    }

    public BigDecimal[] getRange() {
        return range;
    }

    public void setRange(BigDecimal[] range) {
        this.range = range;
    }

    public String[] getDateRange() {
        return dateRange;
    }

    public void setDateRange(String[] dateRange) {
        this.dateRange = dateRange;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public List<String> getOptItems() {
        return optItems;
    }

    public void setOptItems(List<String> optItems) {
        this.optItems = optItems;
    }

    public Integer getDictLevel() {
        return dictLevel;
    }

    public void setDictLevel(Integer dictLevel) {
        this.dictLevel = dictLevel;
    }

    public String getDictParentId() {
        return dictParentId;
    }

    public void setDictParentId(String dictParentId) {
        this.dictParentId = dictParentId;
    }

    public String getValidateMethod() {
        return validateMethod;
    }

    public void setValidateMethod(String validateMethod) {
        this.validateMethod = validateMethod;
    }




}
