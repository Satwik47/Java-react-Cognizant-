# Spring Data JPA - Hands On 1

## Project Setup Instructions

### Step 1: Database Configuration
1. Open MySQL command line client:
   ```
   mysql -u root -p
   ```
2. Execute the SQL commands in `database-setup.sql`:
   ```sql
   CREATE SCHEMA ormlearn;
   CREATE TABLE country(co_code VARCHAR(2) PRIMARY KEY, co_name VARCHAR(50));
   INSERT INTO country VALUES ('IN', 'India');
   INSERT INTO country VALUES ('US', 'United States of America');
   ```

### Step 2: Project Configuration
The `application.properties` file is already configured with:
- MySQL JDBC driver
- Database connection string (localhost:3306/ormlearn)
- Username and password (root/root)
- Hibernate dialect and DDL auto validation
- Logging configuration for Spring, Hibernate, and Application

### Step 3: Project Structure Overview

**Main Application:**
- `OrmLearnApplication.java` - Main Spring Boot application class with test method

**Model:**
- `Country.java` - JPA Entity class mapped to the country table

**Repository:**
- `CountryRepository.java` - JPA Repository extending `JpaRepository<Country, String>`

**Service:**
- `CountryService.java` - Service layer with `getAllCountries()` method

**Test:**
- `OrmLearnApplicationTests.java` - Spring Boot test class

### Step 4: Build the Project
Run the following command in the project root:
```
mvn clean package
```

Or with proxy settings:
```
mvn clean package -Dhttp.proxyHost=proxy.cognizant.com -Dhttp.proxyPort=6050 -Dhttps.proxyHost=proxy.cognizant.com -Dhttps.proxyPort=6050 -Dhttp.proxyUser=123456
```

### Step 5: Run the Application
1. In Eclipse: Right-click on `OrmLearnApplication.java` → Run As → Java Application
2. Or via Maven: `mvn spring-boot:run`

### Key Concepts

**@Entity** - Marks the class as a persistent entity
**@Table** - Specifies the table name in the database
**@Id** - Marks the primary key field
**@Column** - Maps field to database column
**@Repository** - Marks the interface as a Spring repository component
**@Service** - Marks the class as a business logic service component
**@Transactional** - Enables transaction management for the method
**@Autowired** - Spring dependency injection

### Expected Output
When you run the application, you should see logs like:
```
...
20-06-20 14:30:45.123 main INFO OrmLearnApplication : Inside main
20-06-20 14:30:45.234 main INFO CountryService : Start
20-06-20 14:30:45.345 main DEBUG CountryService : countries=[Country [code=IN, name=India], Country [code=US, name=United States of America]]
20-06-20 14:30:45.456 main INFO CountryService : End
```

## Dependencies

- Spring Boot Starter Data JPA
- Spring Boot Starter Web
- Spring Boot DevTools
- MySQL Connector/J 8.0.20
- Spring Boot Starter Test

## Notes

- The `spring.jpa.hibernate.ddl-auto=validate` property ensures that Hibernate validates the database schema without making changes
- Logging levels are set to trace Hibernate SQL execution and show application-level debug logs
- The project uses Java 8 compatibility
