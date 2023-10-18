package com.example.travelappoctober2023.models;

import org.bson.types.ObjectId;

import java.util.Date;

public class UserM {
    private ObjectId user_id;
    private String user_name;
    private String first_name;
    private String last_name;
    private Date birthd;
    private String email;
    private String phone;

    public UserM(ObjectId userId, String userName, String firstName, String lastName, Date birthd, String email, String phone) {
        this.user_id = userId;
        this.user_name = userName;
        this.first_name = firstName;
        this.last_name = lastName;
        this.birthd = birthd;
        this.email = email;
        this.phone = phone;
    }
}
