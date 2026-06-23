package mvc;

import mvc.controller.StudentController;
import mvc.view.StudentView;

public class Main {
    public static void main(String[] args) {
        StudentView view = new StudentView();
        StudentController controller = new StudentController(view);

        System.out.println("Adding students...");
        controller.addStudent(1, "Alice", 20);
        controller.addStudent(2, "Bob", 22);
        controller.addStudent(3, "Charlie", 19);

        System.out.println();
        controller.listAllStudents();

        System.out.println("\nUpdating student with id=2...\n");
        controller.updateStudent(2, "Bobby", 23);
        controller.showStudent(2);

        System.out.println("\nRemoving student with id=1...\n");
        controller.removeStudentById(1);
        controller.listAllStudents();
    }
}
