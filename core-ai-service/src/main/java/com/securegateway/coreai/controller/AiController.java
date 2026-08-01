package com.securegateway.coreai.controller;

import com.securegateway.coreai.dto.PromptRequest;
import com.securegateway.coreai.dto.PromptResponse;
import com.securegateway.coreai.service.LlmOrchestrationService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/ai")
public class AiController {

    private final LlmOrchestrationService orchestrationService;

    // Constructor Injection (Best Practice for Spring)
    public AiController(LlmOrchestrationService orchestrationService) {
        this.orchestrationService = orchestrationService;
    }

    @GetMapping("/status")
    public Map<String, String> getStatus() {
        return Map.of("status", "Core AI Service is running with strict guardrails.");
    }

    @PostMapping("/prompt")
    public PromptResponse submitPrompt(@RequestBody PromptRequest request) {
        return orchestrationService.processPrompt(request);
    }
}