package com.example.hospital.controller;

import com.example.hospital.model.BedRequest;
import com.example.hospital.model.OxygenRequest;
import com.example.hospital.service.MiddlewareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hospital")
public class HospitalController {

    @Autowired
    private MiddlewareService middlewareService;

    @PostMapping("/request-bed")
    public ResponseEntity<String> requestBed(@RequestBody BedRequest request) {
        return ResponseEntity.ok(middlewareService.handleBedRequest(request));
    }

    @PostMapping("/request-oxygen")
    public ResponseEntity<String> requestOxygen(@RequestBody OxygenRequest request) {
        return ResponseEntity.ok(middlewareService.handleOxygenRequest(request));
    }
}