package com.cg.hospital.controller;


import com.cg.hospital.model.PhysicianDTO;
import com.cg.hospital.model.AppointmentPatientDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Controller
public class NikhithaFrontendController {

    private final RestTemplate restTemplate;

    @Value("${backend.base-url:http://localhost:8282}")
    private String backendBaseUrl;

    public NikhithaFrontendController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Page 1: Show all physicians
    @GetMapping("/physician")
    public String showAllPhysicians(Model model) {
        String url = backendBaseUrl + "/api/physicians";
        ResponseEntity<PhysicianDTO[]> response = restTemplate.getForEntity(url, PhysicianDTO[].class);
        model.addAttribute("physicians", Arrays.asList(response.getBody()));
        return "physician";
    }

    @GetMapping("/physician/{employeeId}")
    public String showPhysicianAppointments(@PathVariable int employeeId, Model model) {
        String appointmentUrl = backendBaseUrl + "/appointment/patients/" + employeeId;
        try {
            ResponseEntity<AppointmentPatientDTO[]> appointmentResponse =
                    restTemplate.getForEntity(appointmentUrl, AppointmentPatientDTO[].class);

            List<AppointmentPatientDTO> appointments = Arrays.asList(appointmentResponse.getBody());
            model.addAttribute("appointments", appointments);
        } catch (org.springframework.web.client.HttpClientErrorException.NotFound e) {
            // ✅ Handle 404 gracefully
            model.addAttribute("appointments", List.of());
            model.addAttribute("errorMessage", "No appointments found for this physician.");
        }
        model.addAttribute("employeeId", employeeId);
        return "appointment";
    }
}