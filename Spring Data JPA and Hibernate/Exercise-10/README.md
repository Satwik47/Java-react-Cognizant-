Exercise 10 — Employee Management System (Hibernate-specific features)

Run with Maven:

```powershell
mvn compile exec:java -Dexec.mainClass="com.example.hibernate.App"
```

This project uses Hibernate annotations like `@DynamicInsert`, `@DynamicUpdate`, `@SelectBeforeUpdate`, and `@BatchSize` and configures batching via `hibernate.cfg.xml`.

The program also writes its console output to `output.txt` in the project root.
