package com.serverbitboxer2.serverbitboxer2.entities;

import com.serverbitboxer2.serverbitboxer2.globaldata.ItemStateEnum;
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
@Table(name = "item")
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemid;
    @Column(unique = true)
    private String itemcode;
    private String description;
    private double price;
    @Enumerated(EnumType.STRING)
    private ItemStateEnum state;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "itemssupplied")
    private List<Supplier> suppliers;
    private Date creationdate;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "userid")

    //@ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name="userid" )
    private User creator;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "reducedpriceitems")
    private List<PriceReduction> reductions;

    private String DiscontinuedReason;

}
