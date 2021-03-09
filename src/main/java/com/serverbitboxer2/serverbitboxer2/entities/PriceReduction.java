package com.serverbitboxer2.serverbitboxer2.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="pricereduction")
public class PriceReduction implements Serializable {
    @Override
    public String toString() {
        return "PriceReduction{" +
                "pricereductioncode=" + pricereductioncode +
                ", reducedprice=" + reducedprice +
                ", startdate=" + startdate +
                ", enddate=" + enddate +
                '}';
    }

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long pricereductioncode;
    private double reducedprice;
    private Date startdate;
    private Date enddate;

    @ManyToMany(cascade = {CascadeType.ALL},mappedBy="reductions")
    private List<Item> reducedpriceitems;

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

}
