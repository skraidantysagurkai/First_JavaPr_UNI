package org.ezka;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.MonthDay;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class ReadFromJson {
    // Reading data from Json to Hashmap with Json root being an array, i.e. [data]
    public HashMap<UUID, Patient> readAllPatientData_rootlist(Path path) {
        // Constructing objects
        HashMap<UUID, Patient> patientsHM = new HashMap<>();
        Gson gson = new GsonBuilder().registerTypeAdapter(UUID.class, new UUIDTypeAdapter()).create();


        try {
            String json = new String(Files.readAllBytes(path)); // Reading Json file as a series of Bytes
            List<Patient> patientsL = gson.fromJson(json, new TypeToken<List<Patient>>() {
            }.getType()); // Making a list of Patient objects from series of Bytes

            // Adding id as key and Patient object as value to
            for (Patient patient : patientsL) {
                patientsHM.put(patient.getId(), patient);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return patientsHM;
    }

    // Reading data from Json to ArrayList with Json root being an array, i.e. [data]
    public ArrayList<VisitInfo> readAllVisitInfoData_rootlist(Path path) {
        // Constructing objects
        ArrayList<VisitInfo> visits;
        Gson gson = new GsonBuilder().registerTypeAdapter(MonthDay.class, new MonthDayTypeAdapter()).create();

        try {
            String json = new String(Files.readAllBytes(path)); // Reading Json file as a series of Bytes
            visits = gson.fromJson(json, new TypeToken<ArrayList<VisitInfo>>() {
            }.getType()); // Making a list of VisitInfo objects from series of Bytes
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return visits;
    }
}
