package com.serverbitboxer2.serverbitboxer2.entities;

import java.io.Serializable;

public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private String jwttoken;
    private String type = "Bearer";
    private String username;
    private String userpassword;
    public JwtResponse(String jwttoken, String username, String userpassword) {
        this.jwttoken = jwttoken;
        this.username = username;
        this.userpassword = userpassword;

    }

    public String getToken() {
        return this.jwttoken;
    }

    public void setAccessToken(String accessToken) {
        this.jwttoken = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }
}