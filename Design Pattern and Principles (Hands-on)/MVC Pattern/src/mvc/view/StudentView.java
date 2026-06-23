package mvc.view;

import mvc.model.Student;
import java.util.List;

public class StudentView {
    public void printStudentDetails(Student student) {
        System.out.println("Student Details: " + student);
    }

    public void printStudentList(List<Student> students) {
        System.out.println("--- Student List ---");
        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println("--------------------");
    }
}
