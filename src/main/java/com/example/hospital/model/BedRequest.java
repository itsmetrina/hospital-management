package com.example.hospital.model;

public class BedRequest {
    private String patientName;
    private int bedsNeeded;
    private String hospitalId;

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public int getBedsNeeded() {
        return bedsNeeded;
    }

    public void setBedsNeeded(int bedsNeeded) {
        this.bedsNeeded = bedsNeeded;
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }
}