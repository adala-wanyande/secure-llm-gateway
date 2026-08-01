package com.securegateway.coreai.dto;

public class PromptRequest {
    private String userId;
    private String promptText;

    // Default constructor for JSON deserialization
    public PromptRequest() {}

    public PromptRequest(String userId, String promptText) {
        this.userId = userId;
        this.promptText = promptText;
    }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    
    public String getPromptText() { return promptText; }
    public void setPromptText(String promptText) { this.promptText = promptText; }
}