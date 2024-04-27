package com.leagues.sports.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class League {
    private String idLeague;
    private String strSport;
    private String strLeague;
    private String strLeagueAlternate;
    private String strWebsite;
    private String strCountry;
}
