package com.example.javafxdemo.service.impl;

import com.example.javafxdemo.entity.Team;
import com.example.javafxdemo.repository.TeamRepository;
import com.example.javafxdemo.service.ITeamService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService implements ITeamService {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public Team createTeam(Team team) {
        team = teamRepository.save(team);
        return team;
    }

    @Override
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

}
