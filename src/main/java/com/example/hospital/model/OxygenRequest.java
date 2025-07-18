package com.example.hospital.model;

public class OxygenRequest {
    private String patientName;
    private int oxygenCylindersNeeded;
    private String hospitalId;

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public int getOxygenCylindersNeeded() {
        return oxygenCylindersNeeded;
    }

    public void setOxygenCylindersNeeded(int oxygenCylindersNeeded) {
        this.oxygenCylindersNeeded = oxygenCylindersNeeded;
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }
}