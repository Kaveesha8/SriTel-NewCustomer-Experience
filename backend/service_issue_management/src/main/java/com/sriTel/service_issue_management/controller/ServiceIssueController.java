package com.sriTel.service_issue_management.controller;
import com.sriTel.service_issue_management.model.ServiceIssue;
import com.sriTel.service_issue_management.service.ServiceIssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/serviceissues")
public class ServiceIssueController {

    @Autowired
    private ServiceIssueService serviceIssueService;

    @PostMapping("/report")
    public ResponseEntity<ServiceIssue> reportServiceIssue(@RequestBody ServiceIssue serviceIssue) {
        ServiceIssue createdServiceIssue = serviceIssueService.reportServiceIssue(serviceIssue);
        return ResponseEntity.ok(createdServiceIssue);
    }

    @PutMapping("/resolve/{id}")
    public ResponseEntity<ServiceIssue> resolveServiceIssue(@PathVariable Long id) {
        ServiceIssue resolvedServiceIssue = serviceIssueService.resolveServiceIssue(id);
        if (resolvedServiceIssue == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(resolvedServiceIssue);
        }
    }

    @GetMapping
    public ResponseEntity<List<ServiceIssue>> getAllServiceIssues() {
        List<ServiceIssue> serviceIssues = serviceIssueService.getAllServiceIssues();
        return ResponseEntity.ok(serviceIssues);
    }
}
