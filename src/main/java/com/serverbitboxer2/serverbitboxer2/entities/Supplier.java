package com.serverbitboxer2.serverbitboxer2.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="supplier")
public class Supplier implements Serializable {

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "Supplier{" +
                "suppliercode=" + suppliercode +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer supplierid;
    private Integer suppliercode;
    private String name;
    private String country;

    @ManyToMany(cascade = {CascadeType.ALL},mappedBy="suppliers")
    private List<Item> itemssupplied;

    public Integer getSuppliercode() {
        return suppliercode;
    }

    public void setSuppliercode(Integer suppliercode) {
        this.suppliercode = suppliercode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Item> getItemssupplied() {
        return itemssupplied;
    }

    public void setItemssupplied(List<Item> itemssupplied) {
        this.itemssupplied = itemssupplied;
    }


}
