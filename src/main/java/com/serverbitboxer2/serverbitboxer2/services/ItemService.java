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
import com.serverbitboxer2.serverbitboxer2.dto.UserDTO;
import com.serverbitboxer2.serverbitboxer2.entities.Item;
import com.serverbitboxer2.serverbitboxer2.entities.PriceReduction;
import com.serverbitboxer2.serverbitboxer2.entities.Supplier;
import com.serverbitboxer2.serverbitboxer2.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemService implements IItemService{
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
        List<ItemDTO> itemsDAO = new ArrayList<>();
        for (Item item: itemDAO.findAll()) itemsDAO.add(itemAssembler.entity2DTO(item));
        return itemsDAO;
    }

    @Override
    public void createItem(ItemDTO item) {
        itemDAO.save(itemAssembler.DTO2Entity(item));
    }

    @Override
    public void deleteItem(Long itemCode) {
        itemDAO.deleteByItemcode(itemCode);
    }

    @Override
    public boolean updateItem(Long itemCode, ItemDTO itemDTO) {
        Optional<Item> item = itemDAO.findByItemcode(itemCode);
        List<Supplier> suppliers = new ArrayList<>(){};
        List<PriceReduction> priceReductions = new ArrayList<>();

        if(item.isPresent()){
            Item item1 = item.get();
            UserDTO user= userDAO.findByUsercode(item1.getCreator().getUsercode());
            item1.setItemcode(itemDTO.getItemcode());
            item1.setCreationdate(itemDTO.getCreationdate());
            item1.setDescription(itemDTO.getDescription());
            item1.setCreator(userAssembler.DTO2Entity(user));
            item1.setState(itemDTO.getState());
            item1.setPrice(itemDTO.getPrice());
            if (itemDTO.getSuppliers() != null){
                for (SupplierDTO supplierDTO : itemDTO.getSuppliers())
                    suppliers.add(supplierAssembler.DTO2Entity(supplierDTO));
                item1.setSuppliers(suppliers);
            }else item1.setReductions(new ArrayList<>());

            if (itemDTO.getReductions() != null){
                for (PriceReductionDTO priceReductionDTO : itemDTO.getReductions())
                    priceReductions.add(priceReductionAssembler.DTO2Entity(priceReductionDTO));
                item1.setReductions(priceReductions);
            }else item1.setReductions(new ArrayList<>());
            itemDAO.save(item1);
            return true;
        }else throw new ResourceNotFoundException("The item with the code: " + itemCode +"could not be updated" );
    }

    @Override
    public ItemDTO getItemByCode(Long itemCode) {
        Optional<Item> item = itemDAO.findByItemcode(itemCode);
        if(item.isPresent()){
            return (itemAssembler.entity2DTO(item.get()));

        }else throw new ResourceNotFoundException("The item with the code: " + itemCode + "does not exist");
    }


}
