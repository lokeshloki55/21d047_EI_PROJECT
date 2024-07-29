package EI_Exercise1.virtualclassroom;

import java.util.*;

public class Classroom {
    private String name;
    private List<Student> students;
    private List<Assignment> assignments;

    public Classroom(String name) {
        this.name = name;
        this.students = new ArrayList<>();
        this.assignments = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student getStudent(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    public void scheduleAssignment(Assignment assignment) {
        assignments.add(assignment);
    }

    public List<Student> getStudents() {
        return students;
    }
}
