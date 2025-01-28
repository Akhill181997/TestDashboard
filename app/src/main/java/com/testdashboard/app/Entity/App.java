package com.testdashboard.app.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class App {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String workspace;
    private String gitRepo;
    private String devOpsUrl;

    // Many-to-One relationship with Team
    @ManyToOne
    @JoinColumn(name = "team_id") // Foreign key column in the App table
    private Team team;

}

