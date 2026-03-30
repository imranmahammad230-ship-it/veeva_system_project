# 🐾 PetStore API Automation Framework

## 📌 Overview

This project automates testing of the PetStore API using a BDD framework.
It validates CRUD operations, status codes, and cross-endpoint data consistency.

---

## 🛠️ Tech Stack

* Java
* Rest Assured
* Cucumber (BDD)
* TestNG
* Maven
* Postman

---

## 📂 Project Structure

```
src/test/java
 ├── client
 ├── stepdefinitions
 ├── utils

src/test/resources
 └── features
```

---

## ✅ Test Coverage

### 🔹 CRUD Operations

* Create Pet → POST /pet
* Get Pet → GET /pet/{id}
* Update Pet → PUT /pet
* Delete Pet → DELETE /pet/{id}

---

### 🔹 Cross Endpoint Validation

* Create a pet with specific category
* Update pet status (available → sold)
* Verify in:

  * /store/inventory
  * /pet/findByStatus
* Validate created Pet ID exists in sold list

---

### 🔹 Status Code Validation

* 200 → Success
* 404 → Not Found
* 400/405 → Invalid Request

---

## ▶️ How to Run

Run tests using:

```
mvn clean test
```

---

## 📊 Validations Performed

* Status code checks
* Response body validation
* Pet lifecycle validation
* Cross endpoint consistency

---

## 📮 Postman Tasks Covered

* GET /pet/findByStatus
* POST /pet
* Status validation
* Environment variables

---

## 📌 Key Highlights

* Dynamic pet ID handling
* Separate feature files
* Modular step definitions
* Clean framework structure

---

## 🚀 Future Enhancements

* Reporting (Extent Reports)
* CI/CD integration
* Data-driven testing

---
