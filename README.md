# HRMS Backend

This repository contains the backend service for a Mini Human Resource Management System (HRMS) built using Spring Boot.  
It exposes REST APIs for employee management and demonstrates basic role-based access control.

---

## Features

- Employee CRUD operations
- RESTful APIs using Spring Boot
- Role-based access control (Admin/User – demo level)
- MySQL database integration
- Layered architecture (Controller, Service, Repository)

---

## Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Maven

---

## API Endpoints

Base URL: http://localhost:8080/api/employees


| Method | Endpoint | Description |
|------|---------|-------------|
| GET | `/api/employees` | Fetch all employees |
| GET | `/api/employees/{id}` | Fetch employee by ID |
| POST | `/api/employees` | Create employee (Admin only) |
| PUT | `/api/employees/{id}` | Update employee (Admin only) |
| DELETE | `/api/employees/{id}` | Delete employee (Admin only) |

---

## Role-Based Access (Demo)

- **ADMIN**
  - Can add, edit, and delete employees
- **USER**
  - Read-only access

> This is a demo-level RBAC implementation.  
> In a production system, roles would be enforced using authentication mechanisms such as JWT and Spring Security.

---

## How to Run

1. Ensure MySQL is running
2. Update database credentials in `application.properties`
3. Run the application:
   ```bash
   mvn spring-boot:run

## Backend will start at

http://localhost:8080
