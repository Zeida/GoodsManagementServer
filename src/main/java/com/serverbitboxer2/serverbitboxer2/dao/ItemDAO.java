package com.serverbitboxer2.serverbitboxer2.dao;

import com.serverbitboxer2.serverbitboxer2.entities.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemDAO extends CrudRepository<Item, Long> {

}
