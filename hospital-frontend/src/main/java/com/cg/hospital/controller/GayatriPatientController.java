package com.cg.hospital.controller;

	import org.springframework.beans.factory.annotation.Value;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.client.HttpClientErrorException;
	import org.springframework.web.client.RestTemplate;

	import com.cg.hospital.model.Patient;
	import com.cg.hospital.model.PrescriptionDTO;

	import org.springframework.http.ResponseEntity;

	@Controller
	public class GayatriPatientController {

	    private final RestTemplate restTemplate;

	    @Value("${backend.base-url:http://localhost:8282}")
	    private String backendBaseUrl;

	    public GayatriPatientController(RestTemplate restTemplate) {
	        this.restTemplate = restTemplate;
	    }

	    @GetMapping("/patientnew")
	    public String patients(Model model) {
	        String url = backendBaseUrl + "/patientsnew/";
	    	
	        ResponseEntity<Patient[]> resp = restTemplate.getForEntity(url, Patient[].class);
	        model.addAttribute("patientnew", resp.getBody());
	        return "patientnew";
	    }

	    @GetMapping("/patient/{id}")
	    public String prescriptions(@PathVariable Long id, Model model) {
	        String url = backendBaseUrl + "/prescribes/" + id + "/prescriptions";
	        try {
	            ResponseEntity<PrescriptionDTO[]> resp = restTemplate.getForEntity(url, PrescriptionDTO[].class);
	            model.addAttribute("prescriptions", resp.getBody());
	        } catch (HttpClientErrorException.NotFound e) {
	            model.addAttribute("prescriptions", new PrescriptionDTO[0]);
	            model.addAttribute("noPrescriptions", true);
	        }
	        model.addAttribute("patientId", id);
	        return "prescriptions";
	    }

	}








