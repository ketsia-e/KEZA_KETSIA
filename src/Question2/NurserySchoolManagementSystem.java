package Question2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NurserySchoolManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        BabyClass babyClass = new BabyClass("BC001");
        MiddleClass middleClass = new MiddleClass("MC001");
        TopClass topClass = new TopClass("TC001");


        Teacher teacher1 = new Teacher("T001", "Ms. Sarah", "Early Childhood Educator");
        Teacher teacher2 = new Teacher("T002", "Mr. John", "Assistant");
        Teacher teacher3 = new Teacher("T003", "Ms. Emily", "Senior Teacher");

        // Assign teachers to classes
        try {
            babyClass.setAssignedTeacher(teacher1); // Should work
            middleClass.setAssignedTeacher(teacher2); // Should work
            topClass.setAssignedTeacher(teacher3); // Should work
            // This should fail because Mr. John is not an Early Childhood Educator
            // babyClass.setAssignedTeacher(teacher2);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }


        Student student1 = new Student("S001", "Emma", 2, "Mrs. Thompson");
        Student student2 = new Student("S002", "Noah", 3, "Mr. Wilson");
        Student student3 = new Student("S003", "Olivia", 4, "Mrs. Brown");
        Student student4 = new Student("S004", "Liam", 5, "Mr. Davis");
        Student student5 = new Student("S005", "Ava", 3, "Mrs. Garcia");

        babyClass.enrollStudent(student1);
        middleClass.enrollStudent(student2);
        middleClass.enrollStudent(student5);
        topClass.enrollStudent(student3);

        // This should fail due to age restriction
        babyClass.enrollStudent(student3);

        // This should fail due to duplicate student ID if we try to enroll S001 again
        Student duplicateStudent = new Student("S001", "Duplicate", 2, "Someone");
        babyClass.enrollStudent(duplicateStudent);

        // Conduct activities
        babyClass.conductActivity("Finger Painting");
        babyClass.conductActivity("Music Time");
        middleClass.conductActivity("Storytelling");
        middleClass.conductActivity("Basic Counting");
        topClass.conductActivity("Alphabet Practice");
        topClass.conductActivity("Number Recognition");

        // Top class assessments
        topClass.conductAssessment("First Term");

        // Track progress
        babyClass.trackProgress();
        middleClass.trackProgress();
        topClass.trackProgress();

        // Generate and print reports
        System.out.println(babyClass.generateClassReport());
        System.out.println(middleClass.generateClassReport());
        System.out.println(topClass.generateClassReport());

        // Interactive menu
        boolean running = true;
        while (running) {
            System.out.println("\n===== NURSERY SCHOOL MANAGEMENT SYSTEM =====");
            System.out.println("1. Enroll a new student");
            System.out.println("2. Add a new teacher");
            System.out.println("3. Conduct an activity");
            System.out.println("4. Conduct an assessment (Top Class only)");
            System.out.println("5. Generate class reports");
            System.out.println("6. List all students");
            System.out.println("7. List all teachers");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    enrollNewStudent(scanner, babyClass, middleClass, topClass);
                    break;
                case 2:
                    addNewTeacher(scanner, babyClass, middleClass, topClass);
                    break;
                case 3:
                    conductActivity(scanner, babyClass, middleClass, topClass);
                    break;
                case 4:
                    System.out.print("Enter assessment term name: ");
                    String termName = scanner.nextLine();
                    topClass.conductAssessment(termName);
                    break;
                case 5:
                    System.out.println(babyClass.generateClassReport());
                    System.out.println(middleClass.generateClassReport());
                    System.out.println(topClass.generateClassReport());
                    break;
                case 6:
                    listAllStudents(babyClass, middleClass, topClass);
                    break;
                case 7:
                    System.out.println("Teachers:");
                    System.out.println(teacher1);
                    System.out.println(teacher2);
                    System.out.println(teacher3);
                    break;
                case 8:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Thank you for using the Nursery School Management System!");
        scanner.close();
    }

    private static void enrollNewStudent(Scanner scanner, BabyClass babyClass, MiddleClass middleClass, TopClass topClass) {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();

        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();

        System.out.print("Enter student age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter guardian name: ");
        String guardianName = scanner.nextLine();

        Student student = new Student(studentId, studentName, age, guardianName);

        System.out.println("Select class to enroll:");
        System.out.println("1. Baby Class (Ages 2-3)");
        System.out.println("2. Middle Class (Ages 3-4)");
        System.out.println("3. Top Class (Ages 4-5)");
        System.out.print("Enter your choice: ");

        int classChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (classChoice) {
            case 1:
                babyClass.enrollStudent(student);
                break;
            case 2:
                middleClass.enrollStudent(student);
                break;
            case 3:
                topClass.enrollStudent(student);
                break;
            default:
                System.out.println("Invalid choice. Student not enrolled.");
        }
    }

    private static void addNewTeacher(Scanner scanner, BabyClass babyClass, MiddleClass middleClass, TopClass topClass) {
        System.out.print("Enter teacher ID: ");
        String teacherId = scanner.nextLine();

        System.out.print("Enter teacher name: ");
        String teacherName = scanner.nextLine();

        System.out.println("Select teacher role:");
        System.out.println("1. Early Childhood Educator");
        System.out.println("2. Assistant");
        System.out.println("3. Senior Teacher");
        System.out.print("Enter your choice: ");

        int roleChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String teacherRole;
        switch (roleChoice) {
            case 1:
                teacherRole = "Early Childhood Educator";
                break;
            case 2:
                teacherRole = "Assistant";
                break;
            case 3:
                teacherRole = "Senior Teacher";
                break;
            default:
                System.out.println("Invalid choice. Using default role.");
                teacherRole = "Assistant";
        }

        Teacher teacher = new Teacher(teacherId, teacherName, teacherRole);

        System.out.println("Assign teacher to class:");
        System.out.println("1. Baby Class (requires Early Childhood Educator)");
        System.out.println("2. Middle Class");
        System.out.println("3. Top Class");
        System.out.print("Enter your choice: ");

        int classChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        try {
            switch (classChoice) {
                case 1:
                    babyClass.setAssignedTeacher(teacher);
                    break;
                case 2:
                    middleClass.setAssignedTeacher(teacher);
                    break;
                case 3:
                    topClass.setAssignedTeacher(teacher);
                    break;
                default:
                    System.out.println("Invalid choice. Teacher not assigned to any class.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void conductActivity(Scanner scanner, BabyClass babyClass, MiddleClass middleClass, TopClass topClass) {
        System.out.print("Enter activity name: ");
        String activityName = scanner.nextLine();

        System.out.println("Select class for activity:");
        System.out.println("1. Baby Class");
        System.out.println("2. Middle Class");
        System.out.println("3. Top Class");
        System.out.print("Enter your choice: ");

        int classChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (classChoice) {
            case 1:
                babyClass.conductActivity(activityName);
                break;
            case 2:
                middleClass.conductActivity(activityName);
                break;
            case 3:
                topClass.conductActivity(activityName);
                break;
            default:
                System.out.println("Invalid choice. Activity not conducted.");
        }
    }

    private static void listAllStudents(BabyClass babyClass, MiddleClass middleClass, TopClass topClass) {
        System.out.println("Baby Class Students:");
        for (Student student : babyClass.getStudents()) {
            System.out.println(student);
        }

        System.out.println("\nMiddle Class Students:");
        for (Student student : middleClass.getStudents()) {
            System.out.println(student);
        }

        System.out.println("\nTop Class Students:");
        for (Student student : topClass.getStudents()) {
            System.out.println(student);
        }
    }
}