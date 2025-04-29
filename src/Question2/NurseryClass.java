package Question2;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

abstract class NurseryClass {
    protected String classId;
    protected String className;
    protected int maxCapacity;
    protected Teacher assignedTeacher;
    protected List<Student> students;
    protected List<String> conductedActivities;
    protected String progressNotes;

    public NurseryClass(String classId, String className, int maxCapacity) {
        this.classId = classId;
        this.className = className;
        this.maxCapacity = maxCapacity;
        this.students = new ArrayList<>();
        this.conductedActivities = new ArrayList<>();
        this.progressNotes = "";
    }

    // Getters and setters
    public String getClassId() {
        return classId;
    }

    public String getClassName() {
        return className;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public Teacher getAssignedTeacher() {
        return assignedTeacher;
    }

    public void setAssignedTeacher(Teacher teacher) {
        if (validateTeacher(teacher)) {
            this.assignedTeacher = teacher;
            teacher.setAssignedClass(this);
        } else {
            throw new IllegalArgumentException("Teacher " + teacher.getTeacherName() +
                    " cannot be assigned to " + className);
        }
    }

    public List<Student> getStudents() {
        return students;
    }

    // Abstract methods to be implemented by concrete classes
    public abstract boolean enrollStudent(Student student);
    public abstract void trackProgress();
    public abstract void conductActivity(String activityName);
    public abstract String generateClassReport();

    // Method to validate if a teacher can be assigned to this class
    protected abstract boolean validateTeacher(Teacher teacher);

    // Helper method to check if student is already enrolled in any class
    protected boolean isStudentEnrolledElsewhere(Student student) {
        return student.getRegisteredClass() != null;
    }

    // Helper method to check if student ID already exists in this class
    protected boolean hasStudentId(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return true;
            }
        }
        return false;
    }
}
