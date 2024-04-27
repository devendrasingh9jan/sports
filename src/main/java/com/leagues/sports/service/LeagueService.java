package com.leagues.sports.service;

import com.leagues.sports.client.LeagueClient;
import com.leagues.sports.model.League;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeagueService {
    @Autowired
    private LeagueClient leagueClient;
    public List<League> getAllByCountry(String country) {
        return leagueClient.getAllCountry(country);
    }
    public League getByCountryAndId(String country, String id) {
        Optional<League> leagueOptional = leagueClient.getByCountryAndId(country, id);
        return leagueOptional.orElse(null);
    }
}
