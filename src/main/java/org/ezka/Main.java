package org.ezka;


import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        // Initiating objects
        Util utility = new Util();
        MergeSort sort = new MergeSort();

        System.out.println(" read from json \n");

        // Reading data from json file located in the DataGenerator folder (Created by a python script)
        HashMap<UUID, Patient> patientHM = new ReadFromJson().readAllPatientData_rootlist(Path.of("src/main/DataGenerator/Patient.json"));
        ArrayList visitInfos = new ReadFromJson().readAllVisitInfoData_rootlist(Path.of("src/main/DataGenerator/VisitInfo.json"));

        // Mapping names of patients from Hashmap to list of visits
        utility.mapHMnamestolist(patientHM, visitInfos);

        // Sorting the array list, first by name, second by result, third by the date of visit
        sort.sort(visitInfos);
        utility.printSortedArrayList(visitInfos);

        // Counting all the visit results of a patient
        // If the last parameter is true, after counting it will print a list of all the values of all patients
        utility.countVisits(visitInfos, patientHM, true);
    }
}