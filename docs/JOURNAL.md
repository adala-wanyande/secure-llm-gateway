# Project Journal

## Day 1: Project Inception, Repository Setup & Maven Scaffolding
**Date:** 27th July 2026

**Goal:** Establish the repository, define the vision, set up documentation, and initialize the multi-module Maven build.

**Thoughts & Decisions:**
- I am starting this project to consolidate my knowledge for the future. 
- For a strict company that operates in a highly regulated environment, this project cannot just be a simple API calling an LLM. It must demonstrate how to wrap AI in strict, deterministic, and secure software engineering practices.
- I decided to use a microservices architecture with Spring Boot. 
- Today, I created the initial project scaffolding. I am committing to working feature-by-feature, maintaining a clean Git history, and focusing heavily on the SWE aspects I want to improve: testing, telemetry, and system design.
- Before writing code, I needed to define the boundaries of the system. I designed the architecture using a standard API Gateway pattern communicating with specialized backend services.
- Added a Redis component for rate limiting to protect the LLM server from being overloaded.
- Separated the "Core AI Service" from the "Audit Service". In a strict enterprise, auditing cannot block the main user flow, so this will be handled asynchronously.
- Documented the architecture using Eraser.io for a highly professional, modern cloud diagram. 

**Technical Learnings & Debugging:**
- **Multi-Module Maven Architecture:** I set up a Parent POM to centralize dependency management. I learned that if you declare a `<module>` in the parent before the child `pom.xml` exists, Maven will fail the build (`ProjectBuildingException`).
- **CLI Generation:** Instead of using a UI, I used `curl` to interact with the Spring Initializr API. Encountered a 400 Bad Request error when piping to `tar` because I requested a deprecated Spring Boot version. Removing the hardcoded version allowed the API to serve the latest stable release.
- **Dependency Version Mismatches:** After generating the `api-gateway` module and linking it to my Parent POM (fixed at Spring Boot 3.3.1), Maven threw an error resolving `spring-boot-starter-actuator-test`. This happened because the child module generated dependencies that the strict parent POM didn't recognize. Removing the unrecognized dependency successfully aligned the child with the parent's centralized versioning, resulting in a clean `BUILD SUCCESS`.

**Next Steps:**
- Generate and link the remaining microservices (`core-ai-service` and `audit-service`) using the same CLI methodology.
- Verify the multi-module compile for the entire ecosystem.

## Day 2: Service Configuration, Reactive Routing & Docker Infrastructure
**Date:** 2nd August 2026

**Goal:** Configure microservice networking, establish API Gateway routing, and provision backing infrastructure.

**Thoughts & Decisions:**
- Transitioned all configuration files from `.properties` to `.yml` for better readability and nested structuring, which is standard in enterprise environments.
- Assigned dedicated ports to prevent collisions: `api-gateway` (8080), `core-ai-service` (8081), and `audit-service` (8082).
- Configured Spring Cloud Gateway to act as the reverse proxy. It uses Netty (non-blocking) to handle high concurrency, successfully intercepting `/api/v1/ai/**` and routing it to the Tomcat-backed Core AI Service.
- Created an Infrastructure as Code (IaC) foundation using `docker-compose.yml` to provision Redis and PostgreSQL. Running these via Docker ensures a clean, containerized local environment mirroring production.

**Technical Learnings & Debugging:**
- **Maven Caching:** After renaming configuration files to `.yml` and changing ports, the Core AI service kept starting on 8080. This happened because Maven was executing from the cached `target` directory. Running `./mvnw clean` forced a rebuild and fixed the issue.
- **Dependency Scope:** Encountered a JUnit compilation failure in the Gateway module (`package org.junit.jupiter.api does not exist`). This was resolved by ensuring the standard `spring-boot-starter-test` dependency was explicitly defined after previously removing a mismatched test dependency.
- **Reactive vs Servlet:** Noticed via startup logs that API Gateway launches on Netty instead of Tomcat. This reinforced the architectural decision to use Spring Cloud Gateway for asynchronous, highly scalable request routing.

**Next Steps:**
- Connect the API Gateway to the Redis container.
- Implement strict Rate Limiting policies to protect the Core AI Service from abuse.