package com.portfolio.personal.divvy.domain;

import java.math.BigDecimal;
import java.util.UUID;

public class Session {

    public Session (UUID id, String joinSessionCode, String restaurantName, BigDecimal tipRate, BigDecimal impoconsumoRate, boolean impoconsumoIncludedInPrices,BigDecimal ivaRate){
        this.id = id;
        this.joinSessionCode = joinSessionCode;
        this.restaurantName = restaurantName;
        this.tipRate = tipRate;
        this.status = SessionStatus.OPEN;
        this.impoconsumoRate = impoconsumoRate;
        this.impoconsumoIncludedInPrices = impoconsumoIncludedInPrices;
        this.ivaRate = ivaRate;
    }
    private final UUID id;
    private final String joinSessionCode;
    private final String restaurantName;
    private SessionStatus status;
    private final BigDecimal tipRate;
    private final BigDecimal impoconsumoRate;
    private boolean impoconsumoIncludedInPrices;
    private final BigDecimal ivaRate;

    public UUID getId() {return id;}
    public String getJoinSessionCode() {return joinSessionCode;}
    public String getRestaurantName() {return restaurantName;}
    public SessionStatus getStatus() {return status;}
    public BigDecimal getTipRate() {return tipRate;}
    public BigDecimal getImpoconsumoRate() {return impoconsumoRate;}
    public boolean isImpoconsumoIncludedInPrices() {return impoconsumoIncludedInPrices;}
    public BigDecimal getIvaRate() {return ivaRate;}


    @Override
    public boolean equals(Object o) {
        //Validates first hand if they are the same object in memory
        if (this == o) return true;
        //Object not an instance of session, discard it immediately
        if (!(o instanceof Session)) return false;
        //Previous line didn't trigger, we got an object thats an instance of Session, then we can cast it to see if its ids match
        Session other = (Session) o;
        return this.id.equals(other.id);
    }

    //Hashcode has to be overridden in pair with equal, since the hashcode also uses memory location matching
    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
