package com.example.travelappoctober2023.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashFunction {

    public static String sha256Hash(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes());

            // Convert the byte array to a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            // Handle the exception or rethrow it as needed
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String input = "HelloWorld";
        String hashedValue = sha256Hash(input);
        System.out.println("Hashed Value: " + hashedValue);
    }
}
