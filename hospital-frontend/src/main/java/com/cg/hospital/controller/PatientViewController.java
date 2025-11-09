package com.cg.hospital.controller;


import com.cg.hospital.model.AppointmentSummaryDTO;
import com.cg.hospital.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@Controller
public class PatientViewController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${backend.base-url:http://localhost:8282}")
    private String backendBaseUrl;
    
    @GetMapping("/patients")
    public String patientsPage(Model model) {
        String url = backendBaseUrl+"/patients/";
        Patient[] patients = restTemplate.getForObject(url, Patient[].class);
        model.addAttribute("patients", patients);
        return "patients";
    }

    @GetMapping("/patients/{ssn}/appointments")
    public String patientAppointments(@PathVariable("ssn") Integer ssn, Model model) {
        String url = backendBaseUrl+"/patients/" + ssn + "/appointments";
        AppointmentSummaryDTO[] appointments = restTemplate.getForObject(url, AppointmentSummaryDTO[].class);
        model.addAttribute("appointments", appointments);
        model.addAttribute("patientId", ssn);
        return "appointments";
    }
}