# Product Management API (DDD Architecture)

This is a **Product Management RESTful API** built with **Spring Boot** using **Domain-Driven Design (DDD)** principles. The application manages **Product** and **Category** entities, allowing users to create, update, delete, and retrieve product information.

## Table of Contents
- [Overview](#overview)
- [Architecture](#architecture)
- [Entities](#entities)
- [Endpoints](#endpoints)
- [Getting Started](#getting-started)
- [Running the Application with IntelliJ IDEA](#running-the-application-with-intellij-idea)
- [Configuring the H2 Database Console](#configuring-the-h2-database-console)
- [Postman Collection](#postman-collection)

## Overview

The application provides a REST API for managing products and categories in an eCommerce platform. The architecture follows DDD principles, keeping business logic, domain models, and infrastructure concerns separate for maintainability and scalability.

Key features include:
- **CRUD Operations** for products and categories
- **Validation** for product data (e.g., price must be positive, stock cannot be negative)
- **H2 In-Memory Database** for persistence
- **Global Exception Handling**
- **Pagination**

## Architecture

The application is structured following the **Domain-Driven Design (DDD)** architecture, which focuses on the separation of concerns across different layers:

1. **Domain Layer**
    - Contains the business logic and domain models (e.g., `Product`, `Category`).
    - Implements domain rules (e.g., price must be positive, unique product names).

2. **Application Layer**
    - Contains services (e.g., `ProductService`, `CategoryService`) that orchestrate the application's use cases by coordinating between the domain and infrastructure layers.

3. **Infrastructure Layer**
    - Manages data persistence using Spring Data JPA.
    - Includes repository interfaces (e.g., `ProductRepository`, `CategoryRepository`) that abstract database interactions.

4. **Web Layer**
    - Contains RESTful controllers (`ProductController`, `CategoryController`) that expose the API endpoints.

## Entities

### 1. **Product**
Represents a product in the system. Each product belongs to a category.

Attributes:
- `id` (auto-generated)
- `name` (required, unique)
- `description` (optional)
- `price` (required, must be positive)
- `stockQuantity` (required, non-negative)
- `category` (required)
- `createdAt`, `updatedAt` (auto-generated timestamps)

### 2. **Category**
Represents a product category. Products are associated with categories.

Attributes:
- `id` (auto-generated)
- `name` (required, unique)

## Endpoints

### Product Endpoints
- `GET /products` – Retrieve all products.
- `GET /products/{id}` – Retrieve a product by its ID.
- `POST /products` – Create a new product.
- `PUT /products/{id}` – Update a product by ID.
- `DELETE /products/{id}` – Delete a product by ID.
- `PATCH /products/{id}/update-stock` – Update the stock quantity of a product.

### Category Endpoints
- `GET /categories` – Retrieve all categories.
- `GET /categories/{id}` – Retrieve a category by ID.
- `POST /categories` – Create a new category.
- `PUT /categories/{id}` – Update a category by ID.
- `DELETE /categories/{id}` – Delete a category by ID.

## Getting Started

### Prerequisites
- **Java 17** or higher
- **IntelliJ IDEA** (or another IDE)
- **H2 Database Console Configuration** (see [Configuring the H2 Database Console](#configuring-the-h2-database-console))

### Clone the repository
```bash
git clone https://github.com/ShubratoDn/DDD_ProductManagement.git
```

## Running the Application with IntelliJ IDEA

Follow these steps to run the application in **IntelliJ IDEA**:

1. **Import the Project:**
   - Open IntelliJ IDEA.
   - Go to `File > Open` and select the root directory of your project (`product-management-ddd`).
   - IntelliJ will automatically detect the Maven project and import the necessary dependencies.

2. **Run the Application:**
   - Open `ProductManagementApplication.java`.
   - Right-click inside the class and select `Run ProductManagementApplication.main()`.
   - IntelliJ will compile the project and run the Spring Boot application.

3. **Access the API:**
   - Once the application is running, you can access the API at `http://localhost:8080`.

4. **Access the H2 Console:**
   - Go to `http://localhost:8080/h2-console` to access the H2 in-memory database (see detailed configuration in the [H2 Console Configuration](#configuring-the-h2-database-console) section below).


## Configuring the H2 Database Console
To configure the H2 Database Console properly, follow these steps:

Create a Blank ``test.mv.db`` File:

 - Go to the following location on your machine:
Windows: ``C:\Users\your-user-name\``

### H2 Console Configuration:

  - Once the blank test.mv.db file is created, start the Spring Boot application.
 - Open the H2 Console in your browser at http://localhost:8080/h2-console.
 - Use the following configuration to log into the H2 database:
``` JDBC URL: jdbc:h2:mem:testdb
Username: sa
Password: password
```
You should now be able to access and query the database via the H2 Console.

## Postman Collection

A Postman collection for the Product Management API has been included to help you test the endpoints easily. You can import the JSON file into Postman to access predefined requests for all available endpoints.

- **Postman Collection**: [Postman Collection JSON](https://github.com/ShubratoDn/DDD_ProductManagement/blob/master/DDD_ProductManagement.postman_collection.json)
