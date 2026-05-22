# 🚗 Driving School Management Engine: Hypermedia-Driven RESTful API

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.0.5-6DB33F?style=for-the-badge&logo=springboot)
![Maven](https://img.shields.io/badge/Maven-3.x-C71A36?style=for-the-badge&logo=apachemaven)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-17-4169E1?style=for-the-badge&logo=postgresql)
![Swagger](https://img.shields.io/badge/OpenAPI-Swagger-85EA2D?style=for-the-badge&logo=swagger)
![HATEOAS](https://img.shields.io/badge/REST-HATEOAS-7A1FA2?style=for-the-badge)
![License](https://img.shields.io/badge/License-Educational-lightgrey?style=for-the-badge)

![Postgres CI](https://github.com/VicHZR/escuela-conductores-api/actions/workflows/ci-postgres.yml/badge.svg)
![Java CI](https://github.com/VicHZR/escuela-conductores-api/actions/workflows/ci.yml/badge.svg)

---

## 🚀 Overview

**Escuela Conductores API** is a production-grade, enterprise-ready **RESTful API Core Engine** built with **Java 21** and **Spring Boot 4.0.5** to manage multi-regional driving school assets. 

This platform implements the highest level of REST maturity by incorporating native **HATEOAS navigational hypermedia controls**, rigorous dual-layer database and memory pagination via Data Transfer Objects (DTOs), role-based endpoint security, and automated continuous integration testing workflows.

    - Java 100.0%

🎯 Focus: **Hypermedia-driven API design, relational data auditing, secure data streams, and automated pipeline integration testing.**

---

## 🎯 Key Technical Features

- 🏗️ **Richardson REST Maturity Level 3 (HATEOAS):** Seamless application state navigation embedding self-descriptive hypermedia resource links (`self`, `listar`, and custom business semantic nodes).
- 📊 **Optimized Dual-Layer Pagination:** High-throughput pagination mechanisms running both natively at the database layer (SQL limits) and in-memory using highly-decoupled DTO processing layers.
- 🔐 **Spring Security Pipeline:** Solid protection architecture deploying **Basic Authentication** layers over critical data mutation resources.
- 🚗 **Departmental Lifecycle Management:** Complete data manipulation matrix to Create, Read, Update, and delete data securely, featuring fast case-insensitive query utilities.
- 🛡️ **Data Integrity & Logical Soft Deletes:** Advanced operational lifecycle tracking mapping database table deletions via automated soft-delete status flags to safeguard historical audit trails.
- 🔌 **Automated OpenAPI 3 / Swagger Sandbox:** Full interactive documentation engine analyzing controllers and schemas dynamically at the server root.

---

## 🏗️ Project Architecture Layout

The codebase enforces a strict layer-decoupled architectural blueprint (Controller-Service-Repository) for absolute separation of concerns:

```text
escuela-conductores-api/
│
├── .github/workflows/          # Automated continuous integration pipeline workflows (ci.yml / ci-postgres.yml)
├── bruno/                      # Headless enterprise API automated verification collections
├── src/
│   ├── main/
│   │   ├── java/               # Core software architecture (Controllers, Services, DTOs, Entities)
│   │   └── resources/          # Application application.properties and security variables
│   └── test/                   # Isolated test execution suites
│
├── ScriptProyecto_escuela_conductores.sql # Database DDL schemas, relational constraints, and seeds
├── pom.xml                     # Apache Maven lifecycle manifest and dependency configuration
└── README.md                   # Technical engineering documentation
```

---

## 📊 Impact (CV-Level Highlights)

- 📈 **Achieved Level 3 REST Maturity:** Transformed standard endpoints into self-descriptive hypermedia APIs using **Spring HATEOAS**, drastically easing client-side consumer integration.
- ⚡ **Spring Boot 4 Application Blueprint:** Built the engine using the modern Spring Framework core, leveraging Hibernate data mapping optimization patches.
- 🛡️ **Zero-Downtime Data Auditing:** Preserved strict operational compliance footprints by applying structural soft-delete logic instead of destructive SQL row drops.
- 📉 **Automated Integration Testing:** Reduced technical release verification loops significantly by shipping a pre-configured headless **Bruno API collection**.

---

## ⚙️ Installation & Local Run Guide

### 1. Prerequisites
Ensure your local host workstation has the following platform layers active:
- **Java SE Development Kit (JDK 21)**
- **Apache Maven 3.8+**
- **PostgreSQL Database Server (v17 Core)**

### 2. Project Bootstrapping
```bash
git clone https://github.com/VicHZR/escuela-conductores-api.git
cd escuela-conductores-api
```

### 3. Initialize the Relational Schema
Open your PostgreSQL cluster administrator workspace (pgAdmin, DBeaver, or psql tool), spin up an independent database instance, and execute the structural scripts inside `ScriptProyecto_escuela_conductores.sql` to initialize tables, `SERIAL` primary keys, constraints, and data seeds.

### 4. Run the Spring Boot Engine
Compile dependencies and launch the localized API server thread from your terminal:
```bash
mvn clean spring-boot:run
```

---

## 🔌 API Inspection & Sandbox Access Points

Once the local application server is active, you can inspect routing parameters and sample requests through the following gateways:

- 🌐 **Interactive OpenAPI Sandbox (Swagger UI):** [http://localhost:8081/swagger-ui.html](http://localhost:8081/swagger-ui.html) – Ideal for endpoint visual analysis, query structures (schemas), and manual request trials.
- 🧪 **Automated Testing Suite (Bruno):** Import the files located within the `/bruno` directory into your Bruno editor to execute the fully parameter-mapped REST regression collections.

---

## 🔑 Institutional Security Credentials

Access protection blocks handle authorization rules systematically via standard profiles:



| Institutional Account | Default Identity Token | Verification Secret | Operational Profile Access |
| :--- | :--- | :--- | :--- |
| **🟢 System Administrator** | `admin` | `admin123` | Full Data Modifications & CRUD Clearance |

---
© 2026 **Escuela Conductores Engine** • Developed by **Victor Hugo Guzman Prieto**
