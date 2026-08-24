from fastapi import FastAPI
from app.core.config import settings
from app.api.routes import ai

app = FastAPI(
    title=settings.PROJECT_NAME,
    openapi_url=f"{settings.API_V1_STR}/openapi.json"
)

# Register the AI routing controller
app.include_router(ai.router, prefix=f"{settings.API_V1_STR}/ai", tags=["AI Orchestration"])

@app.get("/health")
async def health_check():
    return {
        "status": "UP",
        "service": settings.PROJECT_NAME,
        "guardrails": "Active"
    }