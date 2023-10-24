package com.example.travelappoctober2023.utils;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class RequestCenter {

    public static final String graphqlEndpoint = "https://your-graphql-api-endpoint.com/graphql";
    public static JSONObject sendDestQuery(String qw) {
        try {

            // Create URL object
            // GraphQL query with variables
            String graphqlQuery = "query Continent($continent_code: ID!){\n" +
                    "    continent(code: $continent_code){\n" +
                    "        name\n" +
                    "        countries{\n" +
                    "            name\n" +
                    "            code\n" +
                    "        }\n" +
                    "    }\n" +
                    "}";

            // Variables for the GraphQL query
            Map<String, Object> variables = new HashMap<>();
            variables.put("continent_code", "AF");

            // Prepare the request body with the query and variables
            String requestBody = "{\"query\":\"" + graphqlQuery.replace("\"", "\\\"") + "\",\"variables\":" +
                    "{\"continent_code\":\"AF\"}}";

            // Create URL object
            URL url = new URL(graphqlEndpoint);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the necessary headers and request method
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            // Write the GraphQL query as the request body
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes(requestBody);
            wr.flush();
            wr.close();

            // Get the response from the GraphQL API
            int responseCode = connection.getResponseCode();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Handle the GraphQL API response
            System.out.println("Response Code: " + responseCode);
            System.out.println("Response Body: " + response.toString());
            return null;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}