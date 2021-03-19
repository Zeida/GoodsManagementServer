package com.serverbitboxer2.serverbitboxer2.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "supplier")
public class Supplier implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supplierid;
    @Column(unique = true)
    private String suppliercode;
    private String name;
    private String country;
    @ManyToMany(mappedBy = "suppliers")
    private List<Item> itemssupplied;


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
