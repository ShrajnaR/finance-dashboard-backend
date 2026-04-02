# Finance Dashboard Backend

## Overview

This project is a backend system for managing financial data with role-based access control. It provides APIs for handling financial records and generating summary insights for a dashboard.

---

## Features

### User Roles and Access Control

The system supports three roles:

* **ADMIN** → Full access to manage users and financial records
* **ANALYST** → Access to financial records and dashboard insights
* **VIEWER** → Access limited to dashboard data

Role-based access is enforced at the API level using Spring Security.

---

### Financial Records Management

* Create and manage financial records (income and expense)
* Each record includes amount, type, category, date, and notes
* Supports filtering by category, type, and date
* Pagination is available for efficient data retrieval
* Soft delete is implemented to avoid permanent data loss

---

### Dashboard Summary

Provides aggregated financial insights
* Total income
* Total expenses
* Net balance

---

### Validation and Error Handling

* Request validation using DTOs
* Proper error responses for invalid input
* Global exception handling for consistent API behavior

---

## Tech Stack

* Java 17
* Spring Boot
* Spring Data JPA
* Spring Security
* MySQL

---

## Project Structure

com.finance.dashboard
├── config
├── controller
├── dto
├── entity
├── enums
├── exception
├── repository
├── service

---

## Assumptions

* Basic Authentication is used for simplicity
* Passwords are stored as plain text
* Soft delete is handled using a boolean flag
* Filtering is implemented using a priority-based approach

---


## How to Run

1. Clone the repository:

	git clone https://github.com/ShrajnaR/finance-dashboard-backend.git

2. Open the project in IDE (IntelliJ / Eclipse)

3. Create MySQL database:

	CREATE DATABASE finance_db;

4. Update database credentials in:
   src/main/resources/application.properties

5. Run the Spring Boot application

6. Test APIs using Postman:

* Import finance-dashboard.postman_collection.json
* Use Basic Auth:
  	Username: admin
  	Password: 1234

---

## Possible Improvements

* JWT-based authentication
* Password encryption
* Unit and integration testing

---

## Summary

The project demonstrates a clean backend design with proper layering, role-based access control, and structured API development for a finance dashboard system.
