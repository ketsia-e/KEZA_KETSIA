package Question2;

class Teacher {
private String teacherId;
private String teacherName;
private String teacherRole;
private NurseryClass assignedClass;

public Teacher(String teacherId, String teacherName, String teacherRole) {
    this.teacherId = teacherId;
    this.teacherName = teacherName;
    this.teacherRole = teacherRole;
}

// Getters and setters
public String getTeacherId() {
    return teacherId;
}

public String getTeacherName() {
    return teacherName;
}

public String getTeacherRole() {
    return teacherRole;
}

public NurseryClass getAssignedClass() {
    return assignedClass;
}

public void setAssignedClass(NurseryClass assignedClass) {
    this.assignedClass = assignedClass;
}

@Override
public String toString() {
    return "Teacher [ID: " + teacherId + ", Name: " + teacherName +
            ", Role: " + teacherRole + ", Assigned to: " +
            (assignedClass != null ? assignedClass.getClassName() : "None") + "]";
}
}

