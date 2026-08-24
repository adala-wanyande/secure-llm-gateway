# Secure Enterprise LLM Gateway

## Project Vision
This project is a cloud-native, microservice-based architecture designed to securely wrap a self-hosted Large Language Model (DeepSeek, hosted on an AWS GPU instance). Motivated by the strict compliance and security requirements of the financial sector (e.g., banking), this gateway provides deterministic guardrails around a non-deterministic AI, acting as a secure bridge between enterprise applications and the model.

## Objectives
- **Microservices Architecture:** Built with Spring Boot 3 / Java 17, structured as a strict Maven multi-module project, to ensure scalability, fault isolation, and maintainability.
- **Enterprise Guardrails:** PII sanitization, strict Redis-backed rate-limiting, and immutable PostgreSQL audit logging to mitigate the risks of AI in a strict corporate environment.
- **15-Factor App Security:** Zero hardcoded secrets. All configuration is externalized via environment variables loaded from `.env`.
- **Cloud-Native Principles:** Fully containerized with Docker Compose (V2), mirroring a production-like local environment.

## Architecture
1. **api-gateway (port 8080):** The entry point. Spring Cloud Gateway handles routing, rate-limiting, and forwards traffic to backend services.
2. **core-ai-service (port 8081):** Sanitizes prompts (PII masking), calls the external DeepSeek LLM endpoint, and returns formatted responses.
3. **audit-service (port 8082):** Asynchronously persists sanitized prompts and AI responses to PostgreSQL for compliance and traceability.
4. **Infrastructure:** PostgreSQL (audit logging) and Redis (rate limiting), provisioned via Docker Compose.

## Development Journal
Daily progress, design decisions, and learnings are documented in the [Project Journal](JOURNAL.md).
