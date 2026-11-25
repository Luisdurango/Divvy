package com.portfolio.personal.divvy.service;

import com.portfolio.personal.divvy.domain.Claim;
import com.portfolio.personal.divvy.domain.Item;
import com.portfolio.personal.divvy.domain.Participant;
import com.portfolio.personal.divvy.domain.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class BillSplitCalculatorTest {

    @Test
    void getClaimantsForTest() {
        BillSplitCalculator calculator = new BillSplitCalculator();
        //Arrange
        UUID itemId1 = UUID.randomUUID();
        UUID itemId2 = UUID.randomUUID();
        UUID participantId1 = UUID.randomUUID();
        UUID participantId2 = UUID.randomUUID();

        List<Claim> claims = List.of(
                new Claim(participantId1, itemId1),
                new Claim(participantId2, itemId1),
                new Claim(participantId2, itemId2));

        //Act
        List<UUID> resultForGetClaimantsFor = calculator.getClaimantsFor(itemId1, claims);

        //Assert
      /*   We are expecting that the calculator getClaimantsFor(itemId1,claims) result is participant 1 and 2 */


        Assertions.assertEquals(List.of(participantId1, participantId2), resultForGetClaimantsFor);
    }

    @Test
    void getItemShareForParticipantTest() {
        BillSplitCalculator calculator = new BillSplitCalculator();

        //Arrange
        Session session = Session.startNew(UUID.randomUUID(), "Join Test", "La Causa", BigDecimal.valueOf(0.1), BigDecimal.valueOf(0.08), false, BigDecimal.valueOf(0.19));
        Item item1 = new Item(UUID.randomUUID(), session.getId(), "Causa Peruana", BigDecimal.valueOf(34000), 1, 0.8, false, 1);
        UUID participantId1 = UUID.randomUUID();
        UUID participantId2 = UUID.randomUUID();
        List<Claim> allClaims = List.of(
                new Claim(participantId1, item1.getId()),
                new Claim(participantId2, item1.getId())
        );

        //Act
        BigDecimal resultForGetItemShareForParticipant = calculator.getItemShareForParticipant(item1, allClaims, participantId1);

        //Assert
        Assertions.assertEquals(BigDecimal.valueOf(17000).setScale(2), resultForGetItemShareForParticipant);
    }

    @Test
    void getSubtotalForParticipantTest() {
        BillSplitCalculator calculator = new BillSplitCalculator();

        //Arrange
        Session session = Session.startNew(UUID.randomUUID(), "Join Test", "La Causa", BigDecimal.valueOf(0.1), BigDecimal.valueOf(0.08), false, BigDecimal.valueOf(0.19));
        Item item1 = new Item(UUID.randomUUID(), session.getId(), "Causa Peruana", BigDecimal.valueOf(34000), 1, 0.8, false, 1);
        Item item2 = new Item(UUID.randomUUID(), session.getId(), "Pulpo", BigDecimal.valueOf(100000), 1, 0.8, false, 2);
        Item item3 = new Item(UUID.randomUUID(), session.getId(), "Postre", BigDecimal.valueOf(24000), 2, 0.8, false, 1);
        UUID participantId1 = UUID.randomUUID();
        UUID participantId2 = UUID.randomUUID();
        List<Claim> allClaims = List.of(
                new Claim(participantId1, item1.getId()),
                new Claim(participantId2, item2.getId()),
                new Claim(participantId2, item3.getId()),
                new Claim(participantId1, item3.getId())
        );
        List<Item> allItems = List.of(item1, item2, item3);

        //Act
        BigDecimal resultForGetSubtotalForParticipantTest = calculator.getSubtotalForParticipant(allItems, allClaims, participantId1);

        //Assert
        Assertions.assertEquals(BigDecimal.valueOf(58000).setScale(2), resultForGetSubtotalForParticipantTest);
    }

    @Test
    void getTotalWithImpoAndTaxTest() {
        BillSplitCalculator calculator = new BillSplitCalculator();

        //Arrange
        Session session = Session.startNew(UUID.randomUUID(), "Join Test", "La Causa", BigDecimal.valueOf(0.1), BigDecimal.valueOf(0.08), false, BigDecimal.valueOf(0.19));
        Item item1 = new Item(UUID.randomUUID(), session.getId(), "Causa Peruana", BigDecimal.valueOf(34000), 1, 0.8, false, 1);
        Item item2 = new Item(UUID.randomUUID(), session.getId(), "Pulpo", BigDecimal.valueOf(100000), 1, 0.8, false, 2);
        Item item3 = new Item(UUID.randomUUID(), session.getId(), "Postre", BigDecimal.valueOf(24000), 2, 0.8, false, 1);

        Participant participant1 = new Participant(UUID.randomUUID(), session.getId(), "Luis", true, true);
        Participant participant2 = new Participant(UUID.randomUUID(), session.getId(), "Oriana", true, false);

        List<Claim> allClaims = List.of(
                new Claim(participant1.getId(), item1.getId()),
                new Claim(participant2.getId(), item2.getId()),
                new Claim(participant2.getId(), item3.getId()),
                new Claim(participant1.getId(), item3.getId())
        );
        List<Item> allItems = List.of(item1, item2, item3);

        //Act
        BigDecimal resultForGetTotalWithImpoAndTaxTest = calculator.getTotalWithImpoAndTax(allItems, allClaims, participant1, session);

        //Assert
        Assertions.assertEquals(0, BigDecimal.valueOf(68440).compareTo(resultForGetTotalWithImpoAndTaxTest));
    }
}
