package com.serverbitboxer2.serverbitboxer2.dao;

import com.serverbitboxer2.serverbitboxer2.entities.Item;
import com.serverbitboxer2.serverbitboxer2.entities.Supplier;
import com.serverbitboxer2.serverbitboxer2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemDAO extends JpaRepository<Item, Long> {
    Item findByItemid(Integer itemcode);
    Item getOneByItemcode(int code);
    List<Item> findBySupplier(Supplier supplier);
    List<Item> findSupplierOrderByPriceAsc(Supplier supplier);
    Item getOneByItemid(int itemid);
    void deleteByItemid(int itemid);
    void deleteByItemcode(int itemcode);
    List<Item> findByCreator(User creator);
}
