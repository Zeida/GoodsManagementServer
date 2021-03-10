package com.serverbitboxer2.serverbitboxer2.dto;

import com.serverbitboxer2.serverbitboxer2.entities.Item;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class PriceReductionDTO implements Serializable {
    private Integer pricereductionid;
    private Long pricereductioncode;
    private double reducedprice;
    private Date startdate;
    private Date enddate;
    private List<ItemDTO> reducedpriceitems;

    public Integer getPricereductionid() {
        return pricereductionid;
    }

    public void setPricereductionid(Integer pricereductionid) {
        this.pricereductionid = pricereductionid;
    }

    public Long getPricereductioncode() {
        return pricereductioncode;
    }

    public void setPricereductioncode(Long pricereductioncode) {
        this.pricereductioncode = pricereductioncode;
    }

    public double getReducedprice() {
        return reducedprice;
    }

    public void setReducedprice(double reducedprice) {
        this.reducedprice = reducedprice;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public List<ItemDTO> getReducedpriceitems() {
        return reducedpriceitems;
    }

    public void setReducedpriceitems(List<ItemDTO> reducedpriceitems) {
        this.reducedpriceitems = reducedpriceitems;
    }
}
