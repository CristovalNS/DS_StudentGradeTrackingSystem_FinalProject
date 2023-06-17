package LinkedList;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LinkedListDriver {
    private static List<DS_LinkedListTracker> classes;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        classes = new LinkedList<>();

        boolean exit = false;

        while (!exit) {
            System.out.println("\nStudent Grade Tracking System Simulation Launched - DataStructure: LinkedList");
            System.out.println("******************************");
            System.out.println("(1) Add class");
            System.out.println("(2) Remove class");
            System.out.println("(3) Edit class");
            System.out.println("(4) View class details");
            System.out.println("(0) Exit");
            System.out.println("******************************");
            System.out.print("Choose a command: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid command.");
                scanner.nextLine();
                continue;
            }

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
                    editClass();
                }
                case 4 -> {
                    System.out.println("Selected option 4");
                    viewClassDetails();
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
        DS_LinkedListTracker classTracker = new DS_LinkedListTracker();
        classTracker.setClassName(className);
        classes.add(classTracker);
        System.out.println("Class added successfully.");
    }

    private static void removeClass() {
        Scanner scanner = new Scanner(System.in);

        if (classes.isEmpty()) {
            System.out.println("No classes found. Please add a class.");
            return;
        }

        System.out.println("Classes listed: ");
        displayClasses();

        System.out.print("Enter the index of the class to remove: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index >= 0 && index < classes.size()) {
            DS_LinkedListTracker classTracker = classes.get(index);
            String className = classTracker.getClassName();
            classes.remove(classTracker);
            System.out.println("Class \"" + className + "\" removed successfully.");
        } else {
            System.out.println("Invalid class index.");
        }
    }

    private static void editClass() {
        Scanner scanner = new Scanner(System.in);

        if (classes.isEmpty()) {
            System.out.println("No classes found. Please add a class.");
            return;
        }

        System.out.println("Classes listed: ");
        displayClasses();

        System.out.print("Enter the index of the class to edit: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index >= 0 && index < classes.size()) {
            DS_LinkedListTracker classTracker = classes.get(index);
            String className = classTracker.getClassName();
            System.out.println("Editing class: " + className);

            boolean exit = false;

            while (!exit) {
                System.out.println("******************************");
                System.out.println("(1) Add Student and Grade");
                System.out.println("(2) Add Student");
                System.out.println("(3) Edit Grade of Student");
                System.out.println("(4) Remove Student");
                System.out.println("(0) Return");
                System.out.println("******************************");
                System.out.print("Choose a command: ");

                try {
                    int choice = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice) {
                        case 1 -> {
                            System.out.println("Selected option 1");
                            addStudentAndGrade(classTracker);
                        }
                        case 2 -> {
                            System.out.println("Selected option 2");
                            addStudent(classTracker);
                        }
                        case 3 -> {
                            System.out.println("Selected option 3");
                            editStudentGrade(classTracker);
                        }
                        case 4 -> {
                            System.out.println("Selected option 4");
                            removeStudent(classTracker);
                        }
                        case 0 -> exit = true;
                        default -> System.out.println("Invalid choice. Please input a valid option.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid option (index).");
                    scanner.nextLine(); // Clear the input buffer
                }
            }
        } else {
            System.out.println("Invalid class index.");
        }
    }

    private static void viewClassDetails() {
        Scanner scanner = new Scanner(System.in);

        if (classes.isEmpty()) {
            System.out.println("No classes found. Please add a class.");
            return;
        }

        System.out.println("Classes listed:");
        displayClasses();

        System.out.print("Enter the index of the class to view: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index >= 0 && index < classes.size()) {
            DS_LinkedListTracker classTracker = classes.get(index);
            System.out.println("Class: " + classTracker.getClassName());

            if (classTracker.getStudents().isEmpty()) {
                System.out.println("No students in the class.");
            } else {
                System.out.println(classTracker.getStudents());
            }
        } else {
            System.out.println("Invalid class index.");
        }
    }

    private static void addStudentAndGrade(DS_LinkedListTracker classTracker) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of the student: ");
        String studentName = scanner.nextLine();
        Student student = new Student(studentName);

        System.out.print("Enter the grade of the student: ");
        int studentGrade = scanner.nextInt();
        scanner.nextLine();
        student.setGrade(studentGrade);

        classTracker.addStudent(student);
        System.out.println("Student and grade added successfully.");
    }

    private static void addStudent(DS_LinkedListTracker classTracker) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of the student: ");
        String studentName = scanner.nextLine();
        Student student = new Student(studentName);

        classTracker.addStudent(student);
        System.out.println("Student added successfully.");
    }

    private static void editStudentGrade(DS_LinkedListTracker classTracker) {
        Scanner scanner = new Scanner(System.in);

        if (classTracker.getStudents().isEmpty()) {
            System.out.println("No students in the class.");
            return;
        }

        System.out.println(classTracker.getStudents());
        System.out.print("Enter the index of the student to edit: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index >= 0 && index < classTracker.getStudentList().size()) {
            Student student = classTracker.getStudentList().get(index);
            System.out.print("Enter the new grade of the student: ");
            int newGrade = scanner.nextInt();
            scanner.nextLine();
            student.setGrade(newGrade);
            System.out.println("Student grade updated successfully.");
        } else {
            System.out.println("Invalid student index.");
        }
    }

    private static void removeStudent(DS_LinkedListTracker classTracker) {
        Scanner scanner = new Scanner(System.in);

        if (classTracker.getStudents().isEmpty()) {
            System.out.println("No students in the class.");
            return;
        }

        System.out.println(classTracker.getStudents());
        System.out.print("Enter the index of the student to remove: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index >= 0 && index < classTracker.getStudentList().size()) {
            Student student = classTracker.getStudentList().get(index);
            classTracker.removeStudent(student);
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Invalid student index.");
        }
    }

    private static void displayClasses() {
        int index = 1;
        for (DS_LinkedListTracker classTracker : classes) {
            System.out.println(index + ". " + classTracker.getClassName());
            index++;
        }
    }

}
