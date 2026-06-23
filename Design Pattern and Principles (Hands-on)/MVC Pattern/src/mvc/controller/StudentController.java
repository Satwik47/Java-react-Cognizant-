package mvc.controller;

import mvc.model.Student;
import mvc.view.StudentView;

import java.util.ArrayList;
import java.util.List;

public class StudentController {
    private StudentView view;
    private final List<Student> students = new ArrayList<>();

    public StudentController(StudentView view) {
        this.view = view;
    }

    public void addStudent(int id, String name, int age) {
        students.add(new Student(id, name, age));
    }

    public boolean removeStudentById(int id) {
        return students.removeIf(s -> s.getId() == id);
    }

    public boolean updateStudent(int id, String name, int age) {
        for (Student s : students) {
            if (s.getId() == id) {
                s.setName(name);
                s.setAge(age);
                return true;
            }
        }
        return false;
    }

    public Student getStudentById(int id) {
        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    public void listAllStudents() {
        view.printStudentList(students);
    }

    public void showStudent(int id) {
        Student s = getStudentById(id);
        if (s != null) view.printStudentDetails(s);
        else System.out.println("Student with id " + id + " not found.");
    }
}
