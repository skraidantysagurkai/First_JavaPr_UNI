package org.ezka;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Util {

    // Basic print function used for testing
    public void printHashMap(HashMap<UUID, Patient> patientHM) {
        for (HashMap.Entry entry : patientHM.entrySet()) {
            System.out.println("Patient info: " + entry.getKey() + ":" + entry.getValue());
        }

        System.out.println();
    }

    // Basic print function used for testing
    public void printArrayList(ArrayList<VisitInfo> visits) {
        for (VisitInfo visit : visits) {
            System.out.println("Visit info: " + visit.getPatientId() + ":" + visit.getResult() + ":" + visit.getDate() + ":" + visit.getPatientName());
        }

        System.out.println();
    }

    // Print function for sorted list
    public void printSortedArrayList(ArrayList<VisitInfo> visits) {
        for (VisitInfo v : visits) {
            System.out.printf("Result [%s, %s, %s, %s]%n",
                    v.getPatientId(), v.getPatientName(), v.getResult(), v.getDate());
        }

        System.out.println();
    }

    // Function to map patient names from Patient HashMap to VisitInfo objects
    public void mapHMnamestolist (HashMap<UUID, Patient> patientHM, ArrayList<VisitInfo> visits){
        for (VisitInfo visit: visits){
            UUID id = visit.getPatientId();
            String name = patientHM.get(id).getName();
            visit.setPatientName(name);
        }
    }

    public void countVisits(ArrayList<VisitInfo> visits, HashMap<UUID, Patient> hm, Boolean print){
        // Counting number of specific visit results
        for(VisitInfo visit : visits){
            hm.get(visit.getPatientId()).countVisits(visit.getResult());
        }

        // Printing a list of the number of specific visit result for each patient if print == true
        if(print){
            for (HashMap.Entry<UUID, Patient> entry: hm.entrySet()){
                Patient patient = entry.getValue();
                System.out.printf("patientid = %s, numOfVisitsToSpecialist = %d, numOfVisitsToLab = %d, numOfDiagnosisHealthy = %d\n",
                        patient.getId(), patient.getNumOfVisitsToSpecialist(), patient.getNumOfVisitsToLab(), patient.getNumOfDiagnosisHealthy());
            }
        }
    }
}


