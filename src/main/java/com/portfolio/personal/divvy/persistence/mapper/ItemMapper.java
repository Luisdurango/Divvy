package com.portfolio.personal.divvy.persistence.mapper;

import com.portfolio.personal.divvy.domain.Item;
import com.portfolio.personal.divvy.persistence.entity.ItemEntity;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {

    public ItemEntity toEntity(Item domainItem) {

        ItemEntity entity = new ItemEntity();

        entity.setId(domainItem.getId());
        entity.setSessionId(domainItem.getSessionId());
        entity.setItemName(domainItem.getItemName());
        entity.setPrice(domainItem.getPrice());
        entity.setQuantity(domainItem.getQuantity());
        entity.setConfidence(domainItem.getConfidence());
        entity.setFlagged(domainItem.isFlagged());
        entity.setPosition(domainItem.getPosition());

        return entity;
    }

    public Item toDomain(ItemEntity entity) {

        return new Item(entity.getId(), entity.getSessionId(),
                entity.getItemName(), entity.getPrice(), entity.getQuantity(),
                entity.getConfidence(), entity.isFlagged(), entity.getPosition());
    }
}
