package com.leagues.sports.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LeagueResponse {
    private List<League> countries;
}
