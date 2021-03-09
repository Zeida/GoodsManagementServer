package com.serverbitboxer2.serverbitboxer2.dto;

import com.serverbitboxer2.serverbitboxer2.globaldata.ItemStateEnum;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ItemDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long itemcode;
    private String description;
    private double price;
    private ItemStateEnum state;
    private List<SupplierDTO> suppliers;
    private Date creationdate;
    private UserDTO creator;
    private List<PriceReductionDTO> reductions;

    public Long getItemcode() {
        return itemcode;
    }

    public void setItemcode(Long itemcode) {
        this.itemcode = itemcode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ItemStateEnum getState() {
        return state;
    }

    public void setState(ItemStateEnum state) {
        this.state = state;
    }

    public List<SupplierDTO> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<SupplierDTO> suppliers) {
        this.suppliers = suppliers;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public UserDTO getCreator() {
        return creator;
    }

    public void setCreator(UserDTO creator) {
        this.creator = creator;
    }

    public List<PriceReductionDTO> getReductions() {
        return reductions;
    }

    public void setReductions(List<PriceReductionDTO> reductions) {
        this.reductions = reductions;
    }
}
