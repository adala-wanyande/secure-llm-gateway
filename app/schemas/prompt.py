from pydantic import BaseModel, Field

class PromptRequest(BaseModel):
    user_id: str = Field(..., description="Unique identifier for the user submitting the prompt")
    prompt_text: str = Field(..., description="The raw, unedited prompt from the user")

class PromptResponse(BaseModel):
    sanitized_prompt: str
    ai_response: str
    status: str