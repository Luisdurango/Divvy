package com.portfolio.personal.divvy.service.port;

import com.portfolio.personal.divvy.domain.Item;

import java.util.List;
import java.util.Optional;
import java.util.UUID;



public interface ItemRepository {

//List for saving the initial items on the receipt
//JPA calls also a saveAll, that why we chose that same name here
List<Item> saveAll(List<Item> items);
//Individual save for item detail changes needed for OCR inaccuracies
Item save(Item item);

Optional<Item> findById(UUID itemId);

//Nothing is returned when deleting something in db
void deleteById(UUID itemId);

List<Item> findBySessionId(UUID sessionId);




}
