package com.example.hospital.service;

import com.example.hospital.model.BedRequest;
import com.example.hospital.model.OxygenRequest;

public class ShipperService {
    public void dispatchBeds(BedRequest request) {
        System.out.println("Dispatching " + request.getBedsNeeded() + " beds to " + request.getHospitalId());
    }

    public void dispatchOxygen(OxygenRequest request) {
        System.out.println("Dispatching " + request.getOxygenCylindersNeeded() + " oxygen cylinders to " + request.getHospitalId());
    }
}