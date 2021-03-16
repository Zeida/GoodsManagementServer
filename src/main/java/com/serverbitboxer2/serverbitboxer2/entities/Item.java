package com.serverbitboxer2.serverbitboxer2.entities;

import com.serverbitboxer2.serverbitboxer2.globaldata.ItemStateEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "item")
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemid;
    @Column(unique = true)
    private String itemcode;
    private String description;
    private double price;
    @Enumerated(EnumType.STRING)
    private ItemStateEnum state;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "itemssupplied")
    private List<Supplier> suppliers;
    private Date creationdate;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "userid")

    //@ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name="userid" )
    private User creator;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "reducedpriceitems")
    private List<PriceReduction> reductions;

    public Item() {
    }

    public Item(Long itemid, String itemcode, String description, double price, ItemStateEnum state, List<Supplier> suppliers, Date creationdate, User creator, List<PriceReduction> reductions) {
        this.itemid = itemid;
        this.itemcode = itemcode;
        this.description = description;
        this.price = price;
        this.state = state;
        this.suppliers = suppliers;
        this.creationdate = creationdate;
        this.creator = creator;
        this.reductions = reductions;
    }

    public Long getItemid() {
        return itemid;
    }

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

    public String getItemcode() {
        return itemcode;
    }

    public void setItemcode(String itemcode) {
        this.itemcode = itemcode;
    }

    public List<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<Supplier> suppliers) {
        this.suppliers = suppliers;
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

    public void setPrice(double price) {
        this.price = price;
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
}
