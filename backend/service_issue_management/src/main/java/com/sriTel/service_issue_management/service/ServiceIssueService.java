package com.sriTel.service_issue_management.service;

import com.sriTel.service_issue_management.model.ServiceIssue;
import com.sriTel.service_issue_management.repository.ServiceIssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceIssueService {

    @Autowired
    private ServiceIssueRepository serviceIssueRepository;

    public ServiceIssue reportServiceIssue(ServiceIssue serviceIssue) {
        serviceIssue.setStatus("Reported");
        return serviceIssueRepository.save(serviceIssue);
    }

    public ServiceIssue resolveServiceIssue(Long id) {
        ServiceIssue serviceIssue = serviceIssueRepository.findById(id).orElse(null);
        if (serviceIssue != null) {
            serviceIssue.setStatus("Resolved");
            serviceIssueRepository.save(serviceIssue);
        }
        return serviceIssue;
    }

    public List<ServiceIssue> getAllServiceIssues() {
        return serviceIssueRepository.findAll();
    }
}
