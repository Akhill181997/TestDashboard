package com.testdashboard.app.Controller;

import com.testdashboard.app.Entity.Team;
import com.testdashboard.app.Service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;


    @GetMapping("/{id}")
    public ResponseEntity<Object> getTeamById(@PathVariable Long id) {
        return teamService.getTeamById(id);
    }


    @PostMapping("/addOrUpdate")
    public String addOrUpdateTeam(@RequestBody Team team) {
        return teamService.addOrUpdateTeam(team);
    }



}
