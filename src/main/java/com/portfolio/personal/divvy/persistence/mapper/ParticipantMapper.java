package com.portfolio.personal.divvy.persistence.mapper;

import com.portfolio.personal.divvy.domain.Participant;
import com.portfolio.personal.divvy.persistence.entity.ParticipantEntity;
import org.springframework.stereotype.Component;

@Component
public class ParticipantMapper {

    public ParticipantEntity toEntity(Participant domainParticipant){

        ParticipantEntity participantEntity = new ParticipantEntity();

        participantEntity.setId(domainParticipant.getId());
        participantEntity.setSessionId(domainParticipant.getSessionID());
        participantEntity.setParticipantName(domainParticipant.getParticipantName());
        participantEntity.setOptTipIn(domainParticipant.isOptTipIn());
        participantEntity.setOrganizer(domainParticipant.isOrganizer());

        return participantEntity;
    }

    public Participant toDomain(ParticipantEntity participantEntity){

        return new Participant(participantEntity.getId(),participantEntity.getSessionId(),
                participantEntity.getParticipantName(),participantEntity.isOptTipIn(),
                participantEntity.isOrganizer());
    }

}
