package com.sriTel.telco_system.controller;

import com.sriTel.telco_system.model.Service;
import com.sriTel.telco_system.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @GetMapping("/view")
    public List<Service> viewServices() {
        return serviceService.getAllServices();
    }

    @PostMapping("/activate")
    public Service activateService(@RequestBody Service service) {
        return (Service) serviceService.activateService(service);
    }

    @PostMapping("/deactivate")
    public Service deactivateService(@RequestBody Service service) {
        return (Service) serviceService.deactivateService(service);
    }
}

