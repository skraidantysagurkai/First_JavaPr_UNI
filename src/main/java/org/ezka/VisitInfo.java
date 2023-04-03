package org.ezka;

import java.time.MonthDay;
import java.util.HashMap;
import java.util.UUID;

public class VisitInfo implements Comparable<VisitInfo> {
    // Field declaration
    private UUID patientId;
    private String result;
    private MonthDay date;
    private String PatientName;

    // Constructors
    public VisitInfo() {}

    public VisitInfo(UUID patientId, String result, MonthDay date) {
        if (result == null || date == null)
            throw new IllegalArgumentException();
        this.patientId = patientId;
        this.result = result;
        this.date = date;
    }

    // Getters/Setters for Visit Date, Patient Id, Result
    public MonthDay getDate() {
        return date;
    }

    public void setDate(MonthDay date) {
        this.date = date;
    }

    public UUID getPatientId() {
        return patientId;
    }

    public void setPatientId(UUID patientId) {
        this.patientId = patientId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getPatientName() {
        return PatientName;
    }

    public void setPatientName(String patientName) {
        PatientName = patientName;
    }

    @Override
    public String toString() {
        return "VisitInfo{" +
                "patientId=" + patientId +
                ", result='" + result + '\'' +
                ", date=" + date +
                ", PatientName='" + PatientName + '\'' +
                '}';
    }

    // Overriding compare method for VisitInfo object
    // First we compare by Patient name, then by Visit result, then by Visit date
    @Override
    public int compareTo(VisitInfo o) {
        int compare_by_name = String.CASE_INSENSITIVE_ORDER.compare(this.getPatientName(), o.getPatientName());

        if(compare_by_name == 0){
            int i = String.CASE_INSENSITIVE_ORDER.compare(this.getResult(), o.getResult());

            if(i == 0){
                return this.getDate().compareTo(o.getDate());
            }
            return i;
        }
        return compare_by_name;
    }
}
