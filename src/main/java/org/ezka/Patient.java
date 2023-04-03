package org.ezka;

import java.util.Objects;
import java.util.UUID;

public class Patient {
    // Field declaration
    private UUID id;
    private String name;

    private int numOfVisitsToSpecialist;
    private int numOfVisitsToLab;
    private int numOfDiagnosisHealthy;

    // Constructors
    public Patient(UUID id, String name) {
        if (name == null)
            throw new IllegalArgumentException();
        this.id = id;
        this.name = name;
    }

    public Patient() {}

    // Getters/Setters for Patient Id and Patient Name
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfVisitsToSpecialist() {
        return numOfVisitsToSpecialist;
    }

    public int getNumOfVisitsToLab() {
        return numOfVisitsToLab;
    }

    public int getNumOfDiagnosisHealthy() {
        return numOfDiagnosisHealthy;
    }

    // To String func
    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    // Adding a number of specific visits
    public void countVisits(String result) {
        if(Objects.equals(result, "visitToSpecialist")){
            this.numOfVisitsToSpecialist++;
        }
        else if(Objects.equals(result, "visitToLaboratory")){
            this.numOfVisitsToLab++;
        }
        else if(Objects.equals(result, "healthy")){
            this.numOfDiagnosisHealthy++;
        }
        else{
            throw new IllegalArgumentException("result is either NULL or is not accepted\n");
        }
    }
}
