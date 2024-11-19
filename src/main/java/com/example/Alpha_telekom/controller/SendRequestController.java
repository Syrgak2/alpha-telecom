package com.example.Alpha_telekom.controller;

import com.example.Alpha_telekom.integrations.ApiRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sendRequest")
public class SendRequestController {
    private final ApiRequest apiRequest;

    public SendRequestController(ApiRequest apiRequest) {
        this.apiRequest = apiRequest;
    }

    @GetMapping
    public ResponseEntity<?> sendRequest() {
        try {
            return ResponseEntity.ok(apiRequest.sendRequest());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
