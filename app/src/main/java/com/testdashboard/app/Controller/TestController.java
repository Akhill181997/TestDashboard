package com.testdashboard.app.Controller;

import com.testdashboard.app.Entity.Test;
import com.testdashboard.app.Service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tests")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getTestById(@PathVariable Long id) {
        return testService.getTestById(id);
    }


    @PostMapping("/addOrUpdate")
    public String addOrUpdateTest(@RequestBody Test test) {
        return testService.addOrUpdateTest(test);
    }



}