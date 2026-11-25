package com.portfolio.personal.divvy.service.port;

import com.portfolio.personal.divvy.domain.Session;


import java.util.Optional;
import java.util.UUID;

public interface SessionRepository {

Session save(Session session);

Optional<Session> findByJoinSessionCode(String joinSessionCode);

Optional<Session> findById(UUID sessionId);
}
