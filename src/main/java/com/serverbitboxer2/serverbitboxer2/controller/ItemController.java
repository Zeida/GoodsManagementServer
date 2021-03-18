package com.serverbitboxer2.serverbitboxer2.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.serverbitboxer2.serverbitboxer2.dto.ItemDTO;
import com.serverbitboxer2.serverbitboxer2.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:8081/")
@RestController
@RequestMapping("/api")
public class ItemController {
    @Autowired
    private ItemService itemService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/items")
    public List<ItemDTO> findAll() {
        return itemService.findAll();
    }

    @GetMapping("/item/{itemcode}")
    public ItemDTO getItemByCode(@PathVariable(name = "itemcode") String itemcode) {
        ItemDTO itemDTO = itemService.findByItemcode(itemcode);
        if (itemDTO == null) {
            throw new RuntimeException("The Item with code: " + itemcode + " does not exist");
        }
        return itemDTO;
    }

    @PostMapping(value = "/item/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void createItem(@RequestBody String item) throws JsonProcessingException {
        ItemDTO itemDTO = objectMapper.readValue(item, ItemDTO.class);
        itemService.createItem(itemDTO);
    }

    @PutMapping("/item/{itemcode}/update")

    public ResponseEntity<ItemDTO> updateItem(@PathVariable(name = "itemcode") String itemcode, @RequestBody String item) throws JsonProcessingException {
        ItemDTO itemDTO = objectMapper.readValue(item, ItemDTO.class);
        return itemService.updateItem(itemcode, itemDTO);
    }

    @DeleteMapping("/item/{itemcode}/delete")
    public void deleteItem(@PathVariable(name = "itemcode") String itemcode) {
        ItemDTO itemDTO = itemService.findByItemcode(itemcode);
        if (itemDTO == null) {
            throw new RuntimeException("The Item with code: " + itemcode + " does not exist");
        } else {
            itemService.deleteItem(itemcode);
        }

    }
}
