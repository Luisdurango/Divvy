package com.portfolio.personal.divvy.domain;

import java.math.BigDecimal;
import java.util.UUID;

public class Session {

    private Session(UUID id, String joinSessionCode, String restaurantName, BigDecimal tipRate,SessionStatus status, BigDecimal impoconsumoRate, boolean impoconsumoIncludedInPrices, BigDecimal ivaRate) {
        this.id = id;
        this.joinSessionCode = joinSessionCode;
        this.restaurantName = restaurantName;
        this.tipRate = tipRate;
        this.status = status;
        this.impoconsumoRate = impoconsumoRate;
        this.impoconsumoIncludedInPrices = impoconsumoIncludedInPrices;
        this.ivaRate = ivaRate;
    }

    public static Session startNew(UUID id, String joinSessionCode, String restaurantName, BigDecimal tipRate, BigDecimal impoconsumoRate, boolean impoconsumoIncludedInPrices, BigDecimal ivaRate){
        return new Session(id, joinSessionCode, restaurantName, tipRate,SessionStatus.OPEN, impoconsumoRate, impoconsumoIncludedInPrices, ivaRate);
    }

    public static Session reconstructPersEntity(UUID id, String joinSessionCode, String restaurantName, BigDecimal tipRate,SessionStatus status, BigDecimal impoconsumoRate, boolean impoconsumoIncludedInPrices, BigDecimal ivaRate){
        return new Session(id, joinSessionCode, restaurantName, tipRate, status, impoconsumoRate, impoconsumoIncludedInPrices, ivaRate);


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
        if (this == o) return true;
        if (!(o instanceof Session)) return false;
        Session other = (Session) o;
        return this.id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }
}
