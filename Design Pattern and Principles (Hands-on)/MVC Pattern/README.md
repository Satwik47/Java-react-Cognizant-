Exercise 10: MVC Pattern Java Demo

Files created:
- `src/mvc/model/Student.java`
- `src/mvc/view/StudentView.java`
- `src/mvc/controller/StudentController.java`
- `src/mvc/Main.java`

To compile and run (Windows PowerShell):

```powershell
javac -d out src/mvc/model/Student.java src/mvc/view/StudentView.java src/mvc/controller/StudentController.java src/mvc/Main.java
java -cp out mvc.Main
```

This prints a short demo of adding, updating, listing, and removing students.
