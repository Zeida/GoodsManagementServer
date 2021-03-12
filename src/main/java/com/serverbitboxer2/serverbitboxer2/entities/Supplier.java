package com.serverbitboxer2.serverbitboxer2.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "supplier")
public class Supplier implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer supplierid;
    @Column(unique = true)
    private Long suppliercode;
    private String name;
    private String country;
    @ManyToMany(mappedBy = "suppliers")
    private List<Item> itemssupplied;

    public Supplier() {
    }

    public Supplier(Integer supplierid, Long suppliercode, String name, String country, List<Item> itemssupplied) {
        this.supplierid = supplierid;
        this.suppliercode = suppliercode;
        this.name = name;
        this.country = country;
        this.itemssupplied = itemssupplied;
    }

    public void setSuppliercode(Long suppliercode) {
        this.suppliercode = suppliercode;
    }

    public Long getSuppliercode() {
        return suppliercode;
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

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierid=" + supplierid +
                ", suppliercode=" + suppliercode +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", itemssupplied=" + itemssupplied +
                '}';
    }
}
