package com.finartz.airlines.ticketing.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Airlines {

    @Id
    @Column(name = "company_code", nullable = false, updatable = false)
    private String companyCode;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    public Airlines() {
    }

    public Airlines(String companyCode, String companyName) {
        this.companyCode = companyCode;
        this.companyName = companyName;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "Airlines{" + "companyCode=" + companyCode + ", companyName=" + companyName + '}';
    }

}
