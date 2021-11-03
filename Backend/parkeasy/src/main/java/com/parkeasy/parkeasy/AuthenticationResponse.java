package com.parkeasy.parkeasy;

public class AuthenticationResponse {

    private String response;

    public AuthenticationResponse() {
        // Default constructor
    }

    public AuthenticationResponse(String response) {
        // 1 Argument constructor
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
