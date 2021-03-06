package com.serverbitboxer2.serverbitboxer2.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.serverbitboxer2.serverbitboxer2.globaldata.UserRoleEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {
    @JsonProperty("userid")
    private Long userid;
    @JsonProperty("usercode")
    private String usercode;
    @JsonProperty("username")
    private String username;
    @JsonProperty("password")
    //@JsonIgnore
    private String password;
    @JsonProperty("token")
    //@JsonIgnore
    private String token;
    @JsonProperty("name")
    private String name;
    @JsonProperty("surname")
    private String surname;
    @JsonProperty("email")
    private String email;
    @JsonProperty("address")
    private String address;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("createditems")
    @JsonBackReference
    private List<ItemDTO> createditems;
    @JsonProperty("rol")
    private UserRoleEnum rol;
    public void setToken(String token) {
        this.token = token;
    }
}
