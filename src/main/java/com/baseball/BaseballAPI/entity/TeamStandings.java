package com.baseball.BaseballAPI.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamStandings {

    private String key, name, wins, losses;

    public TeamStandings() {

    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWins() {
        return wins;
    }

    public void setWins(String wins) {
        this.wins = wins;
    }

    public String getLosses() {
        return losses;
    }

    public void setLosses(String losses) {
        this.losses = losses;
    }

    @Override
    public String toString() {
        return "Standings{" +
                "Key='" + key + '\'' +
                ", Name='" + name + '\'' +
                ", Wins='" + wins + '\'' +
                ", Losses='" + losses + '\'' +
                '}';
    }
}
