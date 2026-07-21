package com.portfolio.personal.divvy.domain;

import java.util.UUID;

public record Claim(UUID participantId, UUID itemId) {
    //equals override generates this.itemId.equals(other.itemId) && this.participantId.equals(other.participantId)
}
