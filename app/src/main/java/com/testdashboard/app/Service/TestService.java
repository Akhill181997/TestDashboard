package com.testdashboard.app.Service;

import com.testdashboard.app.Entity.Test;
import com.testdashboard.app.Repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;

    public ResponseEntity<Object> getTestById(Long id) {
        Optional<Test> test = testRepository.findById(id);
        if (test.isPresent()) {
            return new ResponseEntity<>(test.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Test not found!", HttpStatus.NOT_FOUND);
        }
    }

    public String addOrUpdateTest(Test test) {
        test.setLastUpdated(LocalDateTime.now());
        if (test.getId() == null) {

            testRepository.save(test);
            return "Test added successfully!";
        } else {

            Optional<Test> existingTest = testRepository.findById(test.getId());

            if (existingTest.isPresent()) {
                testRepository.save(test);
                return "Test updated successfully!";
            } else {
                return "Test not found for update!";
            }
        }
    }
}
