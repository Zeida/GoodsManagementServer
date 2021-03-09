package com.serverbitboxer2.serverbitboxer2.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long usercode;
    private String username;

    @Override
    public String toString() {
        return "User{" +
                "usercode=" + usercode +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    private String password;

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
}
