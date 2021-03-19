package com.serverbitboxer2.serverbitboxer2.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.serverbitboxer2.serverbitboxer2.globaldata.UserRoleEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    //long los id, generador de secuencia
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userid;
    @Column(unique = true)
    private String usercode;
    @Column(unique = true, nullable = false)
    private String username;
    @JsonIgnore
    @Column(nullable = false)
    private String password;
    private String token;
    private String name;
    private String surname;
    //@Column(unique = true, nullable = false)
    private String email;
    private String address;
    private String phone;
    @OneToMany(targetEntity = Item.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Item> createditems;
    private UserRoleEnum rol;

    public User(String username, String password) { }

    public void addItem(Item item) {
        if (createditems == null) {
            createditems = new ArrayList<>();
        }
        createditems.add(item);
        item.setCreator(this);
    }

}
