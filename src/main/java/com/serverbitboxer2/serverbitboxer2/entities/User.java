package com.serverbitboxer2.serverbitboxer2.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(unique = true)
    private String username;
    @JsonIgnore
    private String password;
    private String token;
    private String name;
    private String surname;
    private String email;
    private String address;
    private String phone;
    //@OneToMany(mappedBy = "creator", cascade = CascadeType.ALL)
    @OneToMany(targetEntity = Item.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //@OneToMany (cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "creator")
    private List<Item> createditems;

    public void addItem(Item item) {
        if (createditems == null) {
            createditems = new ArrayList<>();
        }
        createditems.add(item);
        item.setCreator(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Item> getCreateditems() {
        return createditems;
    }

    public void setCreateditems(List<Item> createditems) {
        this.createditems = createditems;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
