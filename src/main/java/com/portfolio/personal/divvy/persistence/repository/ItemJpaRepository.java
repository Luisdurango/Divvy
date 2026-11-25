package com.portfolio.personal.divvy.persistence.repository;

import com.portfolio.personal.divvy.persistence.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;


//Jpa repositories are the tools inside the persistence adapter(port comes next).
public interface ItemJpaRepository extends JpaRepository<ItemEntity, UUID> {

    /*Overall flow to why we need this method comes from what each participant has access to when joining and creating the participant object,
    since the only means to reach the items data is through sessionId

    Here's how:
    1.Scanning QR gives session code, SessionJpaRepository has the Optional method for this "findByJoinSessionCode", it brings the SessionEntity by providing the session code.
    2.SessionId is then queried to the database, look at Item variables, it contains sessionId, so by cross-referencing this is we are able to bring all the items.
    */


    //Bring a list of items by using the sessionId (where? in the ItemEntity, specified in JpaRepository<ItemEntity, UUID>
    List<ItemEntity> findBySessionId(UUID sessionId);
}
