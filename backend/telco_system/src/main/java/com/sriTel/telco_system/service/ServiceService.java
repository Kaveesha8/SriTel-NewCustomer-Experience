package com.sriTel.telco_system.service;

import com.sriTel.telco_system.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    public List<com.sriTel.telco_system.model.Service> getAllServices() {
        return serviceRepository.findAll();
    }

    public Service activateService(Service service) {
        service.setActive(true);
        return serviceRepository.save(service);
    }

    public Service deactivateService(Service service) {
        service.setActive(false);
        return serviceRepository.save(service);
    }
}

