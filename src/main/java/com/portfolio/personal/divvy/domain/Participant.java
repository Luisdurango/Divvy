package com.portfolio.personal.divvy.domain;

import java.util.UUID;

public class Participant {

    public Participant(UUID id, UUID sessionID, String participantName, boolean optTipIn, boolean organizer) {
        this.id = id;
        this.sessionID = sessionID;
        this.participantName = participantName;
        this.optTipIn = optTipIn;
        this.organizer = organizer;
    }

    private final UUID id;
    private final UUID sessionID;
    private String participantName;
    private boolean optTipIn;
    private final boolean organizer;

    public UUID getId() {return id;}
    public UUID getSessionID() {return sessionID;}
    public String getParticipantName() {return participantName;}
    public boolean isOptTipIn() {return optTipIn;}
    public boolean isOrganizer() {return organizer;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Participant)) return false;
        Participant participant = (Participant) o;
        return this.id.equals(participant.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
