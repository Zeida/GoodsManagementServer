package com.serverbitboxer2.serverbitboxer2.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.serverbitboxer2.serverbitboxer2.globaldata.ItemStateEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO implements Serializable {

    @JsonProperty("itemid")
    private Integer itemid;
    @JsonProperty("itemcode")
    private Long itemcode;
    @JsonProperty("description")
    private String description;
    @JsonProperty("price")
    private double price;
    @JsonProperty("state")
    private ItemStateEnum state;
    @JsonProperty("suppliers")
    private List<SupplierDTO> suppliers;
    @JsonProperty("creationdate")
    private Date creationdate;
    @JsonProperty("creator")
    private UserDTO creator;
    @JsonProperty("reductions")
    private List<PriceReductionDTO> reductions;

}
