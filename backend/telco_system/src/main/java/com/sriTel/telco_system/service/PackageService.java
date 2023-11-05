package com.sriTel.telco_system.service;

import com.sriTel.telco_system.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackageService {

    @Autowired
    private PackageRepository packageRepository;

    public List<Package> getAllPackages() {
        return packageRepository.findAll();
    }

    public Package activatePackage(Package pack) {
        pack.setActive(true);
        return packageRepository.save(pack);
    }

    public Package deactivatePackage(Package pack) {
        pack.setActive(false);
        return packageRepository.save(pack);
    }
}

