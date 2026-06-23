Dependency Injection Demo (Java)

Files:
- src/com/example/di/Customer.java
- src/com/example/di/CustomerRepository.java
- src/com/example/di/InMemoryCustomerRepository.java
- src/com/example/di/CustomerService.java
- src/com/example/di/Main.java

Compile and run (from project root):

```powershell
javac -d out src/com/example/di/*.java
java -cp out com.example.di.Main
```

This demonstrates constructor-based dependency injection: `CustomerService` receives a `CustomerRepository` implementation via its constructor.
