#  Flower Delivery Service (Spring Boot + JPA + H2)

This is a backend Java application for managing a flower delivery service. It uses **Spring Boot**, **JPA/Hibernate**, and an in-memory **H2 database** to handle plants, deliveries, and custom repository queries.

---

## 🚀 Features

- 🌿 Store and retrieve plant data by price
- 🚚 Track whether a delivery has been completed
- 🧪 Unit-tested with `@DataJpaTest` using H2 in-memory DB
- 🛠 Ready for RESTful API or frontend integration

---

## 🧰 Tech Stack

- Java 17+
- Spring Boot
- Spring Data JPA
- H2 Database
- Maven
- JUnit 5

---

## 📁 Project Structure
src/
└── main/
├── java/
│ └── com.example.flower_delivery/
│ ├── entity/
│ ├── repository/
│ └── service/
└── resources/
├── application.properties
├── schema.sql
└── data.sql
└── test/
└── FlowerDeliveryServiceApplicationTests.java

## Run the app
- Open FlowerDeliveryServiceApplication.java
- Click ▶️ to run
- App runs on port 8080 (even though there are no controllers yet)

Functional backend with entities, repositories, and test coverage  

## 🔧 Note: No REST controllers are implemented yet
