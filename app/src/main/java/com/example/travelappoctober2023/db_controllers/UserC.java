package com.example.travelappoctober2023.db_controllers;

import com.example.travelappoctober2023.utils.DbSession;
import com.example.travelappoctober2023.models.UserM;

import org.json.JSONObject;

import java.sql.Connection;

public class UserC extends DbSession {

    private Connection conn;
    public void insert_user(UserM user) {
        conn = DbSession.connect();
        //ajoute un user à la db postgresql
        String query = "";
        DbSession.closeConnection(conn);

    }

    public void update_user() {

    }

    public void delete_user() {

    }

    public JSONObject select_user() {
        return null;
    }

}
