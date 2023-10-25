package com.example.travelappoctober2023.utils;

import android.util.Log;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.ApolloClient;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.example.travelappoctober2023.graphql.ContinentQuery;
import com.example.travelappoctober2023.graphql.ContinentQuery.Continent;
import com.example.travelappoctober2023.graphql.ContinentsQuery;
import com.example.travelappoctober2023.graphql.CountryQuery.State;
import org.jetbrains.annotations.NotNull;
import java.util.List;

public class RequestCenter {
    public static String URL = "https://countries.trevorblades.com/graphql";
    public static Continent continent;
    public State state;
    public static List continents;


    public static Continent continentQuery(String _code){
        ApolloClient apolloClient = ApolloClient.builder()
                .serverUrl(URL)
                .build();
// Then enqueue your query
        apolloClient.query(new ContinentQuery(_code))
                .enqueue(new ApolloCall.Callback<ContinentQuery.Data>() {
                    @Override
                    public void onResponse(@NotNull Response<ContinentQuery.Data> response) {
                        assert response.getData() != null;
                        Log.d("Apollo", "Launch site: " + response.getData().continent());
                        continent = response.getData().continent();
                    }
                    @Override
                    public void onFailure(@NotNull ApolloException e) {
                        Log.d("Apollo", "Error", e);
                        continent = null;
                    }
                });
        return continent;
    }
    public static List continentsQuery(){
        ApolloClient apolloClient = ApolloClient.builder()
                .serverUrl(URL)
                .build();
// Then enqueue your query
        apolloClient.query(new ContinentsQuery())
                .enqueue(new ApolloCall.Callback<ContinentsQuery.Data>() {
                    @Override
                    public void onResponse(@NotNull Response<ContinentsQuery.Data> response) {
                        assert response.getData() != null;
                        Log.d("Apollo", "Launch site: " + response.getData().continents());
                        continents = response.getData().continents();
                    }
                    @Override
                    public void onFailure(@NotNull ApolloException e) {
                        Log.d("Apollo", "Error", e);
                        continents = null;
                    }
                });
        return null;
    }
}