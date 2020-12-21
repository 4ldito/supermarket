package com.blenth.supermarket.domain.dto;

public class AutheticationResponse {
    private String jwt;

    public AutheticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
