# 🏥 Hospital Resource Management System (Middleware-Based EAI)

A real-time hospital management system designed for efficient coordination of COVID-related resources (beds, oxygen) using a microservices architecture and Enterprise Application Integration (EAI) principles.

---

## 👩‍💻 Author -- **Trina Sikdar**

---

## 🚀 Objective

To design and implement a **real-time, middleware-based system** that streamlines communication between hospitals and external supply chain services like suppliers, retailers, and shippers.

---

## 🧠 Use Case

COVID-19 resource management — handling dynamic requests from hospitals for beds and oxygen, while integrating with external service providers in real time.

---

## 🛠️ Technologies Used

- Java 17
- Spring Boot 3.2.5
- Spring Security 6
- REST APIs
- Maven
- Postman / curl for API testing

---

## 🏗️ System Architecture

```plaintext
Client (Hospital)
     ↓
HospitalController → MiddlewareService
     ↓                ↙        ↘
SupplierService   RetailerService
                     ↓
               ShipperService
````

* `MiddlewareService`: Acts as the central EAI hub and routing/orchestration layer.
* `SupplierService`: First source for bed/oxygen resources.
* `RetailerService`: Fallback supplier if the primary source is unavailable.
* `ShipperService`: Handles delivery logistics to the hospital.

---

## 🔁 Request Routing Logic

1. `HospitalController` receives requests.
2. `MiddlewareService` checks availability with `SupplierService`.
3. If resources are available:

   * Request is dispatched to `ShipperService`.
4. If not:

   * Fallback to `RetailerService`.
5. Status is returned to the client.

---

## 🔐 Security Features

* Spring Security 6 using `SecurityFilterChain`
* HTTP Basic Authentication:

  * Username: `admin`
  * Password: `password`
* Stateless APIs with no session management
* CSRF disabled (safe for REST APIs)

---

## 🔎 API Endpoints

### 📥 Request Bed

```
POST /hospital/request-bed
```

**Request Body:**

```json
{
  "patientName": "Alice",
  "bedsNeeded": 2,
  "hospitalId": "HOSP123"
}
```

**Response Examples:**

* ✅ Success: `Beds shipped via supplier for: Alice`
* 🔁 Fallback: `Beds procured from retailer and shipped for: Mike`
* ❌ Failure: `Beds unavailable for: Xeon`

---

### 📥 Request Oxygen

```
POST /hospital/request-oxygen
```

**Request Body:**

```json
{
  "patientName": "Bob",
  "oxygenCylindersNeeded": 3,
  "hospitalId": "HOSP456"
}
```

**Response Examples:**

* ✅ Success: `Oxygen shipped via supplier for: Bob`
* 🔁 Fallback: `Oxygen procured from retailer and shipped for: Ryan`
* ❌ Failure: `Oxygen unavailable for: Bliss`

---

## 🔒 Security Configuration Example (Spring Security)

```java
@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
        .httpBasic(Customizer.withDefaults());
    return http.build();
}
```

```java
@Bean
public UserDetailsService users() {
    UserDetails user = User
        .withUsername("admin")
        .password("{noop}password")
        .roles("USER")
        .build();
    return new InMemoryUserDetailsManager(user);
}
```

---

## 🌩️ Cloud Readiness

* Docker-ready microservices
* Can be deployed to AWS/GCP/Azure
* Integrates easily with messaging systems (Kafka, SQS, etc.)
* Supports centralized monitoring (e.g., ELK, CloudWatch)

---

## 📈 Scalability & Future Scope

* Docker containerization for each service
* Asynchronous messaging for scalability
* Central logging and monitoring
* Dashboard for real-time hospital request tracking
* Database-backed inventory system

---

## ✅ Key Learnings

* Applied EAI architecture for real-time microservice integration
* Implemented Spring Security 6 with modern `SecurityFilterChain`
* Built stateless, secure APIs with fallback logic
* Deployed a real-world use case of middleware for healthcare

---

## 📚 Interview STAR Story Summary

* **Situation**: Hospitals lacked a streamlined way to request critical COVID resources.
* **Task**: Build a real-time system to manage beds and oxygen requests from multiple hospitals.
* **Action**: Developed a microservice app with a middleware layer that intelligently routes requests and uses fallbacks.
* **Result**: Built a secure, scalable solution ready for cloud deployment with real-time response handling.

---

## DEMO Screenshots

![System Architecture](Demo\system-architecture.png)
![Successful - Bed Request](Demo\successful_bed_request.png)
![Fallback - Bed Request](Demo\fallback_bed_request.png)
![Failure - Bed Request](Demo\failure_bed_request.png)
![Successful - Oxygen Request](Demo\successful_oxygen_request.png)
![Fallback - Oxygen Request](Demo\fallback_oxygen_request.png)
![Failure - Oxygen Request](Demo\failure_oxygen_request.png)

---

## 📎 License

This project is part of an academic assignment and intended for educational purposes.