package Question2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class MiddleClass extends NurseryClass {
    private static final int MIN_AGE = 3;
    private static final int MAX_AGE = 4;

    public MiddleClass(String classId) {
        super(classId, "Middle Class", 20);
    }

    @Override
    public boolean enrollStudent(Student student) {
        // Validate age
        if (student.getAge() < MIN_AGE || student.getAge() > MAX_AGE) {
            System.out.println("Student " + student.getStudentName() +
                    " does not meet age requirements for Middle Class (3-4 years).");
            return false;
        }
        // Check capacity
        if (getStudents().size() >= maxCapacity) {  // Use getter instead of direct access
            System.out.println("Middle Class has reached maximum capacity. Cannot enroll more students.");
            return false;
        }
        // Check if student is already enrolled elsewhere
        if (isStudentEnrolledElsewhere(student)) {
            System.out.println("Student " + student.getStudentName() +
                    " is already enrolled in another class.");
            return false;
        }
        // Check for duplicate student ID
        if (hasStudentId(student.getStudentId())) {
            System.out.println("Student ID " + student.getStudentId() + " already exists in this class.");
            return false;
        }
        // If all validations pass, enroll the student
        getStudents().add(student); // Add the student to the list
        student.setRegisteredClass(this); // Set the registered class for the student
        System.out.println("Student " + student.getStudentName() + " enrolled in Middle Class successfully.");
        return true;
    }

    @Override
    public void trackProgress() {
        // Implementation for tracking progress can be added here
        System.out.println("Tracking progress for Middle Class students...");
    }

    @Override
    public void conductActivity(String activityName) {
        // Implementation for conducting activities can be added here
        System.out.println("Middle Class conducted activity: " + activityName);
    }

    @Override
    public String generateClassReport() {
        StringBuilder report = new StringBuilder();
        report.append("===== MIDDLE CLASS REPORT =====\n");
        report.append("Class ID: ").append(classId).append("\n");
        report.append("Teacher: ").append(assignedTeacher != null ?
                assignedTeacher.getTeacherName() : "Not Assigned").append("\n");
        report.append("Number of students: ").append(getStudents().size()).append("/").append(maxCapacity).append("\n");
        report.append("==============================\n");
        return report.toString();
    }

    @Override
    protected boolean validateTeacher(Teacher teacher) {
        return "Early Childhood Educator".equals(teacher.getTeacherRole());
    }
}