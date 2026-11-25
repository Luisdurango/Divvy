package com.portfolio.personal.divvy.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "participants")
public class ParticipantEntity {

    public ParticipantEntity() {}

    @Id
    private UUID id;

    @Column(name = "session_id")
    private UUID sessionId;

    @Column(name = "participant_name")
    private String participantName;

    @Column(name = "opt_tip_in")
    private boolean optTipIn;

    @Column(name = "organizer")
    private boolean organizer;

    public UUID getId(){return this.id;}
    public void setId(UUID id) {this.id = id;}

    public UUID getSessionId(){return this.sessionId;}
    public void setSessionId(UUID sessionId){this.sessionId = sessionId;}

    public String getParticipantName(){return this.participantName;}
    public void setParticipantName(String participantName){this.participantName = participantName;}

    public boolean isOptTipIn(){return this.optTipIn;}
    public void setOptTipIn(boolean optTipIn){this.optTipIn = optTipIn;}

    public boolean isOrganizer(){return this.organizer;}
    public void setOrganizer(boolean organizer){this.organizer = organizer;}
}
