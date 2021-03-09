package com.serverbitboxer2.serverbitboxer2.entities;

import javax.persistence.*;
import java.io.Serializable;

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
    private Long suppliercode;
    private String name;
    private String country;

    public Long getSuppliercode() {
        return suppliercode;
    }

    public void setSuppliercode(Long suppliercode) {
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
//set de items


}
