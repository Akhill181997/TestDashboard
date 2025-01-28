package com.testdashboard.app.Entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@Entity
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String testName;
    private String result;
    private LocalDateTime lastUpdated;

    // Many-to-One relationship with App
    @ManyToOne
    @JoinColumn(name = "app_id") // Foreign key column in Test table
    private App app;
}
