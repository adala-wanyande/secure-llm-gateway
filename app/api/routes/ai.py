from fastapi import APIRouter
from app.schemas.prompt import PromptRequest, PromptResponse
from app.services.sanitization import SanitizationService

router = APIRouter()

@router.post("/prompt", response_model=PromptResponse)
async def submit_prompt(request: PromptRequest):
    # 1. Enforce Guardrail: Sanitize the input
    sanitized_text = SanitizationService.sanitize_pii(request.prompt_text)

    # 2. Placeholder: Future HTTP call to the Cloud GPU running DeepSeek
    mock_ai_response = f"This is a simulated DeepSeek response to: {sanitized_text}"

    # 3. Return the structured Pydantic response
    return PromptResponse(
        sanitized_prompt=sanitized_text,
        ai_response=mock_ai_response,
        status="SUCCESS"
    )