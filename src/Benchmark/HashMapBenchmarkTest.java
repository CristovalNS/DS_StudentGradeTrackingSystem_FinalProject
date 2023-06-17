package Benchmark;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class HashMapBenchmarkTest {
    private static HashMap<Integer, Classes> classMap = new HashMap<>();
    private static int classIdCounter = 1;

    static class Classes {
        private String className;
        private HashMap<String, Student> studentsMap;

        public Classes(int classIdCounter, String className) {
            this.className = className;
            this.studentsMap = new HashMap<>();
        }

        public String getClassName() {
            return this.className;
        }

        public void setClassName(String className) {
            this.className = className;
        }

        public HashMap<String, Student> getStudentsMap() {
            return studentsMap;
        }

        public void displayStudents() {
            System.out.println("Students in class " + className + ":");
            for (Student student : studentsMap.values()) {
                System.out.println("Student name: " + student.getStudentName() + ", Student grade: " + student.getStudentGrade());
            }
        }

        public void setStudentGrade(String studentName, String newGrade) {
            Student student = studentsMap.get(studentName);
            if (student != null) {
                student.setStudentGrade(newGrade);
//                System.out.println("Student grade modified successfully.");
            } else {
                System.out.println("Student not found: " + studentName);
            }
        }

        public void removeStudent(String studentName) {
            Student student = studentsMap.remove(studentName);
            if (student != null) {
//                System.out.println("Student removed successfully: " + student.getStudentName());
                return;
            } else {
                System.out.println("Student not found: " + studentName);
            }
        }
    }

    private static class Student {
        private String studentName;
        private String studentGrade;

        public Student(String studentName, String studentGrade) {
            this.studentName = studentName;
            this.studentGrade = studentGrade;
        }

        public String getStudentName() {
            return this.studentName;
        }

        public String getStudentGrade() {
            return this.studentGrade;
        }

        public void setStudentGrade(String studentGrade) {
            this.studentGrade = studentGrade;
        }

    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void addClass(String className) {
        Classes newClass = new Classes(classIdCounter, className);
        classMap.put(classIdCounter, newClass);
        classIdCounter++;
    }

    public void removeClass(int classNumber) {
        classMap.remove(classNumber);
    }


    public void addStudent(String className, String studentName, String studentGrade) {
        Classes targetClass = null;
        for (Classes classObj : classMap.values()) {
            if (classObj.getClassName().equals(className)) {
                targetClass = classObj;
                break;
            }
        }

        if (targetClass != null) {
            Student student = new Student(studentName, studentGrade);
            targetClass.getStudentsMap().put(studentName, student);
//            System.out.println("Student: " + studentName + " added successfully to class " + className + " with the grade: " + studentGrade );
        } else {
//            System.out.println("Class not found: " + className);
        }
    }

    public void setStudentGrade(String className, String studentName, String newGrade) {
        Classes targetClass = null;
        for (Classes classObj : classMap.values()) {
            if (classObj.getClassName().equals(className)) {
                targetClass = classObj;
                break;
            }
        }

        if (targetClass != null) {
            targetClass.setStudentGrade(studentName, newGrade);
//            System.out.println("Student: " + studentName + " in class " + className + " changed the grade to: " + studentGrade[0]);
        } else {
//            System.out.println("Class not found: " + className);
        }
    }

    public void viewClassDetails(String className) {
        Classes targetClass = null;
        for (Classes classObj : classMap.values()) {
            if (classObj.getClassName().equals(className)) {
                targetClass = classObj;
                break;
            }
        }

//        if (targetClass != null) {
//            System.out.println("Class Name: " + targetClass.getClassName());
//            targetClass.displayStudents();
//        } else {
//            System.out.println("Class not found: " + className);
//        }
    }

    public void removeStudent(String className2, String studentName) {
        Classes targetClass = null;
        for (Classes classObj : classMap.values()) {
            if (classObj.getClassName().equals(className2)) {
                targetClass = classObj;
                break;
            }
        }

//        if (targetClass != null) {
//            targetClass.removeStudent(studentName);
//        } else {
//            System.out.println("Class not found: " + className2);
//        }
    }


    public static void main(String[] args) {

        long startTime1, startTime2, startTime3, startTime4, startTime5, startTime6,
                endTime1, endTime2, endTime3, endTime4, endTime5, endTime6;
        int m, n, o, p, q, r;

        readClassData();
        readStudentData();

        Scanner read1 = new Scanner(System.in);
        System.out.println("\nBenchmarking performance of hashmap data structure");
        System.out.println("Benchmarking adding and removing classes: ");
        System.out.print("Enter a number of classes (n) to be added and removed to benchmark the speed: ");
        n = read1.nextInt();

        HashMapBenchmarkTest hashMap = new HashMapBenchmarkTest();
        for (int i = 0; i < n && i < classTracker; i++) {
            hashMap.addClass(className[i]);
        }

        // Hashmap Test Adding Class
//        System.out.println("\nHash Map: ");
        System.out.print("Adding class: ");
        startTime1 = System.nanoTime();
        for (int i = 0; i < n && i < classTracker; i++) {
            hashMap.addClass(className[i]);
        }
        endTime1 = System.nanoTime();
        getTime(startTime1, endTime1);

        // Hashmap Test Removing Class
//        System.out.println("\nHash Map: ");
        System.out.print("Removing class: ");
        startTime2 = System.nanoTime();
        for (int i = 0; i < n && i < classTracker; i++) {
            hashMap.removeClass(n);
        }
        endTime2 = System.nanoTime();
        getTime(startTime2, endTime2);

        // Hashmap Test Adding Students to Class
        System.out.println("\nBenchmarking adding students to classes: ");
        System.out.print("Enter a number of classes (o) to be added: ");
        o = read1.nextInt();

        System.out.print("Enter a number of students (m) to be added to class: ");
        m = read1.nextInt();

//        System.out.println("\nHash Map: ");
        System.out.print("Adding students to class: \n");
        startTime3 = System.nanoTime();

        for (int i = 0; i < o && i < classTracker; i++) {
            for (int x = 0; x < m && x < studentCount; x++) {
                hashMap.addStudent(className[i], studentName[x], studentGrade[x]);
            }
        }
        endTime3 = System.nanoTime();
        getTime(startTime3, endTime3);

        // HashMap Test Editing Students Grade
        System.out.println("\nBenchmarking editing students' grade: ");
        System.out.println("Number of classes: " + o);
        System.out.println("Number of students: " + m);
        System.out.println("Let's change their grades!");
        System.out.print("Changing grades to: ");
        p = read1.nextInt();

        startTime4 = System.nanoTime();

        for (int i = 0; i < o && i < classTracker; i++) {
            for (int x = 0; x < m && x < studentCount; x++) {
                hashMap.setStudentGrade(className[i], studentName[x], String.valueOf(p));

            }
        }

        endTime4 = System.nanoTime();
        getTime(startTime4, endTime4);

        // DEBUG: Display classes and students after editing student grade
//        System.out.println("\nClasses and Students:");
//        for (Classes classObj : hashMap.classMap.values()) {
//            String className = classObj.getClassName();
//            System.out.println("Class: " + className);
//            classObj.displayStudents();
//            System.out.println();
//        }

        // HashMap Test View Class Details
        System.out.println("\nBenchmarking view class details: ");
        System.out.println("\nWe are going to view the details of: " + o + " classes.");

        startTime5 = System.nanoTime();

        for (int i = 0; i < o && i < classTracker; i++) {
            hashMap.viewClassDetails(className[i]);
        }

        endTime5 = System.nanoTime();
        getTime(startTime5, endTime5);

        // HashMap Test Removing Students From Class
        System.out.println("\nBenchmarking removing students from classes: ");
        System.out.println("Number of classes: " + o);
        System.out.println("Number of students: " + m);
        System.out.println("Now... Let us delete some students from existence!");

        System.out.print("Select the amount of classes: ");
        q = read1.nextInt();

        System.out.print("Select the amount of students to delete: ");
        r = read1.nextInt();

        startTime6 = System.nanoTime();

        for (int i = 0; i < q && i < classTracker; i++) {
            for (int x = 0; x < r && x < studentCount; x++) {
                hashMap.removeStudent(className[i], studentName[x]);

            }
        }

        endTime6 = System.nanoTime();
        getTime(startTime6, endTime6);

        // DEBUG: Display classes and students after deletion
//        System.out.println("\nClasses and Students:");
//        for (Classes classObj : hashMap.classMap.values()) {
//            String className = classObj.getClassName();
//            System.out.println("Class: " + className);
//            classObj.displayStudents();
//            System.out.println();
//        }

        System.out.println("\nThat's the end of HashMap benchmark! ^-^");

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    }

    static void getTime(long startTime, long endTime) {
        double elapsedTime = (endTime - startTime) / 1_000_000.0;  //milliseconds
        System.out.println("Time used: " + elapsedTime + " millisecond(s)");
    }


    static String[] className = new String[150];

    // Counter variable to keep track of the number of users
    private static int classTracker = 0;

    public static void readClassData() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/Benchmark/classData.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("/");
                String name = parts[0];

                className[classTracker] = name;
                classTracker++;
            }
            reader.close();
            System.out.println(Arrays.toString(className));
        } catch (IOException e) {
            System.out.println("File not found.");
        }
    }

    static String[] studentName = new String[100];
    static String[] studentGrade = new String[100];


    // Counter variable to keep track of the number of users
    private static int studentCount = 0;

    public static void readStudentData() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/Benchmark/studentData.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("/");
                String name = parts[0];
                String grade = parts[1];

                studentName[studentCount] = name;
                studentGrade[studentCount] = grade;
                studentCount++;
            }
            reader.close();
            System.out.println(Arrays.toString(studentName));
            System.out.println(Arrays.toString(studentGrade));
        } catch (IOException e) {
            System.out.println("File not found.");
        }
    }

}

