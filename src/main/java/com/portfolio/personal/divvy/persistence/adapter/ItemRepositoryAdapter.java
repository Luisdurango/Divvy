package com.portfolio.personal.divvy.persistence.adapter;

import com.portfolio.personal.divvy.domain.Item;
import com.portfolio.personal.divvy.persistence.entity.ItemEntity;
import com.portfolio.personal.divvy.persistence.mapper.ItemMapper;
import com.portfolio.personal.divvy.persistence.repository.ItemJpaRepository;
import com.portfolio.personal.divvy.service.port.ItemRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ItemRepositoryAdapter implements ItemRepository {

    public ItemRepositoryAdapter(ItemJpaRepository itemJpaRepository, ItemMapper itemMapper){

        this.itemJpaRepository = itemJpaRepository;
        this.itemMapper = itemMapper;
    }



    private final ItemJpaRepository itemJpaRepository;
    private final ItemMapper itemMapper;


    @Override
    public List<Item> saveAll(List<Item> items) {
        List<ItemEntity>entityItems = itemJpaRepository.saveAll(items.stream().map(itemMapper::toEntity).toList());
        return entityItems.stream().map(itemMapper::toDomain).toList();
    }

    @Override
    public Item save(Item item) {
        return itemMapper.toDomain(itemJpaRepository.save(itemMapper.toEntity(item)));
    }

    @Override
    public Optional<Item> findById(UUID itemId) {
        return (itemJpaRepository.findById(itemId)).map(itemMapper::toDomain);
    }

    @Override
    public void deleteById(UUID itemId) {
    itemJpaRepository.deleteById(itemId);
    }

    @Override
    public List<Item> findBySessionId(UUID sessionId) {
        return (itemJpaRepository.findBySessionId(sessionId)).stream().map(itemMapper::toDomain).toList();
    }
}
