# Strategy Pattern - Payment Example

This simple Java example demonstrates the Strategy Pattern with two payment strategies: Credit Card and PayPal.

Build and run (from project root):

```bash
mkdir -p out
javac -d out src/com/example/**/*.java
java -cp out com.example.Main
```

Expected output:

```
Paying 100 using Credit Card: 1234-5678-9012-3456 (holder: Alice)
Paying 250 using PayPal account: alice@example.com
```
