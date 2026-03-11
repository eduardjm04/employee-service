# Employee Service API

REST API for managing employees built with **Spring Boot 2.7**, **Spring Data JPA**, and **H2 Database**.

This project demonstrates a clean backend architecture with best practices such as layered design, validation, exception handling, logging, and API documentation.

---

## Technologies

* Java 17
* Spring Boot 2.7
* Spring Data JPA / Hibernate
* H2 Database
* OpenAPI / Swagger
* Lombok
* JUnit 5 / Mockito
* Docker

---

## Architecture

The project follows a layered architecture:

controller → service → repository → database

Additional layers:

* DTOs
* Mapper
* Exception handling
* Constants
* Utils

---

## Running the application

### Run locally

```bash
mvn spring-boot:run
```

Application will start on:

```
http://localhost:9090
```

---

## API Documentation

Swagger UI is available at:

```
http://localhost:9090/swagger-ui/index.html
```

---

## Main Endpoints

| Method | Endpoint          | Description                |
| ------ | ----------------- | -------------------------- |
| GET    | /employees        | List employees (paginated) |
| GET    | /employees/{id}   | Get employee by ID         |
| POST   | /employees        | Create employees           |
| PUT    | /employees/{id}   | Update employee            |
| DELETE | /employees/{id}   | Delete employee            |
| GET    | /employees/search | Search employees by name   |

---

## Example Request

POST /employees

```json
[
  {
    "firstName": "Juan",
    "secondName": "Carlos",
    "fatherLastName": "Perez",
    "motherLastName": "Lopez",
    "gender": "MALE",
    "bornDate": "1995-10-20",
    "position": "Developer"
  }
]
```

---

## Logging

Application logs are stored in:

```
logs/employee-service.log
```

Log configuration is managed via `application.properties`.

---

## Running with Docker

Build the image:

```bash
docker build -t employee-service .
```

Run the container:

```bash
docker run -p 9090:9090 employee-service
```

Swagger will be available at:

```
http://localhost:9090/swagger-ui/index.html
```