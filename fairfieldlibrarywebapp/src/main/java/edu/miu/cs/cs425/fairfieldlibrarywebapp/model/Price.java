package edu.miu.cs.cs425.fairfieldlibrarywebapp.model;

import javax.persistence.Embeddable;

@Embeddable
public class Price implements ValueObject{
    private String currencyCode;
    private Double priceAmount;

    public Price() {
        // This constructor is need by Hibernate
    }

    public Price(String currencyCode, Double priceAmount) {
        this.currencyCode = currencyCode;
        this.priceAmount = priceAmount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Double getPriceAmount() {
        return priceAmount;
    }

    public void setPriceAmount(Double priceAmount) {
        this.priceAmount = priceAmount;
    }
}
