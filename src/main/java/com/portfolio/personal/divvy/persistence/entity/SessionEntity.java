package com.portfolio.personal.divvy.persistence.entity;

import com.portfolio.personal.divvy.domain.SessionStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "sessions")
public class SessionEntity {

    public SessionEntity() {}

    @Id
    private UUID id;

    @Column(name = "join_session_code")
    private String joinSessionCode;

    @Column(name = "restaurant_name")
    private String restaurantName;

    //Used since sessionStatus is an enum, defaulted to ordinal number position (0 for open,1,2) by default
    @Enumerated(EnumType.STRING)
    @Column(name = "session_status")
    private SessionStatus sessionStatus;

    @Column(name = "tip_rate")
    private BigDecimal tipRate;

    @Column(name = "impoconsumo_rate")
    private BigDecimal impoconsumoRate;

    @Column(name = "impoconsumo_included_in_prices")
    private boolean impoconsumoIncludedInPrices;

    @Column(name = "iva_rate")
    private BigDecimal ivaRate;

    public UUID getId() {return this.id;}
    public void setId(UUID id) {this.id = id;}

    public String getJoinSessionCode() {return this.joinSessionCode;}
    public void setJoinSessionCode(String joinSessionCode) {this.joinSessionCode = joinSessionCode;}

    public String getRestaurantName() {return this.restaurantName;}
    public void setRestaurantName(String restaurantName) {this.restaurantName = restaurantName;}

    public SessionStatus getSessionStatus() {return this.sessionStatus;}
    public void setSessionStatus(SessionStatus sessionStatus) {this.sessionStatus = sessionStatus;}

    public BigDecimal getTipRate() {return this.tipRate;}
    public void setTipRate(BigDecimal tipRate) {this.tipRate = tipRate;}

    public BigDecimal getImpoconsumoRate() {return this.impoconsumoRate;}
    public void setImpoconsumoRate(BigDecimal impoconsumoRate) {this.impoconsumoRate = impoconsumoRate;}

    public boolean isImpoconsumoIncludedInPrices() {return this.impoconsumoIncludedInPrices;}
    public void setImpoconsumoIncludedInPrices(boolean impoconsumoIncludedInPrices) {this.impoconsumoIncludedInPrices = impoconsumoIncludedInPrices;}

    public BigDecimal getIvaRate() {return this.ivaRate;}
    public void setIvaRate(BigDecimal ivaRate) {this.ivaRate = ivaRate;}
}
