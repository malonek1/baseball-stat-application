package com.baseball.BaseballAPI.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties({"Season", "SeasonType", "TeamID"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamStandings {

    String Key, Name, Wins, Losses;

    public TeamStandings() {

    }

    public String getKey() {
        return Key;
    }

    public void setKey(String Key) {
        this.Key = Key;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getWins() {
        return Wins;
    }

    public void setWins(String Wins) {
        this.Wins = Wins;
    }

    public String getLosses() {
        return Losses;
    }

    public void setLosses(String Losses) {
        this.Losses = Losses;
    }

    @Override
    public String toString() {
        return "Standings{" +
                "Key='" + Key + '\'' +
                ", Name='" + Name + '\'' +
                ", Wins='" + Wins + '\'' +
                ", Losses='" + Losses + '\'' +
                '}';
    }
}
