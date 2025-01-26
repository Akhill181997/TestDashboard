package com.testdashboard.app.Service;

import com.testdashboard.app.Entity.App;
import com.testdashboard.app.Repository.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppService {

    @Autowired
    private AppRepository appRepository;

    public ResponseEntity<Object> getAppById(Long id) {
        Optional<App> app = appRepository.findById(id);
        if (app.isPresent()) {
            return new ResponseEntity<>(app.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("App not found!", HttpStatus.NOT_FOUND);
        }
    }

    public String addOrUpdateApp(App app) {
        if (app.getId() == null) {

            appRepository.save(app);
            return "App added successfully!";
        } else {

            Optional<App> existingApp = appRepository.findById(app.getId());

            if (existingApp.isPresent()) {

                appRepository.save(app);
                return "App updated successfully!";
            } else {
                return "App not found for update!";
            }
        }
    }
}
