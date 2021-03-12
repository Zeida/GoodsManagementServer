package com.serverbitboxer2.serverbitboxer2.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.serverbitboxer2.serverbitboxer2.entities.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SupplierDTO implements Serializable {

    @JsonProperty("supplierid")
    private Integer supplierid;
    @JsonProperty("suppliercode")
    private Long suppliercode;
    @JsonProperty("name")
    private String name;
    @JsonProperty("country")
    private String country;
    @JsonProperty("itemssupplied")
    @JsonBackReference
    private List<ItemDTO> itemssupplied;
}
