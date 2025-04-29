package Question2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class BabyClass extends NurseryClass {
    private static final int MIN_AGE = 2;
    private static final int MAX_AGE = 3;

    public BabyClass(String classId) {
        super(classId, "Baby Class", 15);
        this.students = new ArrayList<>(); // Initialize the students list
        this.conductedActivities = new ArrayList<>(); // Initialize conducted activities
        this.progressNotes = ""; // Initialize progress notes
    }

    @Override
    public boolean enrollStudent(Student student) {
        // Validate age
        if (student.getAge() < MIN_AGE || student.getAge() > MAX_AGE) {
            System.out.println("Student " + student.getStudentName() +
                    " does not meet age requirements for Baby Class (2-3 years).");
            return false;
        }
        // Check capacity
        if (students.size() >= maxCapacity) {
            System.out.println("Baby Class has reached maximum capacity. Cannot enroll more students.");
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
        students.add(student);
        student.setRegisteredClass(this);
        System.out.println("Student " + student.getStudentName() + " enrolled in Baby Class successfully.");
        return true;
    }

    @Override
    public void trackProgress() {
        if (progressNotes == null) {
            progressNotes = ""; // Initialize progressNotes if it's null
        }
        progressNotes += "Baby Class Progress [" + new Date() + "]: Focusing on motor skills and play-based learning. ";
        System.out.println("Tracking progress for Baby Class students...");
    }

    @Override
    public void conductActivity(String activityName) {
        conductedActivities.add(activityName);
        System.out.println("Baby Class conducted activity: " + activityName);
    }

    @Override
    public String generateClassReport() {
        StringBuilder report = new StringBuilder();
        report.append("===== BABY CLASS REPORT =====\n");
        report.append("Class ID: ").append(classId).append("\n");
        report.append("Teacher: ").append(assignedTeacher != null ?
                assignedTeacher.getTeacherName() : "Not Assigned").append("\n");
        report.append("Number of students: ").append(students.size()).append("/").append(maxCapacity).append("\n");
        report.append("Activities conducted: \n");
        for (String activity : conductedActivities) {
            report.append(" - ").append(activity).append("\n");
        }
        report.append("Progress Notes: ").append(progressNotes).append("\n");
        report.append("============================\n");
        return report.toString();
    }

    @Override
    protected boolean validateTeacher(Teacher teacher) {
        return "Early Childhood Educator".equals(teacher.getTeacherRole());
    }
}