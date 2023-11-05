package com.sriTel.telco_system.controller;

import com.sriTel.telco_system.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/packages")
public class PackageController {

    @Autowired
    private PackageService packageService;

    @GetMapping("/view")
    public List<Package> viewPackages() {
        return packageService.getAllPackages();
    }

    @PostMapping("/activate")
    public Package activatePackage(@RequestBody Package pack) {
        return packageService.activatePackage(pack);
    }

    @PostMapping("/deactivate")
    public Package deactivatePackage(@RequestBody Package pack) {
        return packageService.deactivatePackage(pack);
    }
}
