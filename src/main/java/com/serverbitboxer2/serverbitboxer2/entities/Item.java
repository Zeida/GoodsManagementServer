package com.serverbitboxer2.serverbitboxer2.entities;

import com.serverbitboxer2.serverbitboxer2.globaldata.ItemStateEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="item")
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long itemcode;
    private String description;
    private double price;
    @Enumerated(EnumType.STRING)
    private ItemStateEnum state;
    private Supplier supplier;
    private PriceReduction pricereduction;
    private Date creationdate;
    @ManyToOne
    @JoinColumn(name="creator", nullable = false)
    private User creator;


    public Long getItemcode() {
        return itemcode;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemcode=" + itemcode +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", state=" + state +
                ", supplier=" + supplier +
                ", pricereduction=" + pricereduction +
                ", creationdate=" + creationdate +
                ", creator=" + creator +
                '}';
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ItemStateEnum getState() {
        return state;
    }

    public void setState(ItemStateEnum state) {
        this.state = state;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public PriceReduction getPricereduction() {
        return pricereduction;
    }

    public void setPricereduction(PriceReduction pricereduction) {
        this.pricereduction = pricereduction;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }
}
