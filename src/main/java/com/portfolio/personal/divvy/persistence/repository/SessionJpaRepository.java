package com.portfolio.personal.divvy.persistence.repository;

import com.portfolio.personal.divvy.persistence.entity.SessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

/*By extending JpaRepository methods to find by id, to save, to findAll are already written so we need based on the flow of the app new methods to find for example the session
by using the session code. (Declare a method only when a real flow in the app needs that lookup.)*/

public interface SessionJpaRepository extends JpaRepository <SessionEntity, UUID>   {
//Right now by just extending JpaRepository, we have a way to find SessionEntity but only with its ID, something that a person after joining with a qr code doesn't have



/*findBy method name references the following name to find what's needed in this custom method, this case JoinSessionCode(first letter capitalized) */
//Since JoinSessionCode is a string it has to match the argument(that's the type we are pulling from db).
    Optional<SessionEntity> findByJoinSessionCode(String sessionCode);
}
