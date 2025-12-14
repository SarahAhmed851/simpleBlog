# SimpleBlog

A simple blog platform built with Spring Boot.

## Tech Stack

- Java 21
- Spring Boot 3.5.8
- Spring Security
- Spring Data JPA
- SQLite Database
- Flyway Migrations

## Setup Instructions

1. Clone the repository
2. Create a `.env` file based on `.env.example`:
```
   DB_URL=jdbc:sqlite:database.db
   DB_USERNAME=
   DB_PASSWORD=
```
3. Run the application:
```
   mvn spring-boot:run
```
4. Visit `http://localhost:8080/hello`

## Project Structure
```
src/main/java/com/lab10sarahahmed/simpleBlog/
├── SimpleBlogApplication.java   # Main application
├── config/                      # Security configuration
├── controller/                  # HTTP endpoints
├── model/                       # Entity classes (User)
├── repository/                  # Database access layer
└── service/                     # Business logic
```

## Features

- User registration with password hashing
- User authentication (login)
- SQLite database with Flyway migrations