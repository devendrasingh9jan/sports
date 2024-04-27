package com.leagues.sports.client;

import com.leagues.sports.model.League;
import com.leagues.sports.model.LeagueResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Component
public class LeagueClient {

    @Value("${api.url}")
    private String apiUrl;
    private final RestTemplate restTemplate;
    @Autowired
    public LeagueClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public List<League> getAllCountry(String country) {
        LeagueResponse response = null;
        if (StringUtils.hasLength(country)) {
            ResponseEntity<LeagueResponse> responseEntity = restTemplate.getForEntity(apiUrl+country, LeagueResponse.class);
            response = responseEntity.getBody();
        }
        return response != null ? response.getCountries() : null;
    }

    public Optional<League> getByCountryAndId(String country, String id) {
        LeagueResponse response = null;
        if (StringUtils.hasLength(country)) {
            ResponseEntity<LeagueResponse> responseEntity = restTemplate.getForEntity(apiUrl+country, LeagueResponse.class);
            response = responseEntity.getBody();
        }
        return response != null ? response.getCountries().stream().filter(league -> league.getIdLeague().equals(id)).findFirst() : null;
    }
}
