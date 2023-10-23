package com.travelappoctober2023.models;

import com.travelappoctober2023.utils.DbSession;
import com.travelappoctober2023.utils.HashFunction;

import java.sql.Connection;

//table name in db = usr
public class UserM extends DbSession{
    public Integer user_id;
    public String user_name;
    public String email;
    public String phone;
    public String hashed_pwd;

    public UserM(String userName, String email, String phone, String pwd) {
        Connection conn = null;
        try{
            conn = DbSession.connect();
            String sql = "INSERT INTO usr(user_name, email, about_me, phone, hashed_pwd, last_loca) VALUES(?,?,?,?,?,?)";
            String _hash = HashFunction.sha256Hash(pwd);
            java.sql.PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userName);
            pstmt.setString(2, email);
            pstmt.setString(3, "");
            pstmt.setString(3, phone);
            pstmt.setString(4, _hash);
            pstmt.setString(5, "NULL");
            pstmt.executeUpdate();
            System.out.println("User created successfully");
            //recupere l'ID du user dans la variable _id
            sql = "SELECT usr_id FROM usr WHERE user_name = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userName);
            java.sql.ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                this.user_id = rs.getInt("usr_id");
            }
            //ferme la connection
            DbSession.closeConnection(conn);
            this.user_name = userName;
            this.email = email;
            this.phone = phone;
            this.hashed_pwd = _hash;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
