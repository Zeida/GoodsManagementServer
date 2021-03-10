package com.serverbitboxer2.serverbitboxer2.services;

import com.serverbitboxer2.serverbitboxer2.dto.ItemDTO;

import java.util.List;

public interface IItemService {


    //public List<ItemDTO> getItemBySupplier(String supplierName);
    //public List<ItemDTO> getItemByCreator(String creatorName);
    //public List<ItemDTO> getItemByPrice(double price);
    //public List<ItemDTO> getItemByState(ItemStateEnum state);
    //public List<ItemDTO> getItemByCreationdate(Date creationdate);
    //CRUD
    List<ItemDTO> findAll();
    ItemDTO getItemByCode(Long itemCode) ;
    void createItem(ItemDTO item);
    void deleteItem(Long itemCode);
    boolean updateItem(Long itemCode, ItemDTO itemDTO);





}
