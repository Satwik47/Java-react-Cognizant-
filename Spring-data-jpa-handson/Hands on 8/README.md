# Hands-on 8: Update a Country Based on Code

## Project Overview
This Spring Boot application demonstrates how to update a country record in the database using Spring Data JPA and Hibernate.

## Project Structure
```
OrmLearn
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.cognizant.ormlearn
│   │   │       ├── model
│   │   │       │   └── Country.java
│   │   │       ├── repository
│   │   │       │   └── CountryRepository.java
│   │   │       ├── service
│   │   │       │   └── CountryService.java
│   │   │       └── OrmLearnApplication.java
│   │   └── resources
│   │       └── application.properties
└── pom.xml
```

## Prerequisites
- Java 17 or higher
- Maven 3.6+
- MySQL 8.0+
- Database named `ormlearn` with `country` table

## Database Setup

Create the database and table in MySQL:

```sql
CREATE DATABASE ormlearn;

USE ormlearn;

CREATE TABLE country (
    co_code VARCHAR(10) PRIMARY KEY,
    co_name VARCHAR(100) NOT NULL
);

-- Insert sample data
INSERT INTO country (co_code, co_name) VALUES ('IN', 'India');
INSERT INTO country (co_code, co_name) VALUES ('US', 'United States');
```

## Configuration

Update `application.properties` with your MySQL credentials:
```properties
spring.datasource.username=root
spring.datasource.password=your_password
```

## Running the Application

1. Build the project:
```bash
mvn clean install
```

2. Run the application:
```bash
mvn spring-boot:run
```

Or run the `OrmLearnApplication.java` file directly from your IDE.

## Expected Output

### Console Output:
```
----- Before Update -----
Country [code=IN, name=India]

Hibernate:
select
c1_0.co_code,
c1_0.co_name
from country c1_0
where c1_0.co_code=?

Hibernate:
update
country
set
co_name=?
where
co_code=?

----- After Update -----
Country [code=IN, name=Republic of India]
```

### Database Verification:
```sql
SELECT * FROM country;
```

**Output:**
```
co_code    co_name
IN         Republic of India
US         United States
```

## Key Components

### Country.java
Entity class mapped to the `country` table with `co_code` as primary key.

### CountryRepository.java
JPA Repository interface extending `JpaRepository<Country, String>`.

### CountryService.java
Service class with transaction management:
- `findCountryByCode()`: Find country by code
- `addCountry()`: Add new country
- `updateCountry()`: Update existing country name (Hands-on 8)

### OrmLearnApplication.java
Main application class that implements `CommandLineRunner` to test the update functionality on startup.
