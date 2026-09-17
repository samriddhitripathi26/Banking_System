## 📌 Retail Online Banking

**Description:**
Retail Online Banking is a web-based application that allows customers to manage their banking activities online. The system offers secure features like viewing account balances, transferring funds, viewing transaction history, and managing personal profiles. Built with Java and Spring Boot, the application ensures performance, security, and scalability.

---

### 🔧 Technologies Used

* **Language:** Java
* **Frameworks:** Spring Boot, Spring Data JPA, Spring Security
* **Database:** MySQL
* **ORM:** Hibernate
* **Build Tool:** Maven
* **Logging:** Log4j
* **Version Control:** Git
* **API Style:** RESTful APIs

---

### 🧩 Features

* User Authentication and Authorization (Spring Security)
* Account Summary and Transaction Details
* Fund Transfer between Accounts
* Bill Payment Integration
* Error Handling and Logging
* Secure and Responsive Backend APIs

---

### 🛠️ Modules

* **User Module** – Registration, Login, Profile Management
* **Account Module** – View account details and transaction history
* **Transfer Module** – Fund transfers between own or third-party accounts
* **Bill Payment Module** – Pay utility bills through integrated services

---

### 🚀 Getting Started

#### Prerequisites:

* Java 8
* Maven
* MySQL
* Spring Boot
* Log4j
* JWT

#### Steps to Run:

1. Clone the repository:

   ```bash
   git clone https://github.com/yourusername/retail-online-banking.git
   ```
2. Import into your favorite IDE (IntelliJ/Eclipse)
3. Configure MySQL credentials in `application.properties`
4. Run the application:

   ```bash
   mvn spring-boot:run
   ```

---

### 📁 Project Structure

```
Project_BankApplicationForm/
│
├── .mvn/wrapper/                    # Maven wrapper files for consistent builds
│   ├── maven-wrapper.jar
│   └── maven-wrapper.properties
│
├── src/
│   └── main/
│       └── java/
│           └── com/alexa/bank/apps/
│               ├── controller/     # Contains REST controllers (API endpoints)
│               ├── dto/           # Data Transfer Objects used between client and server
│               ├── entity/        # JPA entities mapped to database tables
│               ├── exception/     # Custom exception handling classes
│               ├── repo/          # Spring Data JPA repositories (DAO layer)
│               ├── service/       # Business logic layer (interfaces and implementations)
│               └── ProjectBankAppFormApplication.java  # Main Spring Boot application class
│
├── pom.xml                         # Maven configuration file

---

### 🙋‍♂️ Author

**Samriddhi Tripathi**
Full stack devloper | Passionate about building clean and secure APIs
