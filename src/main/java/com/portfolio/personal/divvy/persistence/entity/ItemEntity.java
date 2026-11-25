package com.portfolio.personal.divvy.persistence.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.UUID;

    @Entity
    @Table(name = "items")
    public class ItemEntity {

        public ItemEntity(){}

        @Id
        private UUID id;

        @Column(name = "session_id")
        private UUID sessionId;

        @Column(name = "item_name")
        private String itemName;

        @Column(name = "price")
        private BigDecimal price;

        @Column(name = "quantity")
        private int quantity;

        @Column(name = "confidence")
        private double confidence;

        @Column(name = "flagged")
        private boolean flagged;

        @Column(name = "position")
        private int position;

        public UUID getId(){return this.id;}
        public void setId(UUID id){this.id = id;}

        public UUID getSessionId() {return this.sessionId;}
        public void setSessionId(UUID sessionId) {this.sessionId = sessionId;}

        public String getItemName(){return this.itemName;}
        public void setItemName(String itemName){this.itemName = itemName;}

        public BigDecimal getPrice(){return this.price;}
        public void setPrice(BigDecimal price){this.price = price;}

        public int getQuantity(){return this.quantity;}
        public void setQuantity(int quantity){this.quantity = quantity;}

        public double getConfidence() {return this.confidence;}
        public void setConfidence(double confidence) {this.confidence = confidence;}

        public boolean isFlagged() {return this.flagged;}
        public void setFlagged(boolean flagged) {this.flagged = flagged;}

        public int getPosition() {return this.position;}
        public void setPosition(int position) {this.position = position;}



    }
