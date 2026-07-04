# Exercise 9 — Employee Management System (Multi DataSource)

This sample project demonstrates customizing Spring Boot auto-configuration and externalizing configuration to manage multiple data sources (two H2 in-memory DBs).

How to build and run:

1. Build:

```bash
mvn -f "Exercise-9/pom.xml" clean package
```

2. Run:

```bash
java -jar target/employee-management-0.0.1-SNAPSHOT.jar
```

The application will insert one Employee and one Department into separate datasources and print counts to the console.
