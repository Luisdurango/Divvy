package com.portfolio.personal.divvy.persistence.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "claims")
public class ClaimEntity {

    public ClaimEntity() {
    }

    /* Even tough the domain object doesn't have an Id, entity need one since is the one class that's going to be persisted*/
    @Id
    private UUID id;

    @Column(name = "participant_id")
    private UUID participantId;

    @Column(name = "item_id")
    private UUID itemId;



    public UUID getId(){return this.id;}
    public void setId(UUID id){this.id = id;}

    public UUID getParticipantId() {return participantId;}
    public void setParticipantId(UUID participantId){this.participantId = participantId;}

    public UUID getItemId(){return this.itemId;}
    public void setItemId(UUID itemId){this.itemId = itemId;}
}
