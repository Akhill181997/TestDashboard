package com.testdashboard.app.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String owner;



    // One-to-Many relationship with App
    @OneToMany(mappedBy = "team") // "team" is the field in App
    private List<App> apps;
}

