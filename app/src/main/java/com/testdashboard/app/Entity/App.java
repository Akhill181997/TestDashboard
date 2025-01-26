package com.testdashboard.app.Entity;

import jakarta.persistence.*;
import lombok.Data;

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

    private Long teamId;



}
