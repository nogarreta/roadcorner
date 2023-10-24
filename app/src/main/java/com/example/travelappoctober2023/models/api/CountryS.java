package com.example.travelappoctober2023.models.api;

public class CountryS {
    String id;
    String name;
    String emojiU;

    public CountryS(String id, String name, String emojiU) {
        this.id = id;
        this.name = name;
        this.emojiU = emojiU;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmojiU(String emojiU) {
        this.emojiU = emojiU;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmojiU() {
        return emojiU;
    }
}
