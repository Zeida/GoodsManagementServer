package com.serverbitboxer2.serverbitboxer2.dto;
import java.util.List;
public class UserDTO {
    private Integer userid;
    private Long usercode;
    private String username;
    private String password;
    private String name;
    private String surname;
    private String email;
    private String address;
    private String phone;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    private List<ItemDTO> createditems;

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

    public List<ItemDTO> getCreateditems() {
        return createditems;
    }

    public void setCreateditems(List<ItemDTO> createditems) {
        this.createditems = createditems;
    }


}
