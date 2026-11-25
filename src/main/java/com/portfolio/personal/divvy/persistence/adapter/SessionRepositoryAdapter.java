package com.portfolio.personal.divvy.persistence.adapter;

import com.portfolio.personal.divvy.domain.Session;
import com.portfolio.personal.divvy.persistence.entity.SessionEntity;
import com.portfolio.personal.divvy.persistence.mapper.SessionMapper;
import com.portfolio.personal.divvy.persistence.repository.SessionJpaRepository;
import com.portfolio.personal.divvy.service.port.SessionRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
//Repository vs component. They are registered the same way but @Repository has its own database specific exceptions and types
@Repository
public class SessionRepositoryAdapter implements SessionRepository {

    //Since SessionJpaRepository is injected it needs to be managed by spring, something already done by its extension from JpaRepository, which at runtime creates the SessionJpaRepository implementation and that implementation is created as a Bean, which is already managed by spring
    //SessionRepositoryAdapter already implements an interface, but we need to use another one, JPA in this case. We cant use new on an interface so we instead use it on the class constructor for spring to manage it
    //Since sessionJPaRepository is built at runtime, it automatically does the transaction handling, database connection, all handled by spring otherwise well have to do it manually
    //SessionJpaRepository is the means we have to interact with the database, but we also need that data to be used in domain terms here in HA.

    public SessionRepositoryAdapter(SessionJpaRepository sessionJpaRepository, SessionMapper sessionMapper){
        this.sessionJpaRepository = sessionJpaRepository;
        this.sessionMapper = sessionMapper;
    }



    private final SessionJpaRepository sessionJpaRepository;
    private final SessionMapper sessionMapper;

    @Override
    public Session save(Session session){
       return sessionMapper.toDomain(sessionJpaRepository.save(sessionMapper.toEntity(session)));
    }


    //We cant use sessionMapper.toDomain(sessionJpaRepository.findByJoinSessionCode(sessionCode))
    //toDomain expects a SessionEntity, not an Optional<SessionEntity>. Optional here is like a box, that either contains something or not and the compiler won't allow one of them to be left out
    @Override
    public Optional<Session> findByJoinSessionCode(String sessionCode){
    return sessionJpaRepository.findByJoinSessionCode(sessionCode).map(sessionMapper::toDomain);
    //.map checks both Optional scenarios in the background and only applies it to the specified function if it finds it.
    //.map solves the case of emptiness of optional so compiler allows it.

    }

    @Override
    public Optional<Session> findById(UUID sessionId){

       return (sessionJpaRepository.findById(sessionId)).map(sessionMapper::toDomain);
    }
}
