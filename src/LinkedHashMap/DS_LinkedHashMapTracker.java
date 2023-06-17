package LinkedHashMap;

import java.util.LinkedHashMap;

public class DS_LinkedHashMapTracker {
    private String className;
    private LinkedHashMap<String, Student> studentList;

    public DS_LinkedHashMapTracker() {
        studentList = new LinkedHashMap<>();
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void addStudent(Student student) {
        studentList.put(student.getName(), student);
    }

    public void removeStudent(Student student) {
        studentList.remove(student.getName());
    }

    public LinkedHashMap<String, Student> getStudents() {
        return studentList;
    }

    public void printStudentGrades() {
        System.out.println("Student Grades (LinkedHashMap):");
        for (Student student : studentList.values()) {
            System.out.println(student.getName() + ": " + student.getGrade());
        }
    }

    public void printStudentGradesWithIndex() {
        System.out.println("Student Grades (LinkedHashMap):");
        int index = 1;
        for (Student student : studentList.values()) {
            System.out.println("(" + index + ") " + student.getName() + ": " + student.getGrade());
            index++;
        }
    }
}
