package com.portfolio.personal.divvy.persistence.adapter;

import com.portfolio.personal.divvy.domain.Participant;
import com.portfolio.personal.divvy.persistence.entity.ParticipantEntity;
import com.portfolio.personal.divvy.persistence.mapper.ParticipantMapper;
import com.portfolio.personal.divvy.persistence.repository.ParticipantJpaRepository;
import com.portfolio.personal.divvy.service.port.ParticipantRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ParticipantRepositoryAdapter implements ParticipantRepository {


    public ParticipantRepositoryAdapter(ParticipantJpaRepository participantJpaRepository, ParticipantMapper participantMapper) {
        this.participantJpaRepository = participantJpaRepository;
        this.participantMapper = participantMapper;

    }

    private final ParticipantJpaRepository participantJpaRepository;
    private final ParticipantMapper participantMapper;


    @Override
    public List<Participant> findBySessionId(UUID sessionId) {
        List<ParticipantEntity> participantEntities = participantJpaRepository.findBySessionId(sessionId);
        return participantEntities.stream().map(participantMapper::toDomain).toList();
    }

    @Override
    public Optional<Participant> findById(UUID participantId) {
         return (participantJpaRepository.findById(participantId)).map(participantMapper::toDomain);

    }

    @Override
    public Participant save(Participant participant) {
        return participantMapper.toDomain(participantJpaRepository.save(participantMapper.toEntity(participant)));
    }
}