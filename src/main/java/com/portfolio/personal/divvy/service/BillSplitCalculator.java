package com.portfolio.personal.divvy.service;

import com.portfolio.personal.divvy.domain.Claim;
import com.portfolio.personal.divvy.domain.Item;
import com.portfolio.personal.divvy.domain.Participant;
import com.portfolio.personal.divvy.domain.Session;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.UUID;

public class BillSplitCalculator {

    public List<UUID> getClaimantsFor(UUID itemId, List<Claim> allClaims) {
        //look/match for the item id on all claims that im looking for on the getClaimantsFor method
        //We have the participantId's that has claimed the passed itemId into the method
        return allClaims
                .stream()
                .filter(c -> c.itemId().equals(itemId))
                .map(Claim::participantId)
                .toList();
    }

    public BigDecimal getItemShareForParticipant(Item item, List<Claim> allClaims, UUID participantId) {
        //Find all claimants for that particular item
        List<UUID> claimants = getClaimantsFor(item.getId(), allClaims);
        //Split based on the number of claimants, the total price * quantity of the item
        return (claimants.contains(participantId))
                ? item.getTotalPrice().divide(BigDecimal.valueOf(claimants.size()), 2, RoundingMode.HALF_UP)
                : BigDecimal.ZERO;
    }

    public BigDecimal getSubtotalForParticipant(List<Item> allItems, List<Claim> allClaims, UUID participantId) {
        //Lambda expression can capture variables from its surrounding scope, the method variables, a feature called "capturing"
        return allItems.stream()
                .map(item -> getItemShareForParticipant(item, allClaims, participantId))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        /*BigDecimal total = BigDecimal.ZERO;
        for (Item item: allItems){
           total = total.add(getItemShareForParticipant(item,  allClaims, participantId));
        }
        return total;*/
    }

    public BigDecimal getTotalWithImpoAndTax(List<Item> allItems, List<Claim> allClaims, Participant participant, Session session) {
        final BigDecimal fixedTotalWithoutTaxImpo = getSubtotalForParticipant(allItems, allClaims, participant.getId());
        BigDecimal subTotal = fixedTotalWithoutTaxImpo;
        if (!session.isImpoconsumoIncludedInPrices()) {
            //Rates have to be in decimals eg 0.08 instead of 1.08
            subTotal = fixedTotalWithoutTaxImpo.add(fixedTotalWithoutTaxImpo.multiply(session.getImpoconsumoRate()));
        }

        if (participant.isOptTipIn()) {
            return subTotal.add(fixedTotalWithoutTaxImpo.multiply(session.getTipRate()));
        }
        return subTotal;
    }
}
