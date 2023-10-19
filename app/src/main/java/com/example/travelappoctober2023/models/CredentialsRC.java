package com.example.travelappoctober2023.models;

public class CredentialsRC {
    private String email;
    private String pwd;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public CredentialsRC(String email, String pwd) {
        this.email = email;
        this.pwd = pwd;
    }
}
