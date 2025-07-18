package com.example.hospital.service;

import com.example.hospital.model.BedRequest;
import com.example.hospital.model.OxygenRequest;
import org.springframework.stereotype.Service;

@Service
public class MiddlewareService {

    private final RetailerService retailerService = new RetailerService();
    private final SupplierService supplierService = new SupplierService();
    private final ShipperService shipperService = new ShipperService();

    public String handleBedRequest(BedRequest request) {
        boolean available = supplierService.checkBedAvailability(request.getBedsNeeded());
        if (available) {
            shipperService.dispatchBeds(request);
            return "Beds shipped via supplier for: " + request.getPatientName();
        } else {
            boolean procured = retailerService.procureBeds(request.getBedsNeeded());
            if (procured) {
                shipperService.dispatchBeds(request);
                return "Beds procured from retailer and shipped for: " + request.getPatientName();
            } else {
                return "Beds unavailable for: " + request.getPatientName();
            }
        }
    }

    public String handleOxygenRequest(OxygenRequest request) {
        boolean available = supplierService.checkOxygenAvailability(request.getOxygenCylindersNeeded());
        if (available) {
            shipperService.dispatchOxygen(request);
            return "Oxygen shipped via supplier for: " + request.getPatientName();
        } else {
            boolean procured = retailerService.procureOxygen(request.getOxygenCylindersNeeded());
            if (procured) {
                shipperService.dispatchOxygen(request);
                return "Oxygen procured from retailer and shipped for: " + request.getPatientName();
            } else {
                return "Oxygen unavailable for: " + request.getPatientName();
            }
        }
    }
}