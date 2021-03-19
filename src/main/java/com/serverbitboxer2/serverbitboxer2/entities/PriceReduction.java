package com.serverbitboxer2.serverbitboxer2.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
