# Escuela Conductores API

![Java](https://img.shields.io/badge/Java-21-orange.svg)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.5-brightgreen)
![Maven](https://img.shields.io/badge/Maven-3.x-blue)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-17-blue)
![Swagger](https://img.shields.io/badge/Swagger-OpenAPI-green)
![HATEOAS](https://img.shields.io/badge/REST-HATEOAS-purple)
![License](https://img.shields.io/badge/License-Educational-lightgrey)
![License](https://github.com/VicHZR/escuela-conductores-api/actions/workflows/ci-postgres.yml/badge.svg)
![License](https://github.com/VicHZR/escuela-conductores-api/actions/workflows/ci.yml/badge.svg)

---

## 📌 Descripción

**Escuela Conductores API** es una API REST desarrollada con **Spring Boot 4**, orientada a la gestión de información relacionada con escuelas de conductores.  
El proyecto implementa un CRUD completo, buenas prácticas REST, seguridad, paginación, navegación HATEOAS y documentación con Swagger (OpenAPI).

Este proyecto fue desarrollado con fines **académicos y de aprendizaje**, siguiendo un enfoque profesional de arquitectura y calidad de código.

---

## 🛠️ Tecnologías Utilizadas

- **Java 21**
- **Spring Boot 4.0.5**
- **Spring Data JPA**
- **Spring Security (Basic Authentication)**
- **Spring HATEOAS**
- **PostgreSQL**
- **Hibernate**
- **Maven**
- **Swagger / OpenAPI**
- **Bruno** (pruebas de API)

---

## ⚙️ Funcionalidades

### ✅ Gestión de Departamentos
- CRUD completo (Crear, Listar, Actualizar, Eliminar lógico)
- Eliminación lógica mediante campo de estado
- Búsqueda estándar
- Búsqueda rápida por nombre (case-insensitive)

### ✅ Paginación
- Paginación a nivel de base de datos
- Paginación en memoria usando DTOs

### ✅ Seguridad
- Autenticación básica (Basic Auth)
- Protección de endpoints

### ✅ HATEOAS
- Navegabilidad REST
- Enlaces `self`, `listar` y métodos de negocio

### ✅ Documentación
- Documentación automática mediante Swagger (OpenAPI)

---

## 🔐 Seguridad

La API está protegida mediante **Basic Authentication**.

Credenciales por defecto:

Usuario: admin
Contraseña: admin123

---

## 📑 Swagger / OpenAPI

La documentación de la API se encuentra disponible en:

http://localhost:8081/swagger-ui.html


Desde Swagger es posible:
- Visualizar todos los endpoints
- Probar requests
- Ver estructuras de datos (schemas)

---

## 🧪 Pruebas

Las pruebas funcionales del API fueron realizadas utilizando la herramienta **Bruno**, cubriendo:

- Operaciones CRUD
- Búsquedas
- Paginación
- Endpoints HATEOAS

La colección Bruno se encuentra exportada como evidencia de pruebas del sistema.

---

## 🗄️ Base de Datos

- Motor: **PostgreSQL**
- Modelo relacional con claves foráneas
- Uso de `SERIAL` para claves primarias
- Eliminación lógica basada en estado

Scripts SQL incluidos para:
- Creación de base de datos
- Creación de tablas
- Inserción de datos iniciales

---

## 🚀 Ejecución del Proyecto

1. Clonar el repositorio:
```bash
git clone https://github.com/VicHZR/escuela-conductores-api.git

Configurar la base de datos PostgreSQL
Ejecutar el proyecto:

mvn clean spring-boot:run
```

📘 Notas

Proyecto enfocado en buenas prácticas REST
Código organizado por capas
Dependencias compatibles con Spring Boot 4
Pensado para evaluación académica y portafolio técnico

👨‍💻 Autor
Victor Hugo Guzman Prieto
Proyecto académico – Desarrollo Backend con Spring Boot
