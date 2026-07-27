CTRL + V
# Student Management System

A full-stack web application built using Java Spring Boot and React.

## Live Application

Frontend:
https://YOUR_FRONTEND_URL

Backend:
https://student-management-backend-28fq.onrender.com


## Tech Stack

### Backend
- Java 21
- Spring Boot 3.5
- Spring Data JPA
- Spring Security
- JWT Authentication
- Hibernate
- PostgreSQL

### Frontend
- React
- Vite
- Axios
- React Router

### Deployment
- Docker
- Render
- PostgreSQL


## Features

### Authentication
- User Registration
- User Login
- JWT based authentication
- Password encryption using BCrypt


### Student Management

- Add student
- View students
- Update student
- Delete student


## Architecture

```
React Frontend
       |
       |
 REST API + JWT
       |
       |
Spring Boot Backend
       |
       |
PostgreSQL Database
```## API Endpoints

### Authentication

Register:

POST /auth/register

Login:

POST /auth/login


### Student APIs

Get Students:

GET /students

Add Student:

POST /students

Update Student:

PUT /students/{id}

Delete Student:

DELETE /students/{id}
## Running Locally

### Backend

Run:

./mvnw spring-boot:run


### Frontend

Install:

npm install

Start:

npm run dev

## Deployment

Backend:
- Spring Boot application deployed using Docker on Render

Frontend:
- React application deployed as Static Site on Render

Database:
- PostgreSQL hosted on Render

