package com.portfolio.personal.divvy.persistence.repository;


import com.portfolio.personal.divvy.persistence.entity.ClaimEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;


//Remember, here the id is one completely new generated with UUID.randomn, so we are missing ways to return claims with item and participant Ids.
public interface ClaimJpaRepository extends JpaRepository<ClaimEntity, UUID> {

//The list of Items already provided by the method in ItemJpaRepository.
//We need to use those items to find who claimed them in the corresponding session (db contains all previous sessions, and we filter with ItemRepository the session of the items needed).

    //"Return me the claims that match these items", ItemRepository already returns the items matching the session with the joinSession code.
    List<ClaimEntity> findByItemIdIn(List<UUID> itemIds);


    //"Return the claims matching this specific user or participant Id".
    List<ClaimEntity> findByParticipantId(UUID participantId);

    boolean existsByParticipantIdAndItemId(UUID participantId, UUID itemId);

    @Transactional
    void deleteByParticipantIdAndItemId(UUID participantId, UUID itemId);

}
