package com.serverbitboxer2.serverbitboxer2.services;

import com.serverbitboxer2.serverbitboxer2.dto.ItemDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IItemService {
    List<ItemDTO> findAll();

    ItemDTO findByItemcode(String itemCode);

    void createItem(ItemDTO item);

    void deleteItem(String itemCode);

    ResponseEntity<ItemDTO> updateItem(String itemCode, ItemDTO itemDTO);

}
