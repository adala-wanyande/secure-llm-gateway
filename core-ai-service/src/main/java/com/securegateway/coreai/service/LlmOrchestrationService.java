package com.securegateway.coreai.service;

import com.securegateway.coreai.dto.PromptRequest;
import com.securegateway.coreai.dto.PromptResponse;
import org.springframework.stereotype.Service;

@Service
public class LlmOrchestrationService {

    public PromptResponse processPrompt(PromptRequest request) {
        // 1. Sanitize the input (Enterprise Guardrail)
        String sanitizedText = sanitizePii(request.getPromptText());

        // 2. Placeholder for actual LLM HTTP call (We will build this later)
        String mockAiResponse = "This is a simulated AI response to: " + sanitizedText;

        // 3. Return structured response
        return new PromptResponse(sanitizedText, mockAiResponse, "SUCCESS");
    }

    private String sanitizePii(String input) {
        if (input == null) return "";
        
        // Simple regex to mask anything that looks like a 9-digit Bank Account Number or SSN
        // Replaces digits with asterisks except the last 4
        return input.replaceAll("\\b\\d{5}(\\d{4})\\b", "*****$1");
    }
}