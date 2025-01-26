package com.testdashboard.app.Controller;


import com.testdashboard.app.Entity.App;
import com.testdashboard.app.Service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/apps")
public class AppController {

    @Autowired
    private AppService appService;


    @GetMapping("/{id}")
    public ResponseEntity<Object> getAppById(@PathVariable Long id) {
        return appService.getAppById(id);
    }

    @PostMapping("/addOrUpdate")
    public String addOrUpdateApp(@RequestBody App app) {
        return appService.addOrUpdateApp(app);
    }



}
