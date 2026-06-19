# User Management System (Servlet + JDBC + PostgreSQL)

## Overview

A Java-based User Management System built using Servlets, JSP, JDBC, and PostgreSQL. The application demonstrates core backend development concepts such as CRUD operations, authentication, session management, input validation, database connectivity, search functionality, and password hashing.

This project was built to strengthen understanding of Java EE fundamentals and database-driven web application development.

---

## Features

### Authentication & Security

* Admin Login
* Session Management using HttpSession
* Route Protection using Servlet Filters
* Password Hashing using SHA-256
* Logout Functionality

### User Management

* Create User
* View All Users
* Update User
* Delete User

### Additional Functionality

* Search Users by Name or Email
* Server-Side Validation
* Duplicate Email Prevention

---

## Tech Stack

### Backend

* Java
* Servlets
* JSP
* JDBC

### Database

* PostgreSQL

### Server

* Apache Tomcat 10

### Development Tools

* Eclipse IDE
* pgAdmin

---

## Project Structure

```text
src
│
├── controller
│   ├── UserServlet
│   ├── InsertUserServlet
│   ├── UpdateUserServlet
│   ├── DeleteUserServlet
│   ├── LoginServlet
│   └── SearchUserServlet
│
├── dao
│   └── UserDAO
│
├── filter
│   └── AuthFilter
│
├── model
│   └── UserModel
│
└── util
    ├── DBConnection
    ├── ValidationUtil
    └── PasswordUtil

webapp
│
├── login.jsp
├── user-list.jsp
├── add-user.jsp
├── edit-user.jsp
└── WEB-INF
```

---

## Database Schema

### users

```sql
CREATE TABLE users(
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    age INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

### admins

```sql
CREATE TABLE admins(
    id SERIAL PRIMARY KEY,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);
```

---

## Setup Instructions

### 1. Clone Repository

```bash
git clone <repository-url>
```

### 2. Create PostgreSQL Database

```sql
CREATE DATABASE user_management;
```

### 3. Create Required Tables

Run the SQL scripts provided above.

### 4. Configure Database Credentials

Update database credentials in:

```java
DBConnection.java
```

Example:

```java
private static final String URL =
        "jdbc:postgresql://localhost:5432/user_management";

private static final String USERNAME =
        "postgres";

private static final String PASSWORD =
        "YOUR_PASSWORD";
```

### 5. Add PostgreSQL JDBC Driver

Download the PostgreSQL JDBC Driver and place it in:

```text
WEB-INF/lib
```

### 6. Deploy on Tomcat

* Configure Apache Tomcat 10 in Eclipse
* Run the project on server

### 7. Access Application

```text
http://localhost:8080/UserManagementSystem/login.jsp
```

---

## Concepts Practiced

* Servlet Lifecycle
* RequestDispatcher
* HTTP Methods (GET, POST)
* JDBC Connectivity
* PreparedStatement
* SQL CRUD Operations
* Authentication & Authorization
* Session Management
* Servlet Filters
* Input Validation
* Search Functionality
* Password Hashing
* MVC Architecture

---

## Future Improvements

* Service Layer Architecture
* JSTL and EL
* BCrypt Password Hashing
* Exception Handling Framework
* Spring Boot Migration
* Spring Security
* REST APIs
* React Frontend
* Role-Based Access Control

---

## Author

Anupam Mishra

GitHub: https://github.com/1nup-AM

LinkedIn: https://www.linkedin.com/in/1nup-am
