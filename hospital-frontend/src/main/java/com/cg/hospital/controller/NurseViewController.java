package com.cg.hospital.controller;

import com.cg.hospital.model.Nurse;
import com.cg.hospital.model.NurseDetailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
public class NurseViewController {
         
    @Autowired
    private RestTemplate restTemplate;

//    private static final String BACKEND = "http://localhost:8282";
    
    @Value("${backend.base-url:http://localhost:8282}")
    private String backendBaseUrl;
    
    // Master table: all nurses
    @GetMapping("/nurses")
    public String nursesPage(Model model) {
        String url = backendBaseUrl + "/nurses";
        Nurse[] nurses = restTemplate.getForObject(url, Nurse[].class);
        model.addAttribute("nurses", nurses);
        return "nurses"; // templates/nurses.html
    }

    // Detail: nurse + OnCalls
    @GetMapping("/nurses/{employeeId}")
    public String nurseDetail(@PathVariable Integer employeeId, Model model) {
        String url = backendBaseUrl + "/nurses/" + employeeId;
        NurseDetailResponse detail = restTemplate.getForObject(url, NurseDetailResponse.class);
        model.addAttribute("detail", detail);
        return "nurse-detail"; // templates/nurse-detail.html
    }
}

