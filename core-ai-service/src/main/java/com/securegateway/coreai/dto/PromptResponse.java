package com.securegateway.coreai.dto;

public class PromptResponse {
    private String sanitizedPrompt;
    private String aiResponse;
    private String status;

    public PromptResponse(String sanitizedPrompt, String aiResponse, String status) {
        this.sanitizedPrompt = sanitizedPrompt;
        this.aiResponse = aiResponse;
        this.status = status;
    }

    public String getSanitizedPrompt() { return sanitizedPrompt; }
    public String getAiResponse() { return aiResponse; }
    public String getStatus() { return status; }
}