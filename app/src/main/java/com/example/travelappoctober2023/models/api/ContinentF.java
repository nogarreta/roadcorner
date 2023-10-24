package com.example.travelappoctober2023.models.api;

public class ContinentF extends ContinentS{
    CountryS[] countries;
    public ContinentF(String code, String name, CountryS[] countries) {
        super(code, name);
        this.countries = countries;
    }
}
