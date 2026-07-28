# Project Journal

## Day 1: Project Inception & Repository Setup
**Date:** 27th July 2026

**Goal:** Establish the repository, define the vision, and set up documentation.

**Thoughts & Decisions:**
- I am starting this project to consolidate my knowledge for the future. 
- For a strict company that operates in a highly regulated environment. Therefore, this project cannot just be a simple API calling an LLM. It must demonstrate how to wrap AI in strict, deterministic, and secure software engineering practices.
- I decided to use a microservices architecture with Spring Boot. 
- Today, I created the initial project scaffolding. I am committing to working feature-by-feature, maintaining a clean Git history, and focusing heavily on the SWE aspects I want to improve: testing, telemetry, and system design.
- Before writing code, I needed to define the boundaries of the system. I designed the architecture using a standard API Gateway pattern communicating with specialized backend services.
- Added a Redis component for rate limiting to protect the LLM server from being overloaded.
- Separated the "Core AI Service" from the "Audit Service". In a strict enterprise, auditing cannot block the main user flow, so this will be handled asynchronously.
- Documented the architecture using Eraser.io for a highly professional, modern cloud diagram. 

**Next Steps:**
- Initialize the Spring Boot multi-module project (Parent POM, API Gateway, Core Service, Audit Service).