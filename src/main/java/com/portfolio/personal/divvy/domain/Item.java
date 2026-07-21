package com.portfolio.personal.divvy.domain;

import java.math.BigDecimal;
import java.util.UUID;

public class Item {

    public Item(UUID id, UUID sessionId,String itemName, BigDecimal price,int quantity,double confidence,boolean flagged, int position ) {

        if(quantity <= 0) throw new IllegalArgumentException("Quantity must be greater than zero");
        if(price.compareTo(BigDecimal.ZERO) < 0) throw new IllegalArgumentException("Price must be greater or equal than zero");
        this.id = id;
        this.sessionId = sessionId;
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
        this.confidence = confidence;
        this.flagged = flagged;
        this.position = position;
    }

    private final UUID id;
    private final UUID sessionId;
    private  String itemName;
    private BigDecimal price;
    private int quantity;
    private final double confidence;
    private boolean flagged;
    private int position;

    public UUID getId() {return this.id;}
    public UUID getSessionId() {return this.sessionId;}
    public String getItemName() {return this.itemName;}
    public BigDecimal getPrice() {return this.price;}
    public int getQuantity() {return this.quantity;}
    public double getConfidence() {return this.confidence;}
    public boolean isFlagged() {return this.flagged;}
    public int getPosition() {return this.position;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) {return false;}
        Item item = (Item) o;
        return this.id.equals(item.id);
    }
    @Override
    public int hashCode() {return this.id.hashCode();}
}
