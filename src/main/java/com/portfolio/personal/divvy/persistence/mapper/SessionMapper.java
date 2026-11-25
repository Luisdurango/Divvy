package com.portfolio.personal.divvy.persistence.mapper;

import com.portfolio.personal.divvy.domain.Session;
import com.portfolio.personal.divvy.persistence.entity.SessionEntity;
import org.springframework.stereotype.Component;
//This annotation is added so Spring automatically manages at startup. Adding this open the window for dependency injection, done in SessionRepositoryAdapter constructor.
//SessionMapper lives in persistence, so it doesn't break Hexagonal architecture.
@Component
public class SessionMapper {

    public SessionEntity toEntity(Session domainSession){
    SessionEntity entity = new SessionEntity();

    entity.setId(domainSession.getId());
    entity.setJoinSessionCode(domainSession.getJoinSessionCode());
    entity.setRestaurantName(domainSession.getRestaurantName());
    entity.setSessionStatus(domainSession.getStatus());
    entity.setTipRate(domainSession.getTipRate());
    entity.setImpoconsumoRate(domainSession.getImpoconsumoRate());
    entity.setImpoconsumoIncludedInPrices(domainSession.isImpoconsumoIncludedInPrices());
    entity.setIvaRate(domainSession.getIvaRate());

    return entity;
    }

    public Session toDomain(SessionEntity entity){
    return Session.reconstructPersEntity(entity.getId(),entity.getJoinSessionCode(),
            entity.getRestaurantName(), entity.getTipRate(), entity.getSessionStatus(),
            entity.getImpoconsumoRate(), entity.isImpoconsumoIncludedInPrices(),
            entity.getIvaRate());
    }
}
