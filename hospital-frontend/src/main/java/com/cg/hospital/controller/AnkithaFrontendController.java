package com.cg.hospital.controller;

import com.cg.hospital.model.AnkithaPatientModel;
import com.cg.hospital.model.AnkithaStayModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Controller
public class AnkithaFrontendController {

    private final RestTemplate restTemplate;

    @Value("${backend.base-url:http://localhost:8282}")
    private String backendBaseUrl;

    public AnkithaFrontendController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // 🩺 Page 1: All Patients
    @GetMapping("/ankitha-patients")
    public String showAllPatients(Model model) {
        try {
            String url = backendBaseUrl + "/patient/"; // backend endpoint from AnkithaPatient.java
            ResponseEntity<AnkithaPatientModel[]> response = restTemplate.getForEntity(url, AnkithaPatientModel[].class);
            List<AnkithaPatientModel> patients = Arrays.asList(response.getBody());
            model.addAttribute("patients", patients);
            return "ankitha-patients";
        } catch (Exception e) {
            model.addAttribute("error", "Unable to fetch patients: " + e.getMessage());
            return "error";
        }
    }

    // 🧾 Page 2: Show stays for selected patient
    @GetMapping("/ankitha-patient/{ssn}")
    public String showPatientStays(@PathVariable int ssn, Model model) {
        model.addAttribute("ssn", ssn);

        try {
            // Fetch all patients to show info
            String patientListUrl = backendBaseUrl + "/patient/";
            ResponseEntity<AnkithaPatientModel[]> patientResponse = restTemplate.getForEntity(patientListUrl, AnkithaPatientModel[].class);
            AnkithaPatientModel[] allPatients = patientResponse.getBody();

            AnkithaPatientModel selectedPatient = null;
            if (allPatients != null) {
                for (AnkithaPatientModel p : allPatients) {
                    if (p.getSsn() == ssn) {
                        selectedPatient = p;
                        break;
                    }
                }
            }
            model.addAttribute("patient", selectedPatient);

            // Fetch stays for patient
            String staysUrl = backendBaseUrl + "/api/stay/patient/" + ssn;
            ResponseEntity<AnkithaStayModel[]> staysResponse = restTemplate.getForEntity(staysUrl, AnkithaStayModel[].class);
            List<AnkithaStayModel> stays = Arrays.asList(staysResponse.getBody());
            model.addAttribute("stays", stays);

        } catch (HttpClientErrorException.NotFound e) {
            model.addAttribute("stays", List.of());
            model.addAttribute("message", "No stays found for this patient.");
        } catch (Exception e) {
            model.addAttribute("error", "Unable to fetch stay details: " + e.getMessage());
            return "error";
        }

        return "ankitha-patient-details";
    }
}
