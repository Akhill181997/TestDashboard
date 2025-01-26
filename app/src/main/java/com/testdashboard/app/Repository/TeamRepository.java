package com.testdashboard.app.Repository;

import com.testdashboard.app.Entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
