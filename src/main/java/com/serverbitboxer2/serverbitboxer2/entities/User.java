package com.serverbitboxer2.serverbitboxer2.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.IndexColumn;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer userid;
    private Long usercode;
    private String username;
    @JsonIgnore
    private String password;
    private String name;
    private String surname;
    private String email;
    private String address;
    private String phone;

    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "creator")
    private List<Item> createditems;
    public User(){}
    public User(Integer userid, Long usercode, String username, String password, String name, String surname, String email, String address, String phone, List<Item> createditems) {
        this.userid = userid;
        this.usercode = usercode;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.createditems = createditems;
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

    public Long getUsercode() {
        return usercode;
    }

    public void setUsercode(Long usercode) {
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
}
