package com.securegateway.coreai.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/ai")
public class AiController {

    @GetMapping("/status")
    public Map<String, String> getStatus() {
        // This simulates a response from our future LLM integration
        return Map.of(
            "service", "Core AI Service",
            "status", "Ready to accept LLM prompts",
            "security", "Enterprise Guardrails Active"
        );
    }
}