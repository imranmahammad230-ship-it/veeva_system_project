# 🐾 Precision API BDD Automation Framework

## 📌 Overview

This project is a BDD-based API Automation Framework developed using Java, REST Assured, and Cucumber. It automates testing of REST APIs provided by the PetStore Swagger service. The framework is designed with a modular and reusable structure to ensure scalability and maintainability.


---

## 🛠️ Tech Stack

•	Language: Java 
•	Library: REST Assured 
•	BDD Framework: Cucumber 
•	Build & Dependency Management: Maven 
•	Prototyping & Manual Testing: Postman 
•	Version Control: Git & GitHub 
•	Logging: Log4j 
•	IDE: IntelliJ IDEA


---

## 📂 Project Structure

```
src/test/java
|  |
|   base
|    |------BaseTest.java
|   client
|    |------PetStoreClient.java
|   runners 
|    |------TestRunner.java
|   stepdefinitions
|    |-------CrossEndPointSteps.java
|    |-------InventorySteps.java
|    |-------PetSteps.java
|    |-------UserSteps.java
|   utils
|    |-------ConfigReader.java
|    |-------TestContext.java
|    |-------TestDataBuilder.java
resources  
|    |-----features
|    |      |------crossendpoint.feature
|    |      |------inventory.feature
|    |      |------pet.feature
|    |      |------user.feature
|    |-----payloads
|    |      |------createPet.json
|    |      |------config.properties
pom.xml


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

Run the framework using:

```
mvn clean test
```
This will execute all scenarios and generate reports in the target folder.
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
