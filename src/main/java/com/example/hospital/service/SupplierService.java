package com.example.hospital.service;

public class SupplierService {
    public boolean checkBedAvailability(int count) {
        return count <= 3;
    }

    public boolean checkOxygenAvailability(int count) {
        return count <= 5;
    }
}