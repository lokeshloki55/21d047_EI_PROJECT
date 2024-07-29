package EI_Exercise1.virtualclassroom;

import java.util.*;

public class Student {
    private String id;
    private List<Assignment> submittedAssignments;

    public Student(String id) {
        this.id = id;
        this.submittedAssignments = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void submitAssignment(Assignment assignment) {
        submittedAssignments.add(assignment);
    }
}

