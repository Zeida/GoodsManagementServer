package com.serverbitboxer2.serverbitboxer2.entities;

import com.serverbitboxer2.serverbitboxer2.globaldata.ItemStateEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="item")
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer itemid;
    private Integer itemcode;
    private String description;
    private double price;
    @Enumerated(EnumType.STRING)
    private ItemStateEnum state;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="item", joinColumns={@JoinColumn(name="itemcode")}, inverseJoinColumns={@JoinColumn(name="suppliercode")})
    private List<Supplier> suppliers;
    private Date creationdate;

    @ManyToOne
    @JoinColumn(name="creator", nullable = false)
    private User creator;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="item", joinColumns={@JoinColumn(name="itemcode")}, inverseJoinColumns={@JoinColumn(name="pricereductioncode")})
    private List<PriceReduction> reductions;

    @Override
    public String toString() {
        return "Item{" +
                "itemcode=" + itemcode +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", state=" + state +
                ", supplier=" + suppliers +
                ", pricereduction=" + reductions +
                ", creationdate=" + creationdate +
                ", creator=" + creator +
                '}';
    }

    public Integer getItemcode() {
        return itemcode;
    }

    public void setItemcode(Integer itemcode) {
        this.itemcode = itemcode;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Supplier> getSuppliers() {
        return suppliers;
    }

    public List<PriceReduction> getReductions() {
        return reductions;
    }

    public void setReductions(List<PriceReduction> reductions) {
        this.reductions = reductions;
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

    public void setSuppliers(List<Supplier> suppliers) {
        this.suppliers = suppliers;
    }
}
