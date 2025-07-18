package com.example.hospital.service;

public class RetailerService {
    public boolean procureBeds(int count) {
        return count <= 5;
    }

    public boolean procureOxygen(int count) {
        return count <= 10;
    }
}