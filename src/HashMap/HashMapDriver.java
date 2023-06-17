package HashMap;

import java.util.*;

public class HashMapDriver {
    private static HashMap<String, DS_HashMapTracker> classes;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        classes = new HashMap<>();

        boolean exit = false;

        while (!exit) {
            System.out.println("\nStudent Grade Tracking System Simulation Launched - DataStructure: HashMap");
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
                System.out.println("Invalid choice. Please input a valid option.");
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
        DS_HashMapTracker classTracker = new DS_HashMapTracker();
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

    private static void editClass() {
        Scanner scanner = new Scanner(System.in);

        if (classes.isEmpty()) {
            System.out.println("No classes found. You need to add a class.");
            return;
        }

        System.out.println("Classes listed: ");
        displayClasses();

        System.out.print("Enter the name of the class to edit: ");
        String className = scanner.nextLine();

        if (classes.containsKey(className)) {
            DS_HashMapTracker classTracker = classes.get(className);
            System.out.println("Editing class: " + className);
            promptEditOptions(classTracker);
        } else {
            System.out.println("Invalid class name.");
        }
    }

    private static void viewClassDetails() {
        Scanner scanner = new Scanner(System.in);

        if (classes.isEmpty()) {
            System.out.println("No classes found. You need to add a class.");
            return;
        }

        System.out.println("Classes listed:");
        displayClasses();

        System.out.print("Enter the name of the class to view: ");
        String className = scanner.nextLine();

        if (classes.containsKey(className)) {
            DS_HashMapTracker classTracker = classes.get(className);
            System.out.println("Class: " + className);
            if (classTracker.getStudents().isEmpty()) {
                System.out.println("No students in the class.");
            } else {
                classTracker.printStudentGrades();
            }
        } else {
            System.out.println("Invalid class name.");
        }
    }

    private static void addStudents(DS_HashMapTracker classTracker) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students to add: ");
        int numStudents;
        try {
            numStudents = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Number of students should be an integer.");
            scanner.nextLine();
            return;
        }

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter the name of student " + (i + 1) + ": ");
            String studentName = scanner.nextLine();
            Student student = new Student(studentName);
            classTracker.addStudent(student);

            System.out.print("Enter the grade of student " + (i + 1) + ": ");
            int studentGrade;
            try {
                studentGrade = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Grade should be an integer.");
                return;
            }
            student.setGrade(studentGrade);

            System.out.println("Student and grade added successfully.");
        }
    }

    private static void promptEditOptions(DS_HashMapTracker classTracker) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nEdit Class Options");
            System.out.println("******************************");
            System.out.println("(1) Add Student and Grade");
            System.out.println("(2) Add Student");
            System.out.println("(3) Edit Grade of Student");
            System.out.println("(4) Remove Student");
            System.out.println("(0) Back To The Main Menu");
            System.out.println("******************************");
            System.out.print("Choose a command: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice. Please input a valid option.");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1 -> {
                    System.out.println("Selected option 1\n");
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
        }
    }

    private static void addStudentAndGrade(DS_HashMapTracker classTracker) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of the student: ");
        String studentName = scanner.nextLine();
        Student student = new Student(studentName);

        System.out.print("Enter the grade of the student: ");
        int studentGrade;
        try {
            studentGrade = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Grade should be an integer.");
            return;
        }
        student.setGrade(studentGrade);

        classTracker.addStudent(student);
        System.out.println("Student and grade added successfully.");
    }

    private static void addStudent(DS_HashMapTracker classTracker) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of the student: ");
        String studentName = scanner.nextLine();
        Student student = new Student(studentName);

        classTracker.addStudent(student);
        System.out.println("Student added successfully.");
    }

    private static void editStudentGrade(DS_HashMapTracker classTracker) {
        Scanner scanner = new Scanner(System.in);

        if (classTracker.getStudents().isEmpty()) {
            System.out.println("No students in the class.");
            return;
        }

        System.out.println("Students in the class:");
        classTracker.printStudentGrades();

        System.out.print("Enter the name of the student to edit: ");
        String studentName = scanner.nextLine();

        Student student = classTracker.getStudent(studentName);
        if (student != null) {
            System.out.print("Enter the new grade for the student: ");
            int newGrade;
            try {
                newGrade = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Grade should be an integer.");
                return;
            }
            student.setGrade(newGrade);

            System.out.println("Grade updated successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void removeStudent(DS_HashMapTracker classTracker) {
        Scanner scanner = new Scanner(System.in);

        if (classTracker.getStudents().isEmpty()) {
            System.out.println("No students in the class.");
            return;
        }

        System.out.println("Students in the class:");
        classTracker.printStudentGrades();

        System.out.print("Enter the name of the student to remove: ");
        String studentName = scanner.nextLine();

        Student student = classTracker.getStudent(studentName);
        if (student != null) {
            classTracker.removeStudent(student);
            System.out.println("Student \"" + studentName + "\" removed successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void displayClasses() {
        for (String className : classes.keySet()) {
            System.out.println(className);
        }
    }
}
