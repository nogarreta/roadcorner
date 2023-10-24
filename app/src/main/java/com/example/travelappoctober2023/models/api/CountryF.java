package com.example.travelappoctober2023.models.api;

public class CountryF extends CountryS{
    public String currency;
    public State[] states;
    public Language[] languages;

    public CountryF(String id, String name, String emojiU, String currency, State[] states, Language[] languages) {
        super(id, name, emojiU);
        this.currency = currency;
        this.states = states;
        this.languages = languages;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public State[] getStates() {
        return states;
    }

    public void setStates(State[] states) {
        this.states = states;
    }

    public Language[] getLanguages() {
        return languages;
    }

    public void setLanguages(Language[] languages) {
        this.languages = languages;
    }
}
