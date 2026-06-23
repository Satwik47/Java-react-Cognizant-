public class EmployeeManagement {
    private Employee[] employees;
    private int count;

    public EmployeeManagement(int size) {
        employees = new Employee[size];
        count = 0;
    }

   
    public void addEmployee(Employee emp) {
        if (count < employees.length) {
            employees[count] = emp;
            count++;
            System.out.println("Employee Added Successfully.");
        }
        else {
            System.out.println("Array is Full.");
        }
    }

  
    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

 
    public void traverseEmployees() {
        System.out.println("\nEmployee Records:");
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    
    public void deleteEmployee(int employeeId) {
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == employeeId) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Employee Not Found.");
            return;
        }
        for (int i = index; i < count - 1; i++) {
            employees[i] = employees[i + 1];
        }
        employees[count - 1] = null;
        count--;
        System.out.println("Employee Deleted Successfully.");
    }

    public static void main(String[] args) {
        EmployeeManagement ems =
                new EmployeeManagement(10);
        Employee e1 =
                new Employee(
                        101,
                        "Satwik",
                        "Software Engineer",
                        50000);
        Employee e2 =
                new Employee(
                        102,
                        "Rahul",
                        "Tester",
                        40000);
        Employee e3 =
                new Employee(
                        103,
                        "Priya",
                        "Manager",
                        70000);
       
        System.out.println("ADDING EMPLOYEES");
        ems.addEmployee(e1);
        ems.addEmployee(e2);
        ems.addEmployee(e3);
        ems.traverseEmployees();
   
        System.out.println("\nSEARCH EMPLOYEE");
        Employee result =
                ems.searchEmployee(102);
        if(result != null) {
            System.out.println("Employee Found:");
            System.out.println(result);
        }
        else {
            System.out.println("Employee Not Found.");
        }
      
        System.out.println("\nDELETE EMPLOYEE");
        ems.deleteEmployee(102);
        ems.traverseEmployees();
    }
}
