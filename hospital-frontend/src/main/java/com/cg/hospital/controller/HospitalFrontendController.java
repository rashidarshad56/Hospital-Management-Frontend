package com.cg.hospital.controller;


import com.cg.hospital.model.BlockDTO;
import com.cg.hospital.model.RoomDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller

public class HospitalFrontendController {

    private final RestTemplate restTemplate;

    @Value("${backend.base-url:http://localhost:8282}")
    private String backendBaseUrl;

    public HospitalFrontendController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/floors")
    public String showFloors(Model model) {
        String url = backendBaseUrl + "/api/blocks";
        ResponseEntity<Integer[]> response = restTemplate.getForEntity(url, Integer[].class);
        model.addAttribute("floors", response.getBody());
        return "floors";
    }

    // ✅ Page 2: Show block codes for selected floor
    @GetMapping("/floor/{floor}")
    public String showBlockCodes(@PathVariable Integer floor, Model model) {
        String url = backendBaseUrl + "/api/blocks/" + floor;
        ResponseEntity<BlockDTO[]> response = restTemplate.getForEntity(url, BlockDTO[].class);
        model.addAttribute("floor", floor);
        model.addAttribute("codes", response.getBody());
        return "block-codes";
    }

    // ✅ Page 3: Show rooms for selected block
    @GetMapping("/rooms/{floor}/{code}")
    public String showRooms(@PathVariable Integer floor, @PathVariable Integer code, Model model) {
        String url = backendBaseUrl + "/api/rooms/" + floor + "/" + code;
        try {
            ResponseEntity<RoomDTO[]> response = restTemplate.getForEntity(url, RoomDTO[].class);
            RoomDTO[] rooms = response.getBody();
            if (rooms == null) {
                rooms = new RoomDTO[0];
            }
            model.addAttribute("rooms", rooms);
        } catch (Exception e) {
            model.addAttribute("rooms", new RoomDTO[0]);
        }
        model.addAttribute("floor", floor);
        model.addAttribute("code", code);
        return "rooms";
    }
}