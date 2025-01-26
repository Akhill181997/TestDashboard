package com.testdashboard.app.Repository;

import com.testdashboard.app.Entity.App;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRepository  extends JpaRepository<App,Long> {
}
