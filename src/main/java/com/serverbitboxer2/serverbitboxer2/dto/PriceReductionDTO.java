package com.serverbitboxer2.serverbitboxer2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class PriceReductionDTO implements Serializable {
    @JsonProperty("pricereductionid")
    private Long pricereductionid;
    @JsonProperty("pricereductioncode")
    private String pricereductioncode;
    @JsonProperty("reducedprice")
    private double reducedprice;
    @JsonProperty("startdate")
    private Date startdate;
    @JsonProperty("enddate")
    private Date enddate;
    @JsonProperty("reducedpriceitems")
    private List<ItemDTO> reducedpriceitems;
}
