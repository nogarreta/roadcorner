package com.example.travelappoctober2023.db_controllers;

import com.example.travelappoctober2023.utils.DbSession;

import org.json.JSONObject;

import java.sql.Connection;

public class MessageC extends DbSession {
    //connection to db
    Connection conn;
    public void insert() {
        conn = DbSession.connect();
        DbSession.closeConnection(conn);
    }

    public void update() {

    }

    public void delete() {

    }

    public JSONObject select() {
        return null;
    }
}
