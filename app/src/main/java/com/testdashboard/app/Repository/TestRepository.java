package com.testdashboard.app.Repository;

import com.testdashboard.app.Entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {
}