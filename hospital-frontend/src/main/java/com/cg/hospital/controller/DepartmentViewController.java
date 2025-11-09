package com.cg.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.cg.hospital.model.Department;
import com.cg.hospital.model.DepartmentPhysicianResponseDTO;

@Controller
public class DepartmentViewController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${backend.base-url:http://localhost:8282}")
    private String backendBaseUrl;
    
    @GetMapping("/departments")
    public String departmentsPage(Model model) {
        String url = backendBaseUrl+"/api/departments";
        Department[] departments = restTemplate.getForObject(url, Department[].class);
        model.addAttribute("departments", departments);
        return "departments";
    }

    @GetMapping("/departments/{id}/physicians")
    public String departmentPhysicians(@PathVariable("id") Integer deptId, Model model) {
        String url = backendBaseUrl+"/api/physicians/department/" + deptId;
        DepartmentPhysicianResponseDTO response = restTemplate.getForObject(url, DepartmentPhysicianResponseDTO.class);
        model.addAttribute("department", response);
        return "physicians";
    }
}