package com.serverbitboxer2.serverbitboxer2.services;

import com.serverbitboxer2.serverbitboxer2.assembler.ItemAssembler;
import com.serverbitboxer2.serverbitboxer2.assembler.PriceReductionAssembler;
import com.serverbitboxer2.serverbitboxer2.assembler.SupplierAssembler;
import com.serverbitboxer2.serverbitboxer2.assembler.UserAssembler;
import com.serverbitboxer2.serverbitboxer2.dao.ItemDAO;
import com.serverbitboxer2.serverbitboxer2.dao.SupplierDAO;
import com.serverbitboxer2.serverbitboxer2.dao.UserDAO;
import com.serverbitboxer2.serverbitboxer2.dto.ItemDTO;
import com.serverbitboxer2.serverbitboxer2.dto.PriceReductionDTO;
import com.serverbitboxer2.serverbitboxer2.dto.SupplierDTO;
import com.serverbitboxer2.serverbitboxer2.entities.Item;
import com.serverbitboxer2.serverbitboxer2.entities.PriceReduction;
import com.serverbitboxer2.serverbitboxer2.entities.Supplier;
import com.serverbitboxer2.serverbitboxer2.entities.User;
import com.serverbitboxer2.serverbitboxer2.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemService implements IItemService {
    @PersistenceContext
    private EntityManager entityManager;

    //Repositories
    @Autowired
    private ItemDAO itemDAO;
    @Autowired
    private SupplierDAO supplierDAO;
    @Autowired
    private UserDAO userDAO;

    //Assemblers
    private ItemAssembler itemAssembler = new ItemAssembler();
    private SupplierAssembler supplierAssembler = new SupplierAssembler();
    private PriceReductionAssembler priceReductionAssembler = new PriceReductionAssembler();
    private UserAssembler userAssembler = new UserAssembler();

    @Override
    public List<ItemDTO> findAll() {
        List<ItemDTO> itemsDTO = new ArrayList<>();
        for (Item item : itemDAO.findAll()) itemsDTO.add(itemAssembler.entity2DTO(item));
        return itemsDTO;
    }

    @Async
    @Override
    public void createItem(ItemDTO item) {

        itemDAO.save(itemAssembler.DTO2Entity(item));
    }

    @Override
    public void deleteItem(String itemcode) {
        //Optional<Item> item = itemDAO.findByItemcode(itemcode);
        itemDAO.deleteByItemcode(itemcode);
    }

    @Override
    public ResponseEntity<ItemDTO> updateItem(String itemCode, ItemDTO itemDTO) {
        if (itemDAO.findByItemcode(itemCode).isPresent()){
            Item item = itemDAO.findByItemcode(itemCode).get();
            item.setItemcode(itemDTO.getItemcode());
            item.setDescription(itemDTO.getDescription());
            item.setPrice(itemDTO.getPrice());
            item.setState(itemDTO.getState());
            item.setCreationdate(itemDTO.getCreationdate());
            List<PriceReduction> reductions = new ArrayList<>();
            List<Supplier> suppliers = new ArrayList<>();
            for (SupplierDTO supplierDTO : itemDTO.getSuppliers())
                suppliers.add(supplierAssembler.DTO2Entity(supplierDTO));
            item.setSuppliers(suppliers);
            for (PriceReductionDTO priceReductionrDTO : itemDTO.getReductions())
                reductions.add(priceReductionAssembler.DTO2Entity(priceReductionrDTO));
            item.setReductions(reductions);
            Optional<User> user = userDAO.findByUsercode(item.getCreator().getUsercode());
            if (!itemDTO.getCreator().equals(user.get())) user.get().addItem(item);
            itemDAO.save(item);
            return ResponseEntity.ok().body(itemAssembler.entity2DTO(item));

        } else throw new ResourceNotFoundException("The item with the code: " + itemCode + "could not be updated");
    }

    @Override
    public ItemDTO findByItemcode(String itemCode) {
        Optional<Item> item = itemDAO.findByItemcode(itemCode);
        if (item.isPresent()) {
            return (itemAssembler.entity2DTO(item.get()));

        } else throw new ResourceNotFoundException("The item with the code: " + itemCode + "does not exist");
    }


}
