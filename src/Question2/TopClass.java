package Question2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class TopClass extends NurseryClass {
    private static final int MIN_AGE = 4;
    private static final int MAX_AGE = 5;
    private List<String> assessments;

    public TopClass(String classId) {
        super(classId, "Top Class", 25);
        this.assessments = new ArrayList<>();
        this.conductedActivities = new ArrayList<>(); // Initialize conducted activities
        this.progressNotes = ""; // Initialize progress notes
    }

    @Override
    public boolean enrollStudent(Student student) {
        // Validate age
        if (student.getAge() < MIN_AGE || student.getAge() > MAX_AGE) {
            System.out.println("Student " + student.getStudentName() +
                    " does not meet age requirements for Top Class (4-5 years).");
            return false;
        }
        // Check capacity
        if (getStudents().size() >= maxCapacity) { // Use getter instead of direct access
            System.out.println("Top Class has reached maximum capacity. Cannot enroll more students.");
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
        System.out.println("Student " + student.getStudentName() + " enrolled in Top Class successfully.");
        return true;
    }

    @Override
    public void trackProgress() {
        if (progressNotes == null) {
            progressNotes = ""; // Initialize progressNotes if it's null
        }
        progressNotes += "Top Class Progress [" + new Date() + "]: Preparing for primary school with basic reading, writing, and arithmetic. ";
        System.out.println("Tracking progress for Top Class students...");
    }

    @Override
    public void conductActivity(String activityName) {
        conductedActivities.add(activityName);
        System.out.println("Top Class conducted activity: " + activityName);
    }

    public void conductAssessment(String termName) {
        String assessment = "Assessment conducted for " + termName + " on " + new Date();
        assessments.add(assessment);
        System.out.println(assessment);
    }

    @Override
    public String generateClassReport() {
        StringBuilder report = new StringBuilder();
        report.append("===== TOP CLASS REPORT =====\n");
        report.append("Class ID: ").append(classId).append("\n");
        report.append("Teacher: ").append(assignedTeacher != null ?
                assignedTeacher.getTeacherName() : "Not Assigned").append("\n");
        report.append("Number of students: ").append(getStudents().size()).append("/").append(maxCapacity).append("\n");
        report.append("Activities conducted: \n");
        for (String activity : conductedActivities) {
            report.append(" - ").append(activity).append("\n");
        }
        report.append("Assessments: \n");
        for (String assessment : assessments) {
            report.append(" - ").append(assessment).append("\n");
        }
        report.append("Progress Notes: ").append(progressNotes).append("\n");
        report.append("===========================\n");
        return report.toString();
    }

    @Override
    protected boolean validateTeacher(Teacher teacher) {
        // Top class can have any teacher
        return true;
    }
}