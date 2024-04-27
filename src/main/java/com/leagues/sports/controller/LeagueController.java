package com.leagues.sports.controller;

import com.leagues.sports.model.League;
import com.leagues.sports.service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/leagues")
public class LeagueController {

    @Autowired
    private LeagueService leagueService;

    @GetMapping("/all")
    public ResponseEntity<List<League>> getAllLeaguesByCountry(@RequestParam("country") String country) {
        List<League> leagues = leagueService.getAllByCountry(country);
        return ResponseEntity.ok(leagues);
    }

    @GetMapping("/id")
    public ResponseEntity<League> getAllLeaguesByCountryAndId(@RequestParam("country") String country, @RequestParam("id") String id) {
        League league = leagueService.getByCountryAndId(country, id);
        return ResponseEntity.ok(league);
    }
}
