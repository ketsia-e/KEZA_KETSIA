package Question2;


class Student {
    private String studentId;
    private String studentName;
    private int age;
    private String guardianName;
    private NurseryClass registeredClass;

    public Student(String studentId, String studentName, int age, String guardianName) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.guardianName = guardianName;
    }

    // Getters and setters
    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getAge() {
        return age;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public NurseryClass getRegisteredClass() {
        return registeredClass;
    }

    public void setRegisteredClass(NurseryClass registeredClass) {
        this.registeredClass = registeredClass;
    }

    @Override
    public String toString() {
        return "Student [ID: " + studentId + ", Name: " + studentName +
                ", Age: " + age + ", Guardian: " + guardianName +
                ", Class: " + (registeredClass != null ? registeredClass.getClassName() : "None") + "]";
    }
}



