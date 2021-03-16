package com.serverbitboxer2.serverbitboxer2.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pricereduction")
public class PriceReduction implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pricereductionid;
    @Column(unique = true)
    private String pricereductioncode;
    private double reducedprice;
    private Date startdate;
    private Date enddate;
    @ManyToMany(mappedBy = "reductions")
    private List<Item> reducedpriceitems;

    public PriceReduction() {
    }

    public PriceReduction(Long pricereductionid, String pricereductioncode, double reducedprice, Date startdate, Date enddate, List<Item> reducedpriceitems) {
        this.pricereductionid = pricereductionid;
        this.pricereductioncode = pricereductioncode;
        this.reducedprice = reducedprice;
        this.startdate = startdate;
        this.enddate = enddate;
        this.reducedpriceitems = reducedpriceitems;
    }

    public String getPricereductioncode() {
        return pricereductioncode;
    }

    public void setPricereductioncode(String pricereductioncode) {
        this.pricereductioncode = pricereductioncode;
    }

    public List<Item> getReducedpriceitems() {
        return reducedpriceitems;
    }

    public void setReducedpriceitems(List<Item> reducedpriceitems) {
        this.reducedpriceitems = reducedpriceitems;
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

    @Override
    public String toString() {
        return "PriceReduction{" +
                "pricereductionid=" + pricereductionid +
                ", pricereductioncode=" + pricereductioncode +
                ", reducedprice=" + reducedprice +
                ", startdate=" + startdate +
                ", enddate=" + enddate +
                ", reducedpriceitems=" + reducedpriceitems +
                '}';
    }
}
