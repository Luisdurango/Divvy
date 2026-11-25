package com.portfolio.personal.divvy.persistence.mapper;

import com.portfolio.personal.divvy.domain.Claim;
import com.portfolio.personal.divvy.persistence.entity.ClaimEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Component
public class ClaimMapper {

    public ClaimEntity toEntity(Claim claim){

        ClaimEntity entity = new ClaimEntity();

        entity.setId(UUID.randomUUID());
        entity.setItemId(claim.itemId());
        entity.setParticipantId(claim.participantId());

        return entity;
    }




    public Claim toDomain (ClaimEntity claimEntity){

        return new Claim(claimEntity.getParticipantId(), claimEntity.getItemId());
    }
}
