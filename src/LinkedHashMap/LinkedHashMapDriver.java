package LinkedHashMap;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class LinkedHashMapDriver {
    private static LinkedHashMap<String, DS_LinkedHashMapTracker> classes;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        classes = new LinkedHashMap<>();

        boolean exit = false;

        while (!exit) {
            System.out.println("\nStudent Grade Tracking System Simulation Launched - DataStructure: LinkedHashMap");
            System.out.println("******************************");
            System.out.println("(1) Add class");
            System.out.println("(2) Remove class");
            System.out.println("(3) Edit class");
            System.out.println("(4) View class details");
            System.out.println("(0) Exit");
            System.out.println("******************************");
            System.out.print("Choose a command: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.println("Selected option 1\n");
                    addClass();
                }
                case 2 -> {
                    System.out.println("Selected option 2");
                    removeClass();
                }
                case 3 -> {
                    System.out.println("Selected option 3");
                    editClass(scanner);
                }
                case 4 -> {
                    System.out.println("Selected option 4");
                    viewClassDetails(scanner);
                }
                case 0 -> exit = true;
                default -> System.out.println("Invalid choice. Please input a valid option.");
            }
        }
    }

    private static void addClass() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of the class: ");
        String className = scanner.nextLine();
        DS_LinkedHashMapTracker classTracker = new DS_LinkedHashMapTracker();
        classTracker.setClassName(className);
        classes.put(className, classTracker);
        System.out.println("Class added successfully.");
    }

    private static void removeClass() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Classes listed: ");
        displayClasses();

        System.out.print("Enter the name of the class to remove: ");
        String className = scanner.nextLine();

        if (classes.containsKey(className)) {
            classes.remove(className);
            System.out.println("Class \"" + className + "\" removed successfully.");
        } else {
            System.out.println("Invalid class name.");
        }
    }

    private static void editClass(Scanner scanner) {
        System.out.println("Classes listed: ");
        displayClasses();

        System.out.print("Enter the name of the class to edit: ");
        String className = scanner.nextLine();

        if (classes.containsKey(className)) {
            DS_LinkedHashMapTracker classTracker = classes.get(className);
            System.out.println("Editing class: " + className);
            editStudentsInClass(classTracker, scanner);
        } else {
            System.out.println("Invalid class name.");
        }
    }

    private static void viewClassDetails(Scanner scanner) {
        System.out.println("Classes listed:");
        displayClasses();

        System.out.print("Enter the name of the class to view: ");
        String className = scanner.nextLine();

        if (classes.containsKey(className)) {
            DS_LinkedHashMapTracker classTracker = classes.get(className);
            System.out.println("Class: " + className);
            classTracker.printStudentGradesWithIndex();
        } else {
            System.out.println("Invalid class name.");
        }
    }

    private static void editStudentsInClass(DS_LinkedHashMapTracker classTracker, Scanner scanner) {
        boolean exit = false;

        while (!exit) {
            System.out.println("\nClass: " + classTracker.getClassName());
            System.out.println("******************************");
            System.out.println("(1) Add Student and Grade");
            System.out.println("(2) Add Student");
            System.out.println("(3) Edit Grade of Student");
            System.out.println("(4) Remove Student");
            System.out.println("(0) Return");
            System.out.println("******************************");
            System.out.print("Choose a command: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.println("Selected option 1");
                    addStudentAndGrade(classTracker, scanner);
                }
                case 2 -> {
                    System.out.println("Selected option 2");
                    addStudent(classTracker, scanner);
                }
                case 3 -> {
                    System.out.println("Selected option 3");
                    editStudentGrade(classTracker, scanner);
                }
                case 4 -> {
                    System.out.println("Selected option 4");
                    removeStudent(classTracker, scanner);
                }
                case 0 -> exit = true;
                default -> System.out.println("Invalid choice. Please input a valid option.");
            }
        }
    }

    private static void addStudentAndGrade(DS_LinkedHashMapTracker classTracker, Scanner scanner) {
        System.out.print("Enter the name of the student: ");
        String studentName = scanner.nextLine();
        System.out.print("Enter the grade of the student: ");
        int studentGrade = scanner.nextInt();
        scanner.nextLine();

        Student student = new Student(studentName);
        student.setGrade(studentGrade);
        classTracker.addStudent(student);

        System.out.println("Student and grade added successfully.");
    }

    private static void addStudent(DS_LinkedHashMapTracker classTracker, Scanner scanner) {
        System.out.print("Enter the name of the student: ");
        String studentName = scanner.nextLine();

        Student student = new Student(studentName);
        classTracker.addStudent(student);

        System.out.println("Student added successfully.");
    }

    private static void editStudentGrade(DS_LinkedHashMapTracker classTracker, Scanner scanner) {
        if (classTracker.getStudents().isEmpty()) {
            System.out.println("There are no students in the class.");
            return;
        }

        System.out.println("Students in the class:");
        int index = 1;
        for (String studentName : classTracker.getStudents().keySet()) {
            System.out.println("(" + index + ") " + studentName);
            index++;
        }

        System.out.print("Enter the index of the student to edit the grade: ");
        int studentIndex = scanner.nextInt();
        scanner.nextLine();

        if (studentIndex >= 1 && studentIndex <= classTracker.getStudents().size()) {
            String studentName = getStudentNameByIndex(classTracker, studentIndex);
            System.out.println("Editing grade for student: " + studentName);

            System.out.print("Enter the new grade for the student: ");
            int newGrade = scanner.nextInt();
            scanner.nextLine();

            Student student = classTracker.getStudents().get(studentName);
            student.setGrade(newGrade);

            System.out.println("Grade updated successfully.");
        } else {
            System.out.println("Invalid student index.");
        }
    }

    private static void removeStudent(DS_LinkedHashMapTracker classTracker, Scanner scanner) {
        if (classTracker.getStudents().isEmpty()) {
            System.out.println("There are no students in the class.");
            return;
        }

        System.out.println("Students in the class:");
        int index = 1;
        for (String studentName : classTracker.getStudents().keySet()) {
            System.out.println("(" + index + ") " + studentName);
            index++;
        }

        System.out.print("Enter the index of the student to remove: ");
        int studentIndex = scanner.nextInt();
        scanner.nextLine();

        if (studentIndex >= 1 && studentIndex <= classTracker.getStudents().size()) {
            String studentName = getStudentNameByIndex(classTracker, studentIndex);
            classTracker.removeStudent(classTracker.getStudents().get(studentName));
            System.out.println("Student \"" + studentName + "\" removed successfully.");
        } else {
            System.out.println("Invalid student index.");
        }
    }

    private static String getStudentNameByIndex(DS_LinkedHashMapTracker classTracker, int studentIndex) {
        int index = 1;
        for (String studentName : classTracker.getStudents().keySet()) {
            if (index == studentIndex) {
                return studentName;
            }
            index++;
        }
        return "";
    }

    private static void displayClasses() {
        if (classes.isEmpty()) {
            System.out.println("No classes available.");
            return;
        }

        int index = 1;
        for (String className : classes.keySet()) {
            System.out.println("(" + index + ") " + className);
            index++;
        }
    }
}
