package EI_Exercise1.virtualclassroom;

import java.util.*;

public class VirtualClassroomManager {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<String, Classroom> classrooms = new HashMap<>();

    public static void main(String[] args) {
        while (true) {
            System.out.print("Enter command: ");
            String input = scanner.nextLine();
            String[] command = input.split(" ", 2);

            try {
                switch (command[0]) {
                    case "add_classroom":
                        addClassroom(command[1]);
                        break;
                    case "add_student":
                        addStudent(command[1]);
                        break;
                    case "schedule_assignment":
                        scheduleAssignment(command[1]);
                        break;
                    case "submit_assignment":
                        submitAssignment(command[1]);
                        break;
                    case "list_classrooms":
                        listClassrooms();
                        break;
                    case "list_students":
                        listStudents(command[1]);
                        break;
                    case "exit":
                        System.out.println("Exiting Virtual Classroom Manager.");
                        return;
                    default:
                        System.out.println("Invalid command. Please try again.");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid command format. Please provide the necessary arguments.");
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }

    private static void addClassroom(String className) {
        if (classrooms.containsKey(className)) {
            System.out.println("Classroom " + className + " already exists.");
        } else {
            classrooms.put(className, new Classroom(className));
            System.out.println("Classroom " + className + " has been created.");
        }
    }

    private static void addStudent(String input) {
        String[] parts = input.split(" ");
        String studentId = parts[0];
        String className = parts[1];

        Classroom classroom = classrooms.get(className);
        if (classroom != null) {
            classroom.addStudent(new Student(studentId));
            System.out.println("Student " + studentId + " has been enrolled in " + className + ".");
        } else {
            System.out.println("Classroom " + className + " does not exist.");
        }
    }

    private static void scheduleAssignment(String input) {
        String[] parts = input.split(" ", 2);
        String className = parts[0];
        String assignmentDetails = parts[1];

        Classroom classroom = classrooms.get(className);
        if (classroom != null) {
            classroom.scheduleAssignment(new Assignment(assignmentDetails));
            System.out.println("Assignment for " + className + " has been scheduled.");
        } else {
            System.out.println("Classroom " + className + " does not exist.");
        }
    }

    private static void submitAssignment(String input) {
        String[] parts = input.split(" ", 3);
        String studentId = parts[0];
        String className = parts[1];
        String assignmentDetails = parts[2];

        Classroom classroom = classrooms.get(className);
        if (classroom != null) {
            Student student = classroom.getStudent(studentId);
            if (student != null) {
                student.submitAssignment(new Assignment(assignmentDetails));
                System.out.println("Assignment submitted by Student " + studentId + " in " + className + ".");
            } else {
                System.out.println("Student " + studentId + " is not enrolled in " + className + ".");
            }
        } else {
            System.out.println("Classroom " + className + " does not exist.");
        }
    }

    private static void listClassrooms() {
        if (classrooms.isEmpty()) {
            System.out.println("No classrooms available.");
        } else {
            System.out.println("List of classrooms:");
            classrooms.keySet().forEach(System.out::println);
        }
    }

    private static void listStudents(String className) {
        Classroom classroom = classrooms.get(className);
        if (classroom != null) {
            if (classroom.getStudents().isEmpty()) {
                System.out.println("No students enrolled in " + className + ".");
            } else {
                System.out.println("List of students in " + className + ":");
                classroom.getStudents().forEach(student -> System.out.println(student.getId()));
            }
        } else {
            System.out.println("Classroom " + className + " does not exist.");
        }
    }
}
