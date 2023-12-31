package com.baseball.BaseballAPI.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@JsonIgnoreProperties(ignoreUnknown = true)
public class Season {


    private int Season;
    private String RegularSeasonStartDate;
    private String PostSeasonStartDate;
    private String SeasonType;
    private String ApiSeason;

    public Season() {

    }

    public int getSeason() {
        return Season;
    }

    public void setSeason(int Season) {
        this.Season = Season;
    }

    public String getRegularSeasonStartDate() {
        return RegularSeasonStartDate;
    }

    public void setRegularSeasonStartDate(String RegularSeasonStartDate) {
        this.RegularSeasonStartDate = RegularSeasonStartDate;
    }

    public String getPostSeasonStartDate() {
        return PostSeasonStartDate;
    }

    public void setPostSeasonStartDate(String PostSeasonStartDate) {
        this.PostSeasonStartDate = PostSeasonStartDate;
    }

    public String getSeasonType() {
        return SeasonType;
    }

    public void setSeasonType(String SeasonType) {
        this.SeasonType = SeasonType;
    }

    public String getApiSeason() {
        return ApiSeason;
    }

    public void setApiSeason(String ApiSeason) {
        this.ApiSeason = ApiSeason;
    }

    @Override
    public String toString() {
        return "Season{" +
                "Season=" + Season +
                ", RegularSeasonStartDate='" + RegularSeasonStartDate + '\'' +
                ", PostSeasonStartDate='" + PostSeasonStartDate + '\'' +
                ", SeasonType='" + SeasonType + '\'' +
                ", ApiSeason='" + ApiSeason + '\'' +
                '}';
    }
}
