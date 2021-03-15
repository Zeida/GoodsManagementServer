package com.serverbitboxer2.serverbitboxer2.dao;

import com.serverbitboxer2.serverbitboxer2.entities.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemDAO extends CrudRepository<Item, Long> {
    void deleteByItemcode(String itemCode);

    Optional<Item> findByItemcode(String itemCode);
}
