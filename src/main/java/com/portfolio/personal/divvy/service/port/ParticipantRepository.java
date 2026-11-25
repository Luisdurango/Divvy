package com.portfolio.personal.divvy.service.port;

import com.portfolio.personal.divvy.domain.Participant;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ParticipantRepository {


    List<Participant> findBySessionId(UUID sessionId);
    Optional<Participant> findById(UUID participantId);
    Participant save(Participant participant);

}
