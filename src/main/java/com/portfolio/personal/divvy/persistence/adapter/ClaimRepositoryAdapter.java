package com.portfolio.personal.divvy.persistence.adapter;

import com.portfolio.personal.divvy.domain.Claim;
import com.portfolio.personal.divvy.persistence.entity.ClaimEntity;
import com.portfolio.personal.divvy.persistence.mapper.ClaimMapper;
import com.portfolio.personal.divvy.persistence.repository.ClaimJpaRepository;
import com.portfolio.personal.divvy.service.port.ClaimRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class ClaimRepositoryAdapter implements ClaimRepository {

    public ClaimRepositoryAdapter(ClaimJpaRepository claimJpaRepository, ClaimMapper claimMapper){
        this.claimJpaRepository = claimJpaRepository;
        this.claimMapper = claimMapper;
    }

    private final ClaimJpaRepository claimJpaRepository;
    private final ClaimMapper claimMapper;



    @Override
    public Claim save(Claim claim) {
        return claimMapper.toDomain(claimJpaRepository.save(claimMapper.toEntity(claim)));
    }

    @Override
    public List<Claim> findByItemIdIn(List<UUID> itemIds) {

       List<ClaimEntity>claimEntities = claimJpaRepository.findByItemIdIn(itemIds);
        return claimEntities.stream().map(claimMapper::toDomain).toList();
    }

    @Override
    public List<Claim> findByParticipantId(UUID participantId) {

        List<ClaimEntity> claimEntities = claimJpaRepository.findByParticipantId(participantId);
        return claimEntities.stream().map(claimMapper::toDomain).toList();
    }

    @Override
    public void deleteByParticipantIdAndItemId(UUID participantId, UUID itemId) {
    claimJpaRepository.deleteByParticipantIdAndItemId(participantId, itemId);
    }

    @Override
    public boolean existsByParticipantIdAndItemId(UUID participantId, UUID itemId) {

        return claimJpaRepository.existsByParticipantIdAndItemId(participantId, itemId);
    }
}
