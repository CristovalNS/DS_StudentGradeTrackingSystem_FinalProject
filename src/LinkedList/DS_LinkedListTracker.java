package LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;

public class DS_LinkedListTracker {
    private String className;
    private LinkedList<Student> studentList;

    public DS_LinkedListTracker() {
        studentList = new LinkedList<>();
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public void removeStudent(Student student) {
        studentList.remove(student);
    }

    public String getStudents() {
        StringBuilder stringBuilder = new StringBuilder();
        int index = 1;
        for (Student student : studentList) {
            stringBuilder.append("(").append(index).append(") ").append(student.getName()).append(": ").append(student.getGrade()).append("\n");
            index++;
        }
        return stringBuilder.toString();
    }

    public LinkedList<Student> getStudentList() {
        return studentList;
    }
}