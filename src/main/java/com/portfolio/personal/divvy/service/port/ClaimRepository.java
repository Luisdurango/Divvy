package com.portfolio.personal.divvy.service.port;


import com.portfolio.personal.divvy.domain.Claim;

import java.util.List;
import java.util.UUID;

public interface ClaimRepository {

//Someone claim an item, it is stored subsequently
Claim save(Claim claim);
//Claims used by the calculator
List<Claim> findByItemIdIn(List<UUID> itemIds);
//All claims of participant
List<Claim> findByParticipantId(UUID participantId);
//An item is removed from the claim
 void deleteByParticipantIdAndItemId(UUID participantId, UUID itemId );
 //Check weather a claim exists already
 boolean existsByParticipantIdAndItemId(UUID participantId, UUID itemId);

}
