package com.testdashboard.app.Service;


import com.testdashboard.app.Entity.Team;
import com.testdashboard.app.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public ResponseEntity<Object> getTeamById(Long id) {
        Optional<Team> team = teamRepository.findById(id);
        if (team.isPresent()) {
            return new ResponseEntity<>(team.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Team not found!", HttpStatus.NOT_FOUND);
        }
    }

    public String addOrUpdateTeam(Team team) {
        if (team.getId() == null) {

            teamRepository.save(team);
            return "Team added successfully!";
        } else {

            Optional<Team> existingTeam = teamRepository.findById(team.getId());

            if (existingTeam.isPresent()) {
                teamRepository.save(team);
                return "Team updated successfully!";
            } else {
                return "Team not found for update!";
            }
        }
    }
}
