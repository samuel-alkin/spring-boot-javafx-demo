package com.example.javafxdemo.service;

import com.example.javafxdemo.entity.Team;

import java.util.List;

public interface ITeamService {

    Team createTeam(Team team);

    List<Team> getAllTeams();

}
