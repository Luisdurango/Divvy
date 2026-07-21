package com.portfolio.personal.divvy.service;

import com.portfolio.personal.divvy.domain.Claim;

import java.util.List;
import java.util.UUID;

public class BillSplitCalculator {

    public List<UUID> getClaimantsFor(UUID itemId, List<Claim> allClaims) {

        //look/match for the item id on all claims that im looking for on the getClaimantsFor method
        return allClaims
                .stream()
                .filter(c -> c.itemId().
                        equals(itemId))
                .map(Claim::participantId).toList();
        //I've got a list of UUID's that match the given itemId as parameter to the list of allClaims, which means I have the items that have already been claimed.
    }
}
