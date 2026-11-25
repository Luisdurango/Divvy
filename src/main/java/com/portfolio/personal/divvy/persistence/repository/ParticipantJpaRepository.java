package com.portfolio.personal.divvy.persistence.repository;

import com.portfolio.personal.divvy.persistence.entity.ParticipantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ParticipantJpaRepository extends JpaRepository<ParticipantEntity, UUID> {

    /*The choice of finding all the participants with sessionId comes from the need of finding the hand full we need and not every participant even from previous
    sessions, which is what findAll given by JpaRepository does*/

    //"Give me the list of all participants by using the SessionId".
    //findBySessionId (look in the ParticipantEntityTable for this row) using the argument sessionId.

    List<ParticipantEntity> findBySessionId(UUID sessionId);

}
